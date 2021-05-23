#!/usr/bin/env python3
# -*- coding: utf-8 -*-
from django.db import models

'''
Spider models
'''

__author__ = "HymanHu";

# Create your models here.
class Coronavirus(models.Model):
    id = models.AutoField(primary_key=True)
    date = models.CharField(max_length=20, blank = True, null = True)
    region = models.CharField(max_length=20, blank = True, null = True)
    diagnosis = models.IntegerField(blank = True, null = True)
    overseas_import = models.IntegerField(blank = True, null = True)
    cure = models.IntegerField(blank = True, null = True)
    death = models.IntegerField(blank = True, null = True)
    therapy = models.IntegerField(blank = True, null = True)
    observation = models.IntegerField(blank = True, null = True)

    # 将 class 转 dict，方便接口返回数据
    # 原生的 __dict__ 属性包含有 内置对象，无法直接丢给 JsonResponse
    def coronavirus_dict(self):
        epidemic_dict = {}
        epidemic_dict["id"] = self.id
        epidemic_dict["date"] = self.date
        epidemic_dict["region"] = self.region
        epidemic_dict["diagnosis"] = self.diagnosis
        epidemic_dict["overseasImport"] = self.overseas_import
        epidemic_dict["cure"] = self.cure
        epidemic_dict["death"] = self.death
        epidemic_dict["therapy"] = self.therapy
        epidemic_dict["observation"] = self.observation
        return epidemic_dict

    # 指定表名，若不指定，默认生成表名为：app名称_类名，比如gzbd_epidemic
    class Meta:
        db_table = ('spider_coronavirus')
