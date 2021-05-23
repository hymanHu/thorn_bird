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
from app_spider.models import *;


# Coronavirus 相关接口
# 127.0.0.1/api/coronavirusList ---- get
def get_coronavirus_list(request):
    if request.method == "GET":
        coronavirus_list = Coronavirus.objects.order_by("-date").all()[0:6];
        return JsonResponse(list(item.coronavirus_dict() for item in coronavirus_list), safe=False);
    else:
        return JsonResponse(Result(500, "Unsurport request method.").result());
