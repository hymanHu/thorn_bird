#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
snownlp test
'''

# 将项目根目录添加到 sys.path，解决 cmd 下执行该模块找不到包的问题
import sys, os;
current_path = os.path.abspath(os.path.dirname(__file__));
separator = "\\" if os.name == "nt" else "/";
project_name = "python_spider" + separator;
root_path = current_path[:current_path.find(project_name) + len(project_name)];  # 获取项目根目录
sys.path.append(root_path);

from snownlp import SnowNLP;

# snownlp 常见函数
def snownlp_base():
    # 目标字符串
    content_1 = "我愛武漢，来武汉必来黄鹤楼打卡，周边停车很方便，进去后坐了一个观光车，价格也不贵，很不错，黄鹤楼很气派，一起有六层，不算很高，高层风景很好，可以看到武汉长江大桥，里面逛的地方不多，总体来说，还是值得来的，不错";
    content_2 = "没啥看头，给外地人看的……";
    content_2 = "值得一来，刘导把行程安排的很妥帖，完全不用操心，推荐！！";
    content_2 = "非常满意，行程安排的很合理，导游服务态度非常好";
    # with open(file="/temp/target_sentiments_negative.txt", mode="r", encoding="utf-8") as f:
    #     content_1 = f.read();

    # 分词
    snownlp_1 = SnowNLP(content_1);
    snownlp_2 = SnowNLP(content_2);
    print(snownlp_1.words);

    # 词性
    print(snownlp_1.tags);
    print(list(item for item in snownlp_1.tags));

    # 断句
    print(snownlp_1.sentences);

    # 情绪值，接近 1 表示正面情绪，接近 0 表示负面情绪
    print(snownlp_1.sentiments);
    print(snownlp_2.sentiments);

    # 汉字转拼音
    print(snownlp_1.pinyin);

    # 繁体字转简体字
    print(snownlp_1.han);

    # 关键字抽取
    print(snownlp_1.keywords(10));

    # 概括总结文意
    print(snownlp_1.summary(4));

if __name__ == "__main__":
    snownlp_base();