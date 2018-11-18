from rest_framework import serializers
from .models import JUnit, Teacher


class JUnitSerializer(serializers.ModelSerializer):
    class Meta:
        model = JUnit
        fields = '__all__'


class TeacherSerializer(serializers.ModelSerializer):
    class Meta:
        model = Teacher
        fields = '__all__'
