import subprocess
import glob
import shutil
import os
import json
import fcntl
import selectors
import sys
import collections

# submission to run
##csid = "xc70"
##psid = "ps04"

# status based on color code
statuses = {
	"\x1b\x5b\x33\x31\x6d": "fail",
	"\x1b\x5b\x33\x32\x6d": "success",
	"\x1b\x5b\x33\x36\x6d": "start_group",
	"\x1b\x5b\x33\x34\x6d": "start_test"
}

def main(csid, psid,
         junit_path="/usr/share/java/junit-platform-console-standalone-1.3.0-20180824.120151-233.jar",
         package_prefix="net.mrpaul.ads"):
    directory_prefix = package_prefix.replace(".", "/")

    # get inputs, outputs, arguments
    classes = collections.defaultdict(dict)
    for output in glob.glob(f"psets/{psid}/outputs/*"):
            classname = output.split("/")[-1]
            classes[classname]["output"] = open(output, "rb").read()
    for inputf in glob.glob(f"psets/{psid}/inputs/*"):
            classname = inputf.split("/")[-1]
            classes[classname]["input"] = open(inputf, "rb").read()
    for argument in glob.glob(f"psets/{psid}/arguments/*"):
            classname = argument.split("/")[-1]
            classes[classname]["arguments"] = open(argument).read().split("\n")

    # copy files from distribution if exists
    if os.path.isdir(f"psets/{psid}/distribution"):
            shutil.copytree(f"psets/{psid}/distribution", f"run")

    # copy submission to run
    shutil.copytree(f"submissions/{csid}/{psid}", f"run/src/{directory_prefix}/{csid}/{psid}")

    # if teacher defined junit
    if os.path.isdir(f"psets/{psid}/junit"):
            junits = glob.glob(f"psets/{psid}/junit/**/*.java", recursive=True)
            for junit in junits:
                    junit = junit.strip(f"psets/{psid}/junit/")
                    shutil.copy(f"psets/{psid}/junit/{junit}", f"run/src/{directory_prefix}/{csid}/{psid}/{junit}")
                    # change package name
                    junitfile = open(f"run/src/{directory_prefix}/{csid}/{psid}/{junit}").read().split("\n")
                    junitfile[0] = f"package {package_prefix}.{csid}.{psid};"
                    f = open(f"run/src/{directory_prefix}/{csid}/{psid}/{junit}", "w")
                    f.write("\n".join(junitfile))
                    f.close()

    # copy junit jar
    shutil.copy(junit_path, "run/junit.jar")

    # create docker volume and run
    vid = subprocess.check_output(["docker", "volume", "create"]).strip().decode("ascii")
    volpath = f"/var/lib/docker/volumes/{vid}/_data/"
    p = subprocess.Popen(["cp", "-r", "run", volpath])

    # create docker container
    p = subprocess.Popen(["docker", "run", "-td", "-v", f"{vid}:/mnt", "openjdk"], stdout=subprocess.PIPE, stdin=subprocess.PIPE)
    cid, error = p.communicate()
    cid = cid.strip().decode("ascii")
    command_prefix = ["docker", "exec", "-i", "-w", "/mnt/run", cid]

    # compile submission
    p = subprocess.Popen(command_prefix + ["javac", "-d", f"bin", "-cp", "junit.jar:lib/*"] + [path[len(f"{volpath}run/"):] for path in glob.glob(f"{volpath}run/src/**/*.java", recursive=True)], stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    out, err = p.communicate()
    if err:
            print(err.decode("ascii"))
            print('Compile failed.')
    else:
            # run junit for submission
            p = subprocess.Popen(command_prefix + ["java", "-jar", "junit.jar", "--class-path", f"bin:lib/*", "-p", f"{package_prefix}.{csid}.{psid}", "--details", "flat", "--details-theme", "ascii"], stdout=subprocess.PIPE, stderr=subprocess.PIPE)
            out, err = p.communicate()
            results = out.decode("ascii").split("\n")[1:]
            results = results[:results.index("Test execution finished.")]
            test_results = group = {}
            pgroups = []
            current = False
            # parse results
            for result in results:
                    try: status = statuses[result[:5]]
                    except: pass
                    if status == "start_group":
                            pgroups.append(group)
                            group[result[5+len("Started:     "):result.rindex(" ")]] = {}
                            group = group[result[5+len("Started:     "):result.rindex(" ")]]
                    elif status == "start_test":
                            current = result[5+len("Started:     "):result.rindex(" ")]
                    elif status == "success":
                            if current:
                                    group[current] = True
                                    current = False
                            else:
                                    group = pgroups.pop()
                    elif status == "fail":
                            if current:
                                    stacktrace = group[current] = []
                                    current = False
                            else:
                                    stacktrace.append(result[5:].strip(" "))
            print(json.dumps(test_results, indent=4))

            # check outputs
            for classname in classes:
                    out = b""
                    p = subprocess.Popen(command_prefix + ["java", "-cp", "bin:lib/*", f"{package_prefix}.{csid}.{psid}.{classname}"] + (classes[classname]["arguments"] if "arguments" in classes[classname] else []), stdin=subprocess.PIPE, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
                    # give input if provided
                    if classes[classname].get("input") != None:
                            p.stdin.write(classes[classname].get("input"))
                            p.stdin.flush()
                    # set files descriptors to nonblocking and create selectors
                    fcntl.fcntl(p.stdout, fcntl.F_SETFL, fcntl.fcntl(p.stdout, fcntl.F_GETFL) | os.O_NONBLOCK)
                    fcntl.fcntl(sys.stdin, fcntl.F_SETFL, fcntl.fcntl(sys.stdin, fcntl.F_GETFL) | os.O_NONBLOCK)
                    selector = selectors.DefaultSelector()
                    selector.register(sys.stdin, selectors.EVENT_READ, 'stdin')
                    selector.register(p.stdout, selectors.EVENT_READ, 'stdout')
                    # until the program has finished
                    while p.poll() == None:
                            events = selector.select()
                            for key, mask in events:
                                    if key.data == 'stdin':
                                            # write input
                                            line = key.fileobj.readline()
                                            p.stdin.write(bytes(line, encoding="utf-8") + b"\n")
                                            p.stdin.flush()
                                    elif key.data == 'stdout':
                                            # print output
                                            output = key.fileobj.read()
                                            out += output
                                            sys.stdout.write(output.decode("utf-8"))
                                            sys.stdout.flush()
                    # get final output and/or error
                    output, error = p.communicate()
                    if output: out += output
                    if error:
                            sys.stdout.write(error.decode("ascii"))
                            sys.stdout.flush()
                    # check output if provided
                    if classes[classname].get("output") != None:
                            if out == classes[classname].get("output"): print("="*50+f"\n{classname} output is correct.\n"+"="*50)
                            else: print("="*50+f"\n{classname} output is incorrect.\n"+"="*50)

    # clean up
    subprocess.check_output(["docker", "container", "stop", cid])
    subprocess.check_output(["docker", "container", "rm", cid])
    subprocess.check_output(["docker", "volume", "rm", vid])
    selector.close()
    shutil.rmtree("run")
