from rest_framework import viewsets
from .models import JUnit
from .serializers import JUnitSerializer

class JUnitViewSet(viewsets.ModelViewSet):
    queryset = JUnit.objects.all()
    serializer_class = JUnitSerializer