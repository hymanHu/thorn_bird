#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
大众点评 woff 文件解密工具
'''

# 将项目根目录添加到 sys.path，解决 cmd 下执行该模块找不到包的问题
import sys, os;
current_path = os.path.abspath(os.path.dirname(__file__));
separator = "\\" if os.name == "nt" else "/";
project_name = "python_spider" + separator;
root_path = current_path[:current_path.find(project_name) + len(project_name)];  # 获取项目根目录
sys.path.append(root_path);

# from fontTools.ttLib import TTFont;

def read_woff(file_path):
    # # 读取 woff 文件
    # font = TTFont(file_path);
    # # 转化为 xml 文件
    # # font.saveXML(file_path.replace("woff", "xml"));
    # # 读取所有节点
    # print(font.keys());
    pass;

if __name__ == "__main__":
    read_woff("../_dzdp/woff_file_0.woff");