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
        db_table = ('coronavirus')

class University(models.Model):
    id = models.CharField(max_length=55, primary_key=True)
    school_name = models.CharField(max_length=55, blank = True, null = True)
    type = models.CharField(max_length=55, blank = True, null = True)
    level = models.CharField(max_length=55, blank = True, null = True)
    nature = models.CharField(max_length=55, blank = True, null = True)
    belong = models.CharField(max_length=55, blank = True, null = True)
    central = models.IntegerField(blank = True, null = True)
    department = models.IntegerField(blank = True, null = True)
    doublehigh = models.IntegerField(blank = True, null = True)
    f211 = models.IntegerField(blank = True, null = True)
    f985 = models.IntegerField(blank = True, null = True)
    is_recruitment = models.IntegerField(blank = True, null = True)
    dual_class = models.CharField(max_length=55, blank = True, null = True)
    address = models.CharField(max_length=255, blank = True, null = True)
    province_name = models.CharField(max_length=55, blank = True, null = True)
    single_province = models.CharField(max_length=55, blank = True, null = True)
    city_name = models.CharField(max_length=55, blank = True, null = True)
    county_name = models.CharField(max_length=55, blank = True, null = True)
    view_total_number = models.IntegerField(blank = True, null = True)

    def university_dict(self):
        university_dict = {}
        university_dict["id"] = self.id
        university_dict["schoolName"] = self.school_name
        university_dict["type"] = self.type
        university_dict["level"] = self.level
        university_dict["nature"] = self.nature
        university_dict["belong"] = self.belong
        university_dict["central"] = self.central
        university_dict["department"] = self.department
        university_dict["doublehigh"] = self.doublehigh
        university_dict["f211"] = self.f211
        university_dict["f985"] = self.f985
        university_dict["isRecruitment"] = self.is_recruitment
        university_dict["dualClass"] = self.dual_class
        university_dict["address"] = self.address
        university_dict["provinceName"] = self.province_name
        university_dict["singleProvince"] = self.single_province
        university_dict["cityName"] = self.city_name
        university_dict["countyName"] = self.county_name
        university_dict["viewTotalNumber"] = self.view_total_number
        return university_dict

    class Meta:
        db_table = ('university')