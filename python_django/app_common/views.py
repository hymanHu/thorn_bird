#!/usr/bin/env python3
# -*- coding: utf-8 -*-

from django.shortcuts import render;

# common 相关页面
def dashboard_page(request):
    return render(request, "common/dashboard.html");