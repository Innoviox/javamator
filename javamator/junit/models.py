from django.db import models

# Create your models here.


class JUnit(models.Model):
    class_name = models.CharField(max_length=250)
    package_name = models.CharField(max_length=250)
    body = models.TextField()
    owner = models.CharField(max_length=250)


class Teacher(models.Model):
    name = models.CharField(max_length=30)
    password = models.CharField(max_length=30)
    # projects = models.ManyToManyField(Project)


class Student(models.Model):
    name = models.CharField(max_length=30)
    password = models.CharField(max_length=30)
    # projects = models.ManyToManyField(Project)


class Project(models.Model):
    name = models.CharField(max_length=30)
    desc = models.CharField(max_length=100)
    owner = models.ForeignKey(Teacher, on_delete=models.CASCADE)
    students = models.ManyToManyField(Student)


Teacher.projects = models.ManyToManyField(Project)
Student.projects = models.ManyToManyField(Project)
