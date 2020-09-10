#!/usr/bin/env python3
# -*- coding: utf-8 -*-
import datetime
import json

from django.core import serializers
from django.http import JsonResponse
from django.http import QueryDict
from django.shortcuts import render
from account.models import *
from common.result import *

__author__ = "HymanHu";

'''
Account views
'''

# Create your views here.
'''
127.0.0.1:8080/user ---- post
{"userName":"admin", "password":"111111"}
127.0.0.1:8080/user ---- put
{"userId":"4","userName":"hymanHu2", "password":"111111"}
'''
def user(request):
    # 获取查询参数 & form 表单参数
    # user_name = request.POST.get("userName")
    # password = request.POST.get("password")
    # 获取 json 数据
    user_dict = json.loads(request.body)
    user_id = user_dict.get("userId")
    user_name = user_dict.get("userName")
    password = user_dict.get("password")

    user = User(user_id=user_id, user_name=user_name, password=password, create_date=datetime.datetime.now())

    # 判断请求类型
    if request.method == "POST":
        user_temp = User.objects.filter(user_name=user_name).first()
        if user_temp:
            return JsonResponse(Result(500, "User name exit.").result())
        else:
            user.save()
            request.session["userId"] = user.user_id
            return JsonResponse(Result(200, "Insert Success.", user.user_dict()).result())
    elif request.method == "PUT":
        if user.user_id == None:
            return JsonResponse(Result(500, "User id is none").result())

        user_temp = User.objects.filter(user_id=user.user_id).first()
        if user_temp:
            user_temp.user_name = user.user_name
            user_temp.password = user.password
            user_temp.save()
            return JsonResponse(Result(200, "Update Success.", user.user_dict()).result())
        else:
            return JsonResponse(Result(500, "User not exit").result())
    else:
        return JsonResponse(Result(500, "Only support post and put request.").result())

'''
127.0.0.1:8080/user/1 ---- get | delete
'''
def user_(request, user_id):
    if request.method == "GET":
        user = User.objects.filter(user_id=user_id).first()
        # 序列化 user，需放入 list 中，而且 user 还包含其它属性
        # user_json = serializers.serialize("json", [user])
        # 返回 Json 数据，字典类型可直接返回，非字典类型需要反序列化，并且设置 safe=False 属性
        # 直接返回 json 字符串
        # return JsonResponse(user_json, safe=False)
        # 返回对象，需要用 json 加载为对象
        # return JsonResponse(json.loads(user_json), safe=False)
        # 返回 user 转 dict 数据
        return JsonResponse(user.user_dict())
    elif request.method == "DELETE":
        User.objects.filter(user_id=user_id).delete();
        return JsonResponse(Result(200, "Delete success.").result());