from django.shortcuts import render, redirect
from .models import Teacher, Project
import requests

global current
current = None
all_vars = {i: 'false' for i in ['login', 'login_success',
                                 'creation', 'create_success', 'linkfailed', 'needtologin']}


def with_vars(v):
    k = all_vars.copy()
    k.update(v)
    return k


def login(req):
    succeeded = False
    u, p = req.POST['name'], req.POST['password']
    for obj in Teacher.objects.all():
        if obj.name == u and obj.password == p:
            succeeded = True
    global current
    current = u
    redirect("/")
    return render(req, "index.html", with_vars({'current': current, 'login': 'true', 'login_success': str(succeeded).lower()}))


def create(req):
    succeeded = True
    print(dir(req))
    print(req.POST, req.GET)
    u, p = req.POST['name'], req.POST['password']
    for obj in Teacher.objects.all():
        if obj.name == u and obj.password == p:
            succeeded = False
    requests.post("api/Teacher", data={'name': u, 'password': p})
    global current
    current = u
    redirect("/")
    return render(req, "index.html", with_vars({'current': current, 'creation': 'true', 'create_success': str(succeeded).lower()}))


def manage(req):
    global current
    if current is None:
        return render(req, "index.html", with_vars({'linkfailed': 'true', 'needtologin': 'true'}))
    return render(req, "manage-junit.html", {'owner': current})


def manage_project(req, id):
    project = Project.objects.get(id=id)
