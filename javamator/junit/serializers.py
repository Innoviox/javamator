from rest_framework import serializers
from .models import JUnit


class JUnitSerializer(serializers.ModelSerializer):
    class Meta:
        model = JUnit
        fields = '__all__'