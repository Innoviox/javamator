from django.db import models

# Create your models here.
class JUnit(models.Model):
    class_name = models.CharField(max_length=250)
    package_name = models.CharField(max_length=250)
    body = models.TextField()

class Teacher(models.Model):
    name = models.CharField(max_length=30)
    password = models.CharField(max_length=30)
