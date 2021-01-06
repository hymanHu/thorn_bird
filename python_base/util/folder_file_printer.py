#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

import os;

def get_file_str(level):
    return "   " * level + '- ';
def get_dic_str(level):
    return "   " * level + '+ ';

def print_files(path, level):
    if os.path.exists(path):
        if level == 0:
            print(get_dic_str(level) + os.path.basename(path));
            level += 1;

        files = os.listdir(path);
        for f in files:
            file_path = os.path.join(path, f); # 合成绝对路径
            if os.path.isfile(file_path):
                print(get_file_str(level) + os.path.basename(file_path));
            else:
                leveli = level + 1
                print(get_dic_str(level) + os.path.basename(file_path));
                print_files(file_path, leveli)

if __name__ == '__main__':
    print_files(r'D:\projectCode\ThornBird\py_spider', 0);