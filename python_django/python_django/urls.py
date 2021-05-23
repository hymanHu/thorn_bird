#!/usr/bin/env python3
# -*- coding: utf-8 -*-

from django.contrib import admin;
from django.urls import path, re_path;
from app_test import views as test_views;
from app_account import views as account_views;
from app_common import views as common_views;
from app_spider import views as spider_views;


urlpatterns = [
    path('admin/', admin.site.urls),

    # ---- app_test ----
    re_path(r'^api/helloWorld$', test_views.hello_world),
    re_path(r'^api/json$', test_views.json_test),
    re_path(r'^test/jinja2Index$', test_views.jinja2_index),

    # ---- app_common ----
    re_path(r'^common/dashboard$', common_views.dashboard_page),

    # ---- app_account ----
    re_path(r'^login$', account_views.login_page),
    re_path(r'^logout$', account_views.logout),
    re_path(r'^account/users$', account_views.users_page),
    re_path(r'^api/login$', account_views.login),
    re_path(r'^api/user$', account_views.user_post_update),
    re_path(r'^api/user/(\d+)$', account_views.user_get_delete),
    re_path(r'^api/users$', account_views.users),

    # ---- app_spider ----
    re_path(r'^api/coronavirusList$', spider_views.get_coronavirus_list),

]
