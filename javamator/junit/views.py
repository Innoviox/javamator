from django.shortcuts import render
from .models import Teacher
import requests

# Create your views here.
def login(req):
    succeeded = False
    for obj in Teacher.objects.all():
        if obj.name == req.POST['username'] and obj.assword == req.POST['password']:
            succeeded = True
    return render(req, "index.html", {'login': 'true', 'login_success': str(succeeded).lower()})

def create(req):
    succeeded = True
    print(dir(req))
    print(req.POST, req.GET)
    u, p = req.POST['username'], req.POST['password']
    for obj in Teacher.objects.all():
        if obj.name == u and obj.password == p:
            succeeded = False
    requests.post("/api/Teacher", data={'username': u, 'password': p})
    return render(req, "index.html", {'creation': 'true', 'create_success': str(succeeded).lower()})