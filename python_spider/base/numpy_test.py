#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
numpy test
'''

# 将项目根目录添加到 sys.path，解决 cmd 下执行该模块找不到包的问题
import sys, os;
current_path = os.path.abspath(os.path.dirname(__file__));
separator = "\\" if os.name == "nt" else "/";
project_name = "python_spider" + separator;
root_path = current_path[:current_path.find(project_name) + len(project_name)];  # 获取项目根目录
sys.path.append(root_path);

import numpy as np;

# 数据结构 ndarray
def ndarray_fun():
    # 创建数组方式一
    array = np.array(list(range(1, 10))); # 一维数组
    print(array);
    print(array.flags); # ndarray 对象的内存信息
    array = np.array([list(range(1, 5)), list(range(1, 5))]); # 二维数组
    print(array);
    array = np.array(list(range(1, 10)), ndmin=2, dtype=complex); # 设定属性，ndmin 指定最小维度、dtype 指定元素类型
    print(array);

    # 创建数组方式二
    array = np.arange(1, 10); # 一维数组
    print(array);
    array = np.arange(20).reshape(4, 5); # 二维数组，20 = 4 * 5，数据总数 = 行 * 列
    print(array);

    # 创建数组方式三，创建一个指定形状（shape）、数据类型（dtype）且未初始化的数组，C 行优先，F 列优先
    array = np.empty(shape=[2, 3], dtype=int, order="C");
    print(array);

    # 创建数组方式四，创建一个指定形状（shape）、数据类型（dtype）且用 0 填充数组，如果用 1 填充，调用 ones 函数
    array = np.zeros(shape=[2, 3], dtype=int, order="C");
    print(array);

# 索引和切片
def index_fun():
    array = np.arange(1, 10);
    print(array[2:7:2]); # 索引 2 - 7，间隔 2

    array = np.arange(20).reshape(4, 5);
    print(array[[1, 3, 2]]); # 行索引，返回对应行数据
    print(array[[0,1,2], [0,1,0]]); # 行列索引，返回 (0,0)、(1,1)、(2,0) 位置处的元素
    print(array[array > 5]); # 布尔索引

# 广播
def broadcast_fun():
    array_1 = np.arange(1, 9);
    array_2 = np.arange(1, 9);
    print(array_1 + array_2); # 维度一致，长度一致，自动运算

    array_1 = np.arange(20).reshape(4, 5);
    array_2 = np.arange(1, 6);
    print(array_1 + array_2); # 维度不同，列一致，自动运算

# 排序
def order_fun():
    array = np.arange(20).reshape(4, 5);
    print(np.sort(array, axis=1, kind="mergesort")); # 按行正序排列，算法归并排序
    print(-np.sort(-array, axis=1, kind="mergesort")); # 按行倒序排列，算法归并排序

# 统计
def desc_fun():
    array = np.arange(20).reshape(4, 5);
    print(array);
    print(np.amin(array, axis=1)); # 按行取最小值
    print(np.amin(array, axis=1)); # 按行取最大值
    print(np.ptp(array, axis=1)); # 按行计算最大值与最小值差值
    print(np.median(array, axis=1)); # 按行计算中位数
    print(np.mean(array, axis=1));# 按行计算平均数
    print(np.average(array, axis=1)); # 按行计算平均数,可加权重

if __name__ == "__main__":
    # ndarray_fun();
    # index_fun();
    # broadcast_fun();
    order_fun();
    # desc_fun();