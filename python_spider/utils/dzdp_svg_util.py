#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
大众点评 svg 文件解密工具
'''
import re;

# 读取 css 文件，将所有的 class 及其对应的坐标取出
def init_svg_class_map():
    svg_class_map = {};
    with open(file="../_dzdp/css_file.css", mode="r", encoding="utf-8") as f:
        content = f.read();
        # 在此只做了一套 css 文件解密，若网站更换了 css，则需要添加不同的规则
        for item in re.findall("\.(qx\w+)\{background\:-(\d+)\.0px -(\d+)\.0px\;\}", content):
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
    x, y = svg_class_map.get(clazz);
    # print(x, y);
    for svg in svg_list:
        y_svg, words = svg;
        if y_svg > y:
            word = words[int(x / 14)];
            break;
    # print(word);
    return word;

if __name__ == "__main__":
    svg_class_map = init_svg_class_map();
    svg_list = init_svg_list();
    decode_svg("vltvo3", svg_class_map, svg_list);