#!/usr/bin/env python3
# -*- coding: utf-8 -*-

'''
Spider views
'''
import json

from django.core.paginator import Paginator, PageNotAnInteger, EmptyPage
from django.http import JsonResponse
from django.shortcuts import render

from app_spider.models import *
from common.page_vo import *

__author__ = "HymanHu";

# Create your views here.
def universities(request):
    if request.method == "GET":
        context = {}
        return render(request, "spider/universities.html", context)
    elif request.method == "POST":
        search_vo = Search_Vo(json.loads(request.body))
        universities = University.objects.order_by(search_vo.order_by)
        paginator = Paginator(universities, search_vo.page_size)
        try:
            universities = paginator.page(search_vo.current_page)
        except PageNotAnInteger:
            search_vo.current_page = 1
            universities = paginator.page(1)
        except EmptyPage:
            search_vo.current_page = paginator.num_pages
            universities = paginator.page(paginator.num_pages)

        universities_json = list(item.university_dict() for item in universities.object_list)
        page_info = Page_Info(paginator.count, paginator.num_pages, search_vo.current_page,
                              search_vo.page_size, universities_json)

        return JsonResponse(page_info.result())
    else:
        return JsonResponse(Result(500, "Unsupport this request").result())

