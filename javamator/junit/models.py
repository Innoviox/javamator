from django.db import models

# Create your models here.
class JUnit(models.Model):
    class_name = models.CharField(max_length=250)
    package_name = models.CharField(max_length=250)
    body = models.TextField()
