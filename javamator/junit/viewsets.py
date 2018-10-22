from rest_framework import viewsets,filters
from .models import JUnit, Teacher
from .serializers import JUnitSerializer, TeacherSerializer

class JUnitViewSet(viewsets.ModelViewSet):
    queryset = JUnit.objects.all()
    serializer_class = JUnitSerializer
    filter_backends = (filters.SearchFilter,)
    search_fields = ('class_name', 'package_name', 'body')

class TeacherViewSet(viewsets.ModelViewSet):
    queryset = Teacher.objects.all()
    serializer_class = TeacherSerializer
