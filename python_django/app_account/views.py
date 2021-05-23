#!/usr/bin/env python3
# -*- coding: utf-8 -*-

from django.shortcuts import render, redirect;
from django.http import JsonResponse;
from app_common.PageVo import *;
from app_account.models import *;
import json;
from util import md5_util
from django.db.models import Q;
from django.core.paginator import Paginator, PageNotAnInteger, EmptyPage;

# account 相关页面
def login_page(request):
    return render(request, "account/login.html");

def logout(request):
    return redirect("/login");

def users_page(request):
    return render(request, "account/users.html");

# user 相关接口
# 127.0.0.1/api/user/1 ---- get | delete
def user_get_delete(request, user_id):
    if request.method == "GET":
        user = User.objects.get(id=user_id);
        return JsonResponse(user.user_dict());
    elif request.method == "DELETE":
        User.objects.filter(id=user_id).delete();
        return JsonResponse(Result(200, "Delete success.").result());
    else:
        return JsonResponse(Result(500, "Unsurport request method.").result());

# 127.0.0.1/api/user ---- post | put
def user_post_update(request):
    if request.method == "POST":
        user_dict = json.loads(request.body);
        user = User(user_name=user_dict.get("userName"), email=user_dict.get("email"),
                    password=md5_util.get_md5(user_dict.get("password")));
        user.save();
        return JsonResponse(Result(200, "Insert success.", user.user_dict()).result());
    elif request.method == "PUT":
        user_dict = json.loads(request.body);
        user = User.objects.get(id=user_dict.get("id"));
        user.user_name = user_dict.get("userName");
        user.password = md5_util.get_md5(user_dict.get("password"));
        user.email = user_dict.get("email");
        user.save();
        return JsonResponse(Result(200, "Update success.", user.user_dict()).result());
    else:
        return JsonResponse(Result(500, "Unsurport request method.").result());

# 127.0.0.1/api/login ---- post
def login(request):
    if request.method == "POST":
        user_dict = json.loads(request.body);
        print(user_dict)
        user = User.objects.filter(user_name=user_dict.get("userName"),
                                   password=md5_util.get_md5(user_dict.get("password"))).first();
        if user:
            request.session["user"] = user.user_dict();
            return JsonResponse(Result(200, "Login success.", user.user_dict()).result());
        else:
            return JsonResponse(Result(500, "User name or password is error.").result());
    else:
        return JsonResponse(Result(500, "Unsurport request method.").result());

# 127.0.0.1/api/users ---- post
def users(request):
    if request.method == "POST":
        # 从 request 中获取 search 对象
        search_vo = Search_Vo(json.loads(request.body));

        # 根据 keyword && order by 查询所有的对象
        # 多个字段模糊查询，Q(字段名1__icontains=keyword) | Q(字段名2__icontains=keyword)
        # icontains、contains 区别：是否大小写敏感
        users = User.objects.filter(Q(user_name__icontains=search_vo.keyWord) |
                            Q(email__icontains=search_vo.keyWord)).order_by(search_vo.order_by);

        # 初始化 Paginator 对象，用 Paginator 对象进行分页
        paginator = Paginator(users, search_vo.page_size);
        try:
            users = paginator.page(search_vo.current_page);
        except PageNotAnInteger:
            search_vo.current_page = 1;
            users = paginator.page(1);
        except EmptyPage:
            search_vo.current_page = paginator.num_pages;
            users = paginator.page(paginator.num_pages);

        # 返回 Page_Info 的 dict
        user_list = list(user.user_dict() for user in users.object_list);
        return JsonResponse(Page_Info(total=paginator.count, pages=paginator.num_pages,
                                      current_page=search_vo.current_page, page_size=search_vo.page_size,
                                      list=user_list).result());
    else:
        return JsonResponse(Result(500, "Unsurport request method.").result());
