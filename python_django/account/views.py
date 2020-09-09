#!/usr/bin/env python3
# -*- coding: utf-8 -*-
import datetime

from django.http import JsonResponse
from django.shortcuts import render
from account.models import *
from common.result import *

__author__ = "HymanHu";

'''
Account views
'''

# Create your views here.
'''
127.0.0.1:8080/register ---- post
{"userName":"admin", "password":"111111"}
'''
def register(request):
    # 判断请求类型
    if request.method == "POST":
        # 获取查询参数 & form 表单参数
        user_name = request.POST.get("userName")
        password = request.POST.get("password")
        print(user_name, password)
        user = User(user_name=user_name, password=password, create_date=datetime.datetime.now())
        # user.save()

        # 保存 user
        request.session["userId"] = user.id

        # 转换非字典型数据，需要设置 safe 为 false，否则抛出错误
        # 返回 Json 数据，字典类型可直接返回，class 类型需要反序列化
        return JsonResponse(Result(200, "Insert Success.", user.user_dict()), safe=False)

