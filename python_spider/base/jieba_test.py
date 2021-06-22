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

import jieba;
import jieba.analyse;
from collections import Counter;

def cut_test():
    print("==== 获取目标字符串 ====");
    content = "";
    with open(file="jieba_content.txt", mode="r", encoding="utf-8") as f:
        content = f.read();

    print("==== 获取停用词列表 ====");
    stop_words = [];
    with open(file="jieba_stop_words.txt", mode="r", encoding="utf-8") as f:
        # 去掉空格、换行符
        stop_words = list(line.strip() for line in f.readlines());

    print("==== 获取自定义分词词典 ====");
    '''
    添加自定义分词词典，添加 jieba 里未能识别的词语
    一个词占一行，每一行分成三部分，一部分为词语，一部分为词频(可省略)，最后为词性(可以省略)
    '''
    jieba.load_userdict("jieba_user_dict.txt");

    print("==== 精确模式分词 ====");
    # 分词，cut 返回 generator，lcut 返回 list
    result = jieba.lcut(content.strip().replace("\n", "")); # 精确模式
    # result = jieba.lcut(content.strip(), cut_all=True); # 全模式
    # result = jieba.lcut_for_search(content.strip()); # 搜索引擎模式

    print("词频统计一……");
    words_map = {};
    # 统计每个词出现次数
    for word in result:
        if word not in stop_words:
            words_map[word] = words_map.get(word, 0) + 1;

    # 将 map 转化为 list，并根据次数倒序排列
    l = list(words_map.items());
    l.sort(key=lambda x: x[1], reverse=True);
    print(l);

    print("==== 词频统计二 ====");
    counter = Counter(result);
    # 按词频排除，返回 [('，', 717), ('的', 443), ...]
    print(counter.most_common());

    print("==== 提取关键字 ====");
    jieba.analyse.set_stop_words("jieba_stop_words.txt");
    # 基于 TF/IDF 算法，返回权重最大的关键词，默认值为 100，withWeight 是否返回权重值
    keywords = jieba.analyse.extract_tags(content, topK=100, withWeight=False);
    print(keywords);
    # 基于 TextRank 算法，返回权重最大的关键词，默认值为 100，withWeight 是否返回权重值
    # keywords = jieba.analyse.textrank(content, topK=100, withWeight=False);
    # print(keywords);

    print("==== 返回含有关键字的词频统计数据 ====")
    l = list(item for item in l if keywords.__contains__(item[0]));
    print(l);
    return l;

if __name__ == "__main__":
    cut_test();