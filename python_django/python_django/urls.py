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
import account.views

__author__ = "HymanHu";

urlpatterns = [
    path('admin/', admin.site.urls),
    # ---- account ----
    re_path(r'^user$', account.views.user),
    re_path(r'^user/(?P<user_id>\d+)$', account.views.user_),
]
