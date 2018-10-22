from rest_framework import viewsets,filters
from .models import JUnit
from .serializers import JUnitSerializer

class JUnitViewSet(viewsets.ModelViewSet):
    queryset = JUnit.objects.all()
    serializer_class = JUnitSerializer
    filter_backends = (filters.SearchFilter,)
    search_fields = ('class_name', 'package_name', 'body')