#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""python_django URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/2.0/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path, re_path
from app_account import views as account_views
from app_spider import views as spider_views

urlpatterns = [
    path('admin/', admin.site.urls),
    # ==== account ====
    re_path(r'^helloWorld$', account_views.hello_world),
    re_path(r'^account/test$', account_views.account_test),
    re_path(r'^register$', account_views.register),
    re_path(r'^login$', account_views.login),
    re_path(r'^logout$', account_views.logout),
    re_path(r'^account/user/(\d+)$', account_views.user),
    re_path(r'^account/user$', account_views.user_),
    re_path(r'^account/users$', account_views.users),
    # ==== spider ====
    re_path(r'^spider/universities$', spider_views.universities),
    re_path(r'^spider/gzbd$', spider_views.gzbd_graph),
    re_path(r'^spider/coronavirus$', spider_views.coronavirus),
]