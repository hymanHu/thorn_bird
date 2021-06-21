#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
大众点评 svg 文件解密工具
'''

# 将项目根目录添加到 sys.path，解决 cmd 下执行该模块找不到包的问题
import sys, os;
current_path = os.path.abspath(os.path.dirname(__file__));
separator = "\\" if os.name == "nt" else "/";
project_name = "python_spider" + separator;
root_path = current_path[:current_path.find(project_name) + len(project_name)];  # 获取项目根目录
sys.path.append(root_path);

import re;

# 读取 css 文件，将所有的 class 及其对应的坐标取出
def init_svg_class_map():
    svg_class_map = {};
    with open(file="../_dzdp/css_file.css", mode="r", encoding="utf-8") as f:
        content = f.read();

        for item in re.findall("\.(.*?)\{background\:-(\d+)\.0px -(\d+)\.0px\;\}", content):
            clazz, x, y = item;
            svg_class_map[clazz] = [int(x), int(y)];

    print(svg_class_map);
    return svg_class_map;

# 初始化 svg 列表
def init_svg_list():
    l = [];
    with open(file='../_dzdp/svg_file.svg', mode='r', encoding='utf-8') as f:
        svg_result = f.read();
        items = re.findall('<text x="(\d+)" y="(\d+)">(.*?)</text>', svg_result);
        for item in items:
            x, y, words = item;
            l.append([int(x), int(y), words]);

        items = re.findall('<textPath xlink:href="#(\d+)" textLength="(\d+)">(.*?)</textPath>', svg_result);
        for item in items:
            index, length, words = item;
            y = re.findall('<path id="' + index + '" d="M0 (\d+) H600"/>', svg_result)[0];
            l.append([0, int(y), words]);
    print(l);
    return l;

# svg 解密
def decode_svg(clazz, svg_class_map, svg_list):
    word = "";
    if svg_class_map.__contains__(clazz):
        x, y = svg_class_map.get(clazz);
        # print(x, y);
        for svg in svg_list:
            x_svg, y_svg, words = svg;
            if y_svg >= y:
                word = words[int(x / 14)];
                break;
    # print(word);
    return word;

if __name__ == "__main__":
    svg_class_map = init_svg_class_map();
    svg_list = init_svg_list();
    word = decode_svg("lfdjc", svg_class_map, svg_list);
    print(word);