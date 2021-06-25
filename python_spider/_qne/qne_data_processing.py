#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
去哪儿评论数据存储
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
from wordcloud import WordCloud;
# 导入图像处理库
import PIL.Image as image;
# 导入数据处理库
import numpy as np;
import pandas as pd;
from pandas import Series, DataFrame;
from snownlp import SnowNLP;
from pyecharts import options as opts;
from pyecharts.faker import Faker;
from pyecharts.charts import Bar, Bar3D, Line, Line3D, Pie;
import json;

'''
给每条数据添加情感分数
target_csv_file ---- 进行情感分析的目标 csv 文件
target_column_name ---- 进行情感分析的列名
output_csv_file ---- 输出 csv 文件地址
'''
def add_sentiments(target_csv_file, target_column_name, output_csv_file):
    print("==== 读取 csv 文件，封装 DataFrame 数据 ====");
    dataFrame = pd.read_csv(target_csv_file);
    print(dataFrame.head(2));

    print("==== 对目标列数据进行情感分析，并将结果保存为 sentiments 列，输出文件 %s ====" % output_csv_file);
    dataFrame["sentiments"] = dataFrame[target_column_name].apply(lambda item:SnowNLP(item).sentiments);
    dataFrame.to_csv(path_or_buf=output_csv_file, encoding="utf-8-sig", index=False);
    print(dataFrame.describe());

# 情感分析
'''
情感分析
target_csv_file ---- 进行情感分析目标文件
'''
def sentiments_analysis(target_csv_file, target_column_name):
    # 解析公共文件名
    common_file_name = target_csv_file.split(".")[0];

    print("==== 读取带情感值的 csv 文件，封装 DataFrame 数据 ====");
    dataFrame = pd.read_csv(target_csv_file);
    print(dataFrame.head(2));

    print("==== 获取统计信息相关数值 ====");
    min_value = dataFrame[target_column_name].describe()["min"];
    lower_value = dataFrame[target_column_name].quantile(0.1);
    higher_value = dataFrame[target_column_name].quantile(0.75);
    min_max = dataFrame[target_column_name].describe()["max"];
    print(dataFrame.describe());
    print(min_value, lower_value, higher_value, min_max);

    print("==== 解析消极的 dataFrame 数据，并生成 csv 和 txt 文件 ====");
    sentiments = {};
    negative_dataFrame = dataFrame[dataFrame[target_column_name] <= lower_value];
    print(negative_dataFrame.head(2));
    negative_dataFrame.to_csv(path_or_buf=common_file_name + "_negative.csv", encoding="utf-8-sig", index=False);
    content = "";
    for item in negative_dataFrame.values:
        content += item[3] + "\n";
    with open(file=common_file_name + "_negative.txt", mode="w", encoding="utf-8") as f:
        f.write(content);
    # snownlp = SnowNLP(content);
    # sentiments["negative"] = {"count":len(negative_dataFrame.values), "summary":snownlp.summary(10)};
    sentiments["消极评论"] = {"count":len(negative_dataFrame.values), "summary":""};

    print("==== 解析普通的 dataFrame 数据，并生成 csv 和 txt 文件 ====");
    ordinary_dataFrame = dataFrame[(dataFrame[target_column_name] > lower_value) & (dataFrame[target_column_name] < higher_value)];
    print(ordinary_dataFrame.head(2));
    ordinary_dataFrame.to_csv(path_or_buf=common_file_name + "_ordinary.csv", encoding="utf-8-sig", index=False);
    content = "";
    for item in ordinary_dataFrame.values:
        content += item[3] + "\n";
    with open(file=common_file_name + "_ordinary.txt", mode="w", encoding="utf-8") as f:
        f.write(content);
    # snownlp = SnowNLP(content);
    # sentiments["ordinary"] = {"count":len(ordinary_dataFrame.values), "summary":snownlp.summary(10)};
    sentiments["普通评论"] = {"count":len(ordinary_dataFrame.values), "summary":""};

    print("==== 解析积极的 dataFrame 数据，并生成 csv 和 txt 文件 ====");
    positive_dataFrame = dataFrame[dataFrame[target_column_name] >= higher_value];
    print(positive_dataFrame.head(2));
    positive_dataFrame.to_csv(path_or_buf=common_file_name + "_positive.csv", encoding="utf-8-sig", index=False);
    content = "";
    for item in positive_dataFrame.values:
        content += item[3] + "\n";
    with open(file=common_file_name + "_positive.txt", mode="w", encoding="utf-8") as f:
        f.write(content);
    # snownlp = SnowNLP(content);
    # sentiments["positive"] = {"count":len(positive_dataFrame.values), "summary":snownlp.summary(10)};
    sentiments["积极评论"] = {"count":len(positive_dataFrame.values), "summary":""};

    print("==== 将三种情绪统计信息写入文件 ====");
    print(sentiments);
    with open(file=common_file_name + "_summary.txt", mode="w", encoding="utf-8") as f:
        f.write(json.dumps(sentiments));
    return sentiments;

'''
关键字词频统计
target_file ---- 目标文件
stop_words_file ---- 停用词表文件
user_dict_file ---- 自定义分词字典文件
keyword_list ---- 自定义关键字，不传则采用 jieba 分析所得关键字
'''
def get_keyword_frequency(target_file, stop_words_file, user_dict_file, keyword_list=[]):
    print("==== 获取目标字符串 ====");
    content = "";
    with open(file=target_file, mode="r", encoding="utf-8") as f:
        content = f.read().strip().replace("\n", "").replace(" ", "");
    print(content[0:20] + "......");

    print("==== 获取停用词表 ====");
    stop_word_list = [];
    with open(file=stop_words_file, mode="r", encoding="utf-8") as f:
        # 每行去空格
        stop_word_list = list(line.strip() for line in f.readlines());
    print(stop_word_list);

    print("=== 获取自定义分词词典 ====");
    '''
    添加 jieba 里未能识别的词语
    一个词占一行，每一行分成三部分，一部分为词语，一部分为词频(可省略)，最后为词性(可以省略)
    '''
    jieba.load_userdict(user_dict_file);

    print("==== 分词 ====");
    # 分词，cut 返回 generator，lcut 返回 list
    cut_word_list = jieba.lcut(content); # 精确模式
    # cut_word_list = jieba.lcut(content, cut_all=True); # 全模式
    # cut_word_list = jieba.lcut_for_search(content); # 搜索引擎模式
    print(cut_word_list);

    print("==== 词频统计 ====");
    # 方式一
    word_frequency_map = {};
    for item in cut_word_list:
        if item not in stop_word_list:
            word_frequency_map[item] = word_frequency_map.get(item, 0) + 1;
    # 将 map 转化为 list，并按词频大小排序
    word_frequency_list = list(word_frequency_map.items());
    word_frequency_list.sort(key=lambda x:x[1], reverse=True);
    print(word_frequency_list);
    # 方式二，返回 [('，', 5932), ('的', 3177),...] 格式
    counter = Counter(cut_word_list);
    print(counter.most_common());

    print("==== 提取关键字 ====");
    if len(keyword_list) == 0:
        jieba.analyse.set_stop_words(stop_words_file);
        # 基于 TF/IDF 算法，返回权重最大的关键词，默认值为 150，withWeight 是否返回权重值
        keyword_list = jieba.analyse.extract_tags(content, topK=150, withWeight=False);
        print(keyword_list);
        # 基于 TextRank 算法，返回权重最大的关键词，默认值为 100，withWeight 是否返回权重值
        # keyword_list = jieba.analyse.textrank(content, topK=100, withWeight=False);
        # print(keyword_list);

    print("==== 提取含有关键字的词频统计数据 ==== ");
    keyword_frequency_list = list(item for item in word_frequency_list if item[0] in keyword_list);
    print(keyword_frequency_list);

    return word_frequency_list, keyword_frequency_list;

background_image = "../resources/background_2.jpg";
# 根据关键字词频统计数据绘制词云图
def make_wordcloud(keyword_frequency_list, output_file):
    print("==== 绘制词云图 ==== ");
    # 自定义图片遮罩层
    mask = np.array(image.open(background_image))
    wc = WordCloud(
        mask=mask,  # 设置遮罩层
        background_color="white",
        width=900, height=600,
        max_words=len(keyword_frequency_list),  # 词云显示的最大词语数量
        font_path='simhei.ttf',  # 设置字体，显示中文
        max_font_size=99,  # 设置字体最大值
        min_font_size=16,  # 设置字体最小值
        random_state=50  # 设置随机生成状态，即多少种配色方案
    ).generate_from_frequencies(dict(keyword_frequency_list));  # 参数接受 dict 而非 list
    wc.to_file(filename=output_file);

# 绘制情绪占比饼图
def draw_sentiments_pie(target_sentiments_summary):
    print("==== 读取情绪统计文件 ====");
    sentiments = {};
    with open(file=target_sentiments_summary, mode="r", encoding="utf-8") as f:
        sentiments = json.loads(f.read());
    print(sentiments);

    print("==== 绘制情绪占比饼图 ====");
    data = [];
    for key,value in sentiments.items():
        data.append([key, value.get("count")]);
    Pie().add(
        series_name="",
        data_pair=data,
    ).set_global_opts(
        # 设置图表属性
        title_opts=opts.TitleOpts(title="去哪儿", subtitle="九寨沟评论")
    ).set_series_opts(
        # 设置 label 显示样式
        label_opts=opts.LabelOpts(
            formatter="{b}: {c}",
            color=Faker.rand_color(),
        )
    ).render(
        # 设置输出路径
        path="/temp/target_sentiments_pie.html"
    );

# 绘制每月出游评论人数折线图
def draw_commonts_line(target_csv_file):
    dataFrame = pd.read_csv(target_csv_file);
    # dataFrame = dataFrame[["trip_start_date"]];
    # dataFrame["trip_start_date"] = dataFrame["trip_start_date"].apply(lambda item:item[0:7]);
    # 它不再是一个dataframe，而是一个GroupBy对象，我们后面函数的任何操作都是基于这个对象的。
    group = dataFrame.groupby(by=[dataFrame["trip_start_date"].apply(lambda item: item[0:7])], as_index=True);
    # 对每列都进行 count 操作
    print(group.count());
    # 选择一列进行聚合操作，也可按不同的列选不同的聚合函数，例如：g.agg({'B':'mean', 'C':'sum'})
    print(group["trip_start_date"].count());
    # size 计数时包含 NaN 值，而 count 不包含 NaN 值
    print(group["trip_start_date"].size());
    # 重命名统计列，并将 group 对象转化为 dataFrame 对象
    df = group["trip_start_date"].size().reset_index(name='count');
    print(df);
    # 遍历 https://www.cnblogs.com/math98/p/9769496.html
    x_list = [];
    y_list = [];
    for trip_start_date, count in zip(df["trip_start_date"], df["count"]):
        x_list.append(trip_start_date);
        y_list.append(count);

    # 折线图
    Line().add_xaxis(
        # 添加 x 轴数据
        x_list
    ).add_yaxis(
        # 添加 y 轴数据，并设置属性
        "出游人数", y_list, itemstyle_opts=opts.ItemStyleOpts(color=Faker.rand_color())
    ).set_global_opts(
        # 设置图表属性
        title_opts=opts.TitleOpts(title="去哪儿", subtitle="月出游评论人数")
    ).render(
        # 设置输出路径
        path="/temp/target_comments_line.html"
    );

if __name__ == "__main__":
    # 为评论添加情感值
    # add_sentiments("/temp/target.csv", "content", "/temp/target_sentiments.csv");

    # 情感分析
    # sentiments_analysis("/temp/target_sentiments.csv", "sentiments");

    # 绘制所有信息词云图
    # word_frequency_list, keyword_frequency_list = get_keyword_frequency("/temp/target.txt",
    #                     "../resources/jieba_stop_words.txt", "../resources/jieba_user_dict.txt");
    # make_wordcloud(keyword_frequency_list, "/temp/target_all.png");

    # 绘制消极评论词云图
    # negative_word_frequency_list, negative_keyword_frequency_list = get_keyword_frequency("/temp/target_sentiments_negative.txt",
    #                     "../resources/jieba_stop_words.txt", "../resources/jieba_user_dict.txt");
    # make_wordcloud(negative_word_frequency_list, "/temp/target_negative.png");

    # 绘制情绪占比饼图
    # draw_sentiments_pie("/temp/target_sentiments_summary.txt");

    # 绘制每月出游评论人数折线图
    draw_commonts_line("/temp/target.csv");