#!/usr/bin/env python3
# -*- coding: utf-8 -*-
import os

'''
保存小说章节内容到本地文件
'''

__author__ = "HymanHu";

base_path = "/download/novel"
def novel_save(novel_name, lines):
    if not os.path.exists(base_path):
        os.makedirs(base_path)

    with open("%s/%s.txt"%(base_path, novel_name), "a", encoding="UTF-8") as f:
        for line in lines:
            f.write(line + "\n")