from rest_framework import routers
from junit.viewsets import JUnitViewSet

router = routers.DefaultRouter()
router.register(r'JUnit', JUnitViewSet)