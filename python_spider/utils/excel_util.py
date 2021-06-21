#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
excel util
'''

# 将项目根目录添加到 sys.path，解决 cmd 下执行该模块找不到包的问题
import sys, os;
current_path = os.path.abspath(os.path.dirname(__file__));
separator = "\\" if os.name == "nt" else "/";
project_name = "python_spider" + separator;
root_path = current_path[:current_path.find(project_name) + len(project_name)];  # 获取项目根目录
sys.path.append(root_path);

import openpyxl;

def create_excel(header, body, file_path):
    # 获取 workbook 对象
    workbook = openpyxl.Workbook();
    # 获取 sheet 对象
    active_sheet = workbook.get_active_sheet();
    # 数据操作
    active_sheet.append(header);
    for item in body:
        active_sheet.append(item);
    # 文件保存
    workbook.save(filename=file_path);

if __name__ == "__main__":
    pass;