#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
jieba test
'''

# 将项目根目录添加到 sys.path，解决 cmd 下执行该模块找不到包的问题
import sys, os;
current_path = os.path.abspath(os.path.dirname(__file__));
separator = "\\" if os.name == "nt" else "/";
project_name = "python_spider" + separator;
root_path = current_path[:current_path.find(project_name) + len(project_name)];  # 获取项目根目录
sys.path.append(root_path);

from base import jieba_test;
from wordcloud import WordCloud;
# 导入图像处理库
import PIL.Image as image;
# 导入数据处理库
import numpy as np;

# 通过 jieba 词频统计结果绘制词云
def make_wordcloud(jieba_result):
    # 自定义图片遮罩层
    mask = np.array(image.open("wordcloud_3.jpg"))
    wc = WordCloud(
        mask=mask, # 设置遮罩层
        background_color="white",
        width=900, height=600,
        max_words=len(jieba_result),  # 词云显示的最大词语数量
        font_path='simhei.ttf',  # 设置字体，显示中文
        max_font_size=99,  # 设置字体最大值
        min_font_size=16,  # 设置字体最小值
        random_state=50  # 设置随机生成状态，即多少种配色方案
    ).generate_from_frequencies(dict(jieba_result)); # 参数接受 dict 而非 list
    wc.to_file(filename="wordcloud.png");

if __name__ == "__main__":
    jieba_result = jieba_test.cut_test();
    make_wordcloud(jieba_result);