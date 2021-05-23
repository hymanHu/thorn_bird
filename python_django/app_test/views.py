#!/usr/bin/env python3
# -*- coding: utf-8 -*-

from django.http import HttpResponse, JsonResponse;
from app_common.PageVo import *;
from django.shortcuts import render, redirect;
from datetime import datetime;

# jinja2 测试页
def jinja2_index(request):
    context = {};
    context["name"] = "Hujiang";
    context["name_list"] = ["Hujiang", "hyman", "balabala"];
    context["person"] = {"name":"Hujiang", "age":18, "sex":"man"};
    context["url"] = "http://www.baidu.com";
    context["a"] = "<a href='http://www.baidu.com'>点击跳转</a>";
    context["birthday"] = datetime.now();
    context["number"] = 2148;
    context["is_man"] = True;
    return render(request, "test/jinja2Index.html", context);

# 直接返回字符串接口
def hello_world(request):
    return HttpResponse("Hello World!");

# 返回 Json 数据的接口
def json_test(request):
    return JsonResponse(Result(200, "success", "balabalabala……").result());

