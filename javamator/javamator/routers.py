from rest_framework import routers
from junit.viewsets import JUnitViewSet, TeacherViewSet

router = routers.DefaultRouter()
router.register(r'JUnit', JUnitViewSet)
router.register(r'Teacher', TeacherViewSet)