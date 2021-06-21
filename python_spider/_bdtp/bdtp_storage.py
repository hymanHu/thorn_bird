#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
保存百度图片
'''

# 将项目根目录添加到 sys.path，解决 cmd 下执行该模块找不到包的问题
import sys, os;
current_path = os.path.abspath(os.path.dirname(__file__));
separator = "\\" if os.name == "nt" else "/";
project_name = "python_spider" + separator;
root_path = current_path[:current_path.find(project_name) + len(project_name)];  # 获取项目根目录
sys.path.append(root_path);

from datetime import datetime;
import requests;

base_folder = "/download/";
def bdtu_storage(folderName, images):

    dict_folder = "%s%s"%(base_folder, folderName)
    if not os.path.exists(dict_folder):
        os.makedirs(dict_folder);

    for image in images:
        if image:
            image_path = "%s/%s_%s.%s"%(dict_folder, folderName, images.index(image), image.split(".")[-1]);
            r = requests.get(image);
            with open(image_path, 'wb') as f:
                f.write(r.content);

if __name__ == "__main__":
    pass;