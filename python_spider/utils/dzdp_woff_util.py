#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
大众点评 woff 文件解密工具
'''

from fontTools.ttLib import TTFont;

def read_woff(file_path):
    # 读取 woff 文件
    font = TTFont(file_path);
    # 转化为 xml 文件
    # font.saveXML(file_path.replace("woff", "xml"));
    # 读取所有节点
    print(font.keys());

if __name__ == "__main__":
    read_woff("../_dzdp/woff_file_0.woff");