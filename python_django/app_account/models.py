#!/usr/bin/env python3
# -*- coding: utf-8 -*-
import datetime
from django.db import models

__author__ = "HymanHu";

'''
Account models
'''

# Create your models here.
class User(models.Model):
    user_id = models.AutoField(primary_key=True)
    user_name = models.CharField(name="user_name", max_length=20, blank = True, null = True)
    password = models.CharField(max_length=20, blank = True, null = True)
    create_date = models.DateTimeField(auto_now=True, blank = True, null = True)

    # 将 class 转 dict，方便接口返回数据
    def user_dict(self):
        user_dict = {}
        user_dict["userId"] = self.user_id
        user_dict["userName"] = self.user_name
        user_dict["password"] = self.password
        user_dict["createDate"] = self.create_date
        return user_dict

    # 指定表名，若不指定，默认生成表名为：app名称_类名，比如account_user
    class Meta:
        db_table = ('user')