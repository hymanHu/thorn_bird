#!/usr/bin/env python3
# -*- coding: utf-8 -*-
'''
Account views
'''
import datetime
import json

from django.http import HttpResponse, JsonResponse
from django.shortcuts import render
from common.result import *
from app_account.models import User

__author__ = "HymanHu";

# Create your views here.
def hello_world(request):
    return HttpResponse("Hello World")

def register(request):
    if request.method == "GET":
        context = {}
        return render(request, "account/register.html", context)
    elif request.method == "POST":
        user_dict = json.loads(request.body)
        user_name = user_dict.get("userName")
        password = user_dict.get("password")
        user_temp = User.objects.filter(user_name = user_name).first()
        if not user_temp:
            user = User(user_name=user_name, password=password, create_date=datetime.datetime.now())
            user.save()
            return JsonResponse(Result(200, "Insert user success", user.user_dict()).result())
        else:
            return JsonResponse(Result(500, "User name already exists").result())
    else:
        return JsonResponse(Result(500, "Un support this request").result())

def login(request):
    if request.method == "GET":
        context = {}
        return render(request, "account/login.html", context)
    elif request.method == "POST":
        user_dict = json.loads(request.body)
        user_name = user_dict.get("userName")
        password = user_dict.get("password")
        user = User.objects.filter(user_name=user_name, password=password).first()
        if user:
            return JsonResponse(Result(200, "Login success.", user.user_dict()).result())
        else:
            return JsonResponse(Result(500, "User name or password error").result())
    else:
        return JsonResponse(Result(500, "Un support this request").result())

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
        return JsonResponse(Result(500, "Un support this request").result())

def user_(request):
    if request.method == "PUT":
        user_dict = json.loads(request.body)
        user_id = user_dict.get("userId")
        user_name = user_dict.get("userName")
        password = user_dict.get("password")
        user_temp = User.objects.filter(user_name=user_name).first()
        print(user_temp.user_name)
        if user_temp and user_temp.user_id == user_id:
            user = User(user_id=user_id,user_name=user_name, password=password)
            user.save()
            return JsonResponse(Result(200, "Update success", user.user_dict()).result())
        else:
            return JsonResponse(Result(500, "Error").result())