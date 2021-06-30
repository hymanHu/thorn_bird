#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
pyplot test
'''

# 将项目根目录添加到 sys.path，解决 cmd 下执行该模块找不到包的问题
import sys, os;
current_path = os.path.abspath(os.path.dirname(__file__));
separator = "\\" if os.name == "nt" else "/";
project_name = "python_spider" + separator;
root_path = current_path[:current_path.find(project_name) + len(project_name)];  # 获取项目根目录
sys.path.append(root_path);

from pyecharts.faker import Faker;
import numpy as np;
import matplotlib.pyplot as plt;

# 点图、折线图
def pyplot_line():
    # 指定字体，可解决中文乱码问题
    plt.rcParams['font.sans-serif'] = ['SimHei'];

    # x、y 轴数据，长度需一致
    x = np.arange(0, 10);
    y = np.arange(0, 10);
    '''
    plot 函数，传入 data 以及图画颜色和样式
    x, y, "r-." ---- 这是一组数据， 分别代表 x、y 轴数据，以及该组数据展示的颜色和样式
    我们可以传入多组数据，这样在绘图区会绘制多组图像
    linewidth ---- 线宽
    '''
    plt.plot(x, y, "r-.", x, y ** 2, "bs", x, y ** 3, "g^", linewidth=2.0);
    # 指定标题以及 x、y 轴标签
    plt.title("我是标题");
    plt.xlabel("X Label");
    plt.ylabel("Y Label");
    # 指定文字起始坐标
    plt.text(2, 600, "图片中间的文字");
    # 显示背景方格
    plt.grid();
    # 显示图画
    plt.show();

# 柱状图
def pyplot_bar():
    # 指定字体，可解决中文乱码问题
    # plt.rcParams['font.sans-serif'] = ['SimHei'];
    plt.rcParams["font.family"] = "STSong";

    x_labels = Faker.choose();
    x = np.arange(len(x_labels));  # x轴刻度标签位置
    width = 0.25; # 柱子的宽度
    # 计算每个柱子在x轴上的位置，保证 x 轴刻度标签居中
    # 三组数据 x - width，x， x + width
    # 四组数据 x - 1.5*width，x - 0.5*width， x + 0.5*width， x + 1.5*width
    plt.bar(x - width/2, Faker.values(1, 100), color='r', label="label_1", width=width);
    plt.bar(x + width/2, Faker.values(1, 100), color='g', label="label_2", width=width);
    # x 轴数据为数字，须和 labels 标签绑定
    plt.xticks(x, labels=x_labels);
    # 指定标题以及 x、y 轴标签
    plt.title("我是标题");
    plt.xlabel("X Label");
    plt.ylabel("Y Label");
    # 指定图例显示位置，label_1、label_2
    # ['upper left' , 'upper center', 'upper right', 'center left', 'center', 'center right', 'lower left', 'lower center', 'lower right']
    plt.legend(loc='upper left');
    plt.show();

# 饼图
def pyplot_pie():
    # 指定字体，可解决中文乱码问题
    # plt.rcParams['font.sans-serif'] = ['SimHei'];
    plt.rcParams["font.family"] = "STSong";

    labels = Faker.choose();
    x = Faker.values();
    explode = (0, 0.1, 0, 0, 0, 0, 0); # 0.1表示对应的部分凸显出来
    plt.pie(x, explode=explode, labels=labels, autopct="%1.1f%%");
    # 指定标题
    plt.title("我是标题");
    plt.show();

if __name__ == "__main__":
    pyplot_line();
    pyplot_bar();
    pyplot_pie();