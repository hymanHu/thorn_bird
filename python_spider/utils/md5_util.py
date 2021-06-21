#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
md5 utils
'''

# 将项目根目录添加到 sys.path，解决 cmd 下执行该模块找不到包的问题
import sys, os;
current_path = os.path.abspath(os.path.dirname(__file__));
separator = "\\" if os.name == "nt" else "/";
project_name = "python_spider" + separator;
root_path = current_path[:current_path.find(project_name) + len(project_name)];  # 获取项目根目录
sys.path.append(root_path);

import hashlib;

def get_md5(s, salt=""):
    s += salt;
    md5 = hashlib.md5(str(s).encode("utf-8"))
    return md5.hexdigest()

if __name__ == "__main__":
    print(get_md5("Hello World!", "hymanhu"))