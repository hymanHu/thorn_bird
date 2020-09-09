#!/usr/bin/env python3
# -*- coding: utf-8 -*-
from django.db import models

__author__ = "HymanHu";

'''
GZBD models
'''

# Create your models here.
class Epidemic(models.Model):
    id = models.AutoField(primary_key=True)
    region = models.CharField(max_length=20, blank = True, null = True)
    date = models.CharField(max_length=20, blank = True, null = True)
    diagnosis = models.IntegerField(blank = True, null = True)
    overseas_import = models.IntegerField(blank = True, null = True)
    cure = models.IntegerField(blank = True, null = True)
    death = models.IntegerField(blank = True, null = True)
    therapy = models.IntegerField(blank = True, null = True)
    observation = models.IntegerField(blank = True, null = True)

    # 指定表名，若不指定，默认生成表名为：app名称_类名，比如gzbd_epidemic
    class Meta:
        db_table = ('epidemic')