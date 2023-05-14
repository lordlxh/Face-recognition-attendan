from django.contrib import admin
from django.urls import path
from django import urls
from django.conf.urls import url,include

from app1 import views

urlpatterns = [
    url(r'home/$',views.home),
    url(r'solve/$',views.solve),
    url(r'upload/$',views.upload),
    url(r'rec/$',views.rec),
    url(r'test/$',views.test),
]