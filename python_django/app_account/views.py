#!/usr/bin/env python3
# -*- coding: utf-8 -*-
'''
Account views
'''
import datetime;
import json;
from django.core import serializers;
from django.core.paginator import Paginator, PageNotAnInteger, EmptyPage;
from django.http import HttpResponse, JsonResponse;
from django.shortcuts import render, redirect;
from common.page_vo import *;
from common.md5_util import *;
from django.db.models import Q;
from app_account.models import User;

__author__ = "HymanHu";

# Create your views here.
def hello_world(request):
    return HttpResponse("Hello World")

def account_test(request):
    context = {}
    context["name"] = "HymanHu"
    context["name_list"] = ["HymanHu", "HuJiang"]
    context["person"] = {"name": "HymanHu", "age": 40}
    context["url"] = "http://www.baidu.com"
    context["a"] = "<a href='http://www.baidu.com'>点击2</a>"
    context["birthday"] = datetime.datetime.now()
    context["number"] = 1024
    context["is_man"] = True
    return render(request, "account/test.html", context)

def register(request):
    if request.method == "GET":
        context = {}
        return render(request, "account/register.html", context)
    elif request.method == "POST":
        user_dict = json.loads(request.body)
        user_name = user_dict.get("userName")
        password = get_md5(user_dict.get("password"), user_dict.get("userName"))
        user_temp = User.objects.filter(user_name = user_name).first()
        if not user_temp:
            user = User(user_name=user_name, password=password, create_date=datetime.datetime.now())
            user.save()
            return JsonResponse(Result(200, "Insert user success", user.user_dict()).result())
        else:
            return JsonResponse(Result(500, "User name already exists").result())
    else:
        return JsonResponse(Result(500, "Unsupport this request").result())

def login(request):
    if request.method == "GET":
        context = {}
        return render(request, "account/login.html", context)
    elif request.method == "POST":
        user_dict = json.loads(request.body);
        user_name = user_dict.get("userName")
        password = get_md5(user_dict.get("password"), user_dict.get("userName"))
        user = User.objects.filter(user_name=user_name, password=password).first()
        if user:
            request.session["userId"] = user.user_id
            return JsonResponse(Result(200, "Login success.", user.user_dict()).result())
        else:
            return JsonResponse(Result(500, "User name or password error").result())
    else:
        return JsonResponse(Result(500, "Unsupport this request").result())

def logout(request):
    del request.session["userId"]
    return redirect("/login")

def user(request, user_id):
    if request.method == "GET":
        user = User.objects.filter(user_id=user_id).first()
        if user:
            return JsonResponse(Result(200, "Success", user.user_dict()).result())
        else:
            return JsonResponse(Result(500, "No return").result())
    elif request.method == "DELETE":
        User.objects.filter(user_id=user_id).delete()
        return JsonResponse(Result(200, "Delete success.").result())
    else:
        return JsonResponse(Result(500, "Unsupport this request").result())

def user_(request):
    if request.method == "PUT":
        user_dict = json.loads(request.body)
        user_id = user_dict.get("userId")
        user_name = user_dict.get("userName")
        password = get_md5(user_dict.get("password"), user_dict.get("userName"))
        user_temp = User.objects.filter(user_name=user_name).first()
        if not user_temp or (user_temp and user_temp.user_id == user_id):
            user = User(user_id=user_id,user_name=user_name, password=password)
            user.save()
            return JsonResponse(Result(200, "Update success", user.user_dict()).result())
        else:
            return JsonResponse(Result(500, "User name is repeat.").result())
    else:
        return JsonResponse(Result(500, "Unsupport this request").result())

def users(request):
    if request.method == "GET":
        context = {}
        return render(request, "account/users.html", context)
    elif request.method == "POST":
        # 从 request 中获取 search 对象
        search_vo = Search_Vo(json.loads(request.body))
        
        # 根据 keyword && order by 查询所有的对象
        # 多个字段模糊查询，Q(字段名1__icontains=keyword) | Q(字段名2__icontains=keyword)
        # icontains 或 contains，区别是是否大小写敏感，竖线是或的意思
        users = User.objects.filter(
                Q(user_name__icontains=search_vo.keyword)).order_by(search_vo.order_by)
                
         # 初始化 Paginator 对象，用 Paginator 对象进行分页
        paginator = Paginator(users, search_vo.page_size)
        try:
            users = paginator.page(search_vo.current_page)
        except PageNotAnInteger:
            search_vo.current_page = 1
            users = paginator.page(1)
        except EmptyPage:
            search_vo.current_page = paginator.num_pages
            users = paginator.page(paginator.num_pages)

        # 包装自定义的 page 对象，返回数据
        # users_json = json.loads(serializers.serialize("json", users.object_list))
        # users_json = list(users.object_list.values("user_id", "user_name", "password", "create_date"))
        users_json = list(item.user_dict() for item in users.object_list)
        page_info = Page_Info(paginator.count, paginator.num_pages, search_vo.current_page,
                  search_vo.page_size, users_json)

        return JsonResponse(page_info.result())
    else:
        return JsonResponse(Result(500, "Unsupport this request").result())