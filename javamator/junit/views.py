from django.shortcuts import render

# Create your views here.
def login(req):
    return render(req, "index.html", {'login': 'true', 'login_success': 'true'})