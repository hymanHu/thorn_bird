#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
pandas test
'''

import pandas as pd;
from pandas import Series, DataFrame;

def series_test():
    # ==== 使用 list 构造 series ====
    data_list = list(i for i in range(1, 10));
    index_list = list("index_%d" % i for i in range(1, 10));
    # 默认索引列，从 0 开始
    series = Series(data_list);
    print(series);
    series = Series(data_list, index_list);
    print(series);
    print(series.index); # 打印索引列表
    print(series.get("index_9"), series["index_9"], series[["index_8", "index_9"]]); # 根据索引或对应的值
    series["index_9"] = 99; # 对 series 赋值
    print(series);
    print("----------------------------------------");

    # ==== 使用 dict 构造 series ====
    data_dict_1 = {"name": "hujiang", "age": 18, "sex": "man", "index_1":"balabala"};
    data_dict_2 = {"name": "hymanHu", "age": 19, "sex": "man", "index_1":"balabala"};
    # dict 中的 key 自动转为 index_list
    series_1= Series(data_dict_1);
    print(series_1);
    # 传入的 index_list 元素与 dict key 相同时候，则显示 dict 对应的值，否者显示 NaN
    series_1 = Series(data_dict_1, index_list);
    print(series_1);
    series_2 = Series(data_dict_2, index_list);
    print(series_1 + series_2); # 多个 series 合并

def dataFrame_test():
    # ==== 使用 list 构造 dataFrame ====
    # 默认行索引列表、列索引列表，从 0 开始
    data_list = [[12, 14, 9, 11], [10, 8, 7, 11], [16, 6,9,13], [22, 17, 34, 22]];
    columns_list = ["第一产业", "第二产业", "第三产业", "第四产业"];
    index_list = ["宇宙公司", "河系公司", "恒星系公司", "行星系公司"];
    dataFrame = DataFrame(data_list);
    print(dataFrame);
    dataFrame = DataFrame(data_list, columns=columns_list); # 指定列索引列表
    print(dataFrame);
    dataFrame = DataFrame(data_list, columns=columns_list, index=index_list); # 指定行索引列表、列索引列表
    print(dataFrame);

    # ==== 使用 dict 构造 series ====
    # 自动将 dict key 转换为列索引列表
    data_dict = {"第一季度":[12, 14, 9, 11],
                 "第二季度":[10, 8, 7, 11],
                 "第三季度":[16, 6,9,13],
                 "第四产业":[22, 17, 34, 22]};
    dataFrame = DataFrame(data_dict);
    print(dataFrame);
    # 指定列索引列表，与 dict key 相同的显示值，否则显示 NaN
    dataFrame = DataFrame(data_dict, columns=columns_list);
    print(dataFrame);
    dataFrame = DataFrame(data_dict, columns=columns_list, index=index_list);
    print(dataFrame);
    print(dataFrame["第四产业"]); # 获取某列数据，返回 series
    print(dataFrame.loc["行星系公司"]); # 获取某行数据，返回 series
    dataFrame["第四产业"] = 33; # 修改某列数据，改成同一个值
    print(dataFrame);
    dataFrame["第四产业"] = Series([11, 22, 33, 44], index=index_list); # 修改某列数据，根据 series 修改
    print(dataFrame);
    dataFrame["是否及格"] = (dataFrame["第四产业"] > 20); # 新增一列，值根据已有的列判断
    print(dataFrame);

def init_series_dataFrame():
    series_data_list = [12, 14, 9, 11];
    dataFrame_data_list = [[12, 14, 9, 11], [10, 8, 7, 11], [16, 6, 9, 13], [22, 17, 34, 22]];
    columns_list = ["第一产业", "第二产业", "第三产业", "第四产业"];
    index_list = ["宇宙公司", "河系公司", "恒星系公司", "行星系公司"];
    series = Series(series_data_list, index=index_list);
    dataFrame = DataFrame(dataFrame_data_list, columns=columns_list, index=index_list);
    return series, dataFrame;

def reindex_test():
    series, dataFrame = init_series_dataFrame();

    # 重新定义列，并为 NaN 数据指定默认值，还可绑定方法 method=
    series = series.reindex(["宇宙公司", "河系公司", "恒星系公司", "行星系公司", "地球公司"], fill_value=0);
    print(series);


if __name__ == "__main__":
    # series_test();
    # dataFrame_test();
    reindex_test();