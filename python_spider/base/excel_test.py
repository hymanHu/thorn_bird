#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
excel test
'''

# 将项目根目录添加到 sys.path，解决 cmd 下执行该模块找不到包的问题
import sys, os;
current_path = os.path.abspath(os.path.dirname(__file__));
separator = "\\" if os.name == "nt" else "/";
project_name = "python_spider" + separator;
root_path = current_path[:current_path.find(project_name) + len(project_name)];  # 获取项目根目录
sys.path.append(root_path);

from utils import excel_util;
import random;

def write_excel():
    header = ["第一季度", "第二季度", "第三季度", "第四季度"];
    file_path = "/temp/excel_test.xlsx";
    body = list();
    for item in range(1, 10):
        line = list();
        for i in range(1, len(header) + 1):
            line.append(i * random.randint(1, 10));
        body.append(line);
    excel_util.create_excel(header, body, file_path);

if __name__ == "__main__":
    write_excel();