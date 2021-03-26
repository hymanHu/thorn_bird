#!/usr/bin/env python3
# -*- coding: utf-8 -*-

'''
Spider views
'''
import json

from django.core import serializers;
from django.core.paginator import Paginator, PageNotAnInteger, EmptyPage;
from django.http import JsonResponse;
from django.shortcuts import render;
from django.db.models import Q;
from app_spider.models import *;
from common.page_vo import *;

__author__ = "HymanHu";

# Create your views here.
def universities(request):
    if request.method == "GET":
        context = {}
        return render(request, "spider/universities.html", context)
    elif request.method == "POST":
        # 从 request 中获取 search 对象
        search_vo = Search_Vo(json.loads(request.body))
        
        # 根据 keyword && order by 查询所有的对象
        # 多个字段模糊查询，Q(字段名1__icontains=keyword) | Q(字段名2__icontains=keyword)
        # icontains 或 contains，区别是是否大小写敏感，竖线是或的意思
        universities = [];
        if search_vo.keyword:
            universities = University.objects.filter(
                Q(school_name__icontains=search_vo.keyword) |
                Q(address__icontains=search_vo.keyword)).order_by(search_vo.order_by);
        else:
            universities = University.objects.order_by(search_vo.order_by);
        
        # 初始化 Paginator 对象，用 Paginator 对象进行分页
        paginator = Paginator(universities, search_vo.page_size)
        try:
            universities = paginator.page(search_vo.current_page)
        except PageNotAnInteger:
            search_vo.current_page = 1
            universities = paginator.page(1)
        except EmptyPage:
            search_vo.current_page = paginator.num_pages
            universities = paginator.page(paginator.num_pages)

        # 包装自定义的 page 对象，返回数据
        universities_json = list(item.university_dict() for item in universities.object_list)
        page_info = Page_Info(paginator.count, paginator.num_pages, search_vo.current_page,
                              search_vo.page_size, universities_json)

        return JsonResponse(page_info.result())
    else:
        return JsonResponse(Result(500, "Unsupport this request").result())

def gzbd_graph(request):
    if request.method == "GET":
        context = {}
        return render(request, "spider/gzbd.html", context)

def coronavirus(request):
    if request.method == "GET":
        coronavirus = Coronavirus.objects.order_by("-date").all()[0:6]
        coronavirus_json = list(item.coronavirus_dict() for item in coronavirus)
        return JsonResponse(coronavirus_json, safe=False)

