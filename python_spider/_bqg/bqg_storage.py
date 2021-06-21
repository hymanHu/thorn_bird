#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
保存小说章节内容到本地文件
'''

# 将项目根目录添加到 sys.path，解决 cmd 下执行该模块找不到包的问题
import sys, os;
current_path = os.path.abspath(os.path.dirname(__file__));
separator = "\\" if os.name == "nt" else "/";
project_name = "python_spider" + separator;
root_path = current_path[:current_path.find(project_name) + len(project_name)];  # 获取项目根目录
sys.path.append(root_path);

import os;

base_path = "/download/novel";
def novel_save(novel_name, lines):
    if not os.path.exists(base_path):
        os.makedirs(base_path);

    with open("%s/%s.txt"%(base_path, novel_name), "a", encoding="UTF-8") as f:
        for line in lines:
            f.write(line + "\n");