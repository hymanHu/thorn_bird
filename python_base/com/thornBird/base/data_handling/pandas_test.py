#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
pandas test
'''

import pandas as pd;
import numpy as np;
from pandas import Series, DataFrame;

# series 数据结构
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

# dataFrame 数据结构
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

# 初始化 series and dataFrame
def init_series_dataFrame():
    # numpy 应用
    # print(np.arange(10));  # 创建 list
    # print(np.arange(15).reshape(3, 5));  # 创建二维 list，元素从 arange 函数获得，3 * 5 = 15

    # series_data_list = [12, 14, 9, 11];
    series_data_list = np.arange(4);
    # dataFrame_data_list = [[12, 14, 9, 11], [10, 8, 7, 11], [16, 6, 9, 13], [22, 17, 34, 22]];
    dataFrame_data_list = np.arange(16).reshape(4, 4);
    columns_list = ["第一产业", "第二产业", "第三产业", "第四产业"];
    index_list = ["宇宙公司", "河系公司", "恒星系公司", "行星系公司"];
    series = Series(series_data_list, index=index_list);
    dataFrame = DataFrame(dataFrame_data_list, columns=columns_list, index=index_list);
    return series, dataFrame;

# 索引
def base_index_test():
    series, dataFrame = init_series_dataFrame();

    # reindex，重新定义列索引列表，并为 NaN 数据指定默认值，还可绑定方法 method=
    series = series.reindex(["宇宙公司", "河系公司", "恒星系公司", "行星系公司", "地球公司"], fill_value=0);
    print(series);

    # drop，根据索引删除元素
    print(series.drop("宇宙公司")); # 删除一个索引数据
    print(series.drop(["恒星系公司", "河系公司"])); # 删除多个索引数据
    print(dataFrame);
    print(dataFrame.drop("宇宙公司", axis=0)); # 按照行索引删除一行数据
    print(dataFrame.drop(["河系公司", "恒星系公司"], axis=0)); # 按照行索引删除多行数据
    print(dataFrame.drop("第一产业", axis=1)); # 按照列索引删除一列数据
    print(dataFrame.drop(["第二产业", "第三产业"], axis=1)); # 按照列索引删除多列数据

    # 索引
    print(series["宇宙公司"]); # 按照 index 单条取值，返回对应的 value
    print(series[["宇宙公司", "恒星系公司"]]); # 按照 index 多条取值，返回 series
    print(series["宇宙公司":"恒星系公司"]); # 按照 index 切片取值，返回 series
    print(series[0]); # 按照下标单条取值，返回对应的 value
    print(series[[0, 1]]); # 按照下标多条取值，返回 series
    print(series[0:3]); # 按照下标切片取值，返回 series
    print("==== 列索引操作 ====");
    print(dataFrame["第一产业"]); # 按照列索引取一列数据，返回 series
    print(dataFrame[["第一产业", "第二产业"]]); # 按照列索引取多列数据，返回 dataFrame
    print("==== 行索引操作 ====");
    print(dataFrame.loc["宇宙公司"]); # 根据行索引取值，返回 series
    print(dataFrame.loc[["宇宙公司", "恒星系公司"]]); # 根据行索引取值，返回 dataFrame
    print(dataFrame[0 : 2]); # 按照行下标切片，前闭后开，返回 dataFrame
    print(dataFrame["宇宙公司" : "恒星系公司"]); # 按照行索引切片，前闭后闭, 返回 dataFrame
    print("==== 组合索引、条件索引操作 ====")
    print(dataFrame.loc["宇宙公司", ["第一产业", "第二产业"]]); # 根据行/列索引取值，返回 series
    print(dataFrame.loc[["宇宙公司", "恒星系公司"], ["第一产业", "第二产业"]]); # 根据行/列索引取值，返回 dataFrame
    print(dataFrame[dataFrame["第一产业"] < 11]); # 条件索引，取某列值小于 11 的行

    # 排序
    print(dataFrame.sort_values(by="第四产业", ascending=False));
    print(dataFrame.sort_index(axis=0, ascending=False));

# 算术运算
def arithmetic_test():
    series_1, dataFrame_1 = init_series_dataFrame();
    series_2, dataFrame_2 = init_series_dataFrame();

    print(series_1 + series_2); # series 运算，重叠的部分元素运算，不重叠的部分 NaN
    print(dataFrame_1 + dataFrame_2); # dataFrame 运算，重叠的部分元素运算，不重叠的部分 NaN
    # sub 剪发，div 除法， floordiv 地板除，mul 乘法，pow 指数
    print(dataFrame_1.add(series_1, axis=0)); # 按照行索引做 + 运算，不重叠部分 NaN
    print(dataFrame_1.add(series_1, axis=1)); # 按照列索引做 + 运算，不重叠部分 NaN

# 数据统计分析
def data_analysis_test():
    series, dataFrame = init_series_dataFrame();
    print(series.describe()); # series 摘要信息
    print(series.sum()); # series 求和
    print(series.count()); # series 条目总数
    print(series.mean(), series.median()); # series 平均数、中位数
    print(series.min(), series.max()); # series 最小值、最大值
    print(dataFrame.describe()); # dataFrame 摘要信息
    print(dataFrame.sum(axis=0)); # dataFrame 行求和
    print(dataFrame.sum(axis=1)); # dataFrame 列求和
    print(dataFrame.count(axis=0));# dataFrame 行总数
    print(dataFrame.count(axis=1));# dataFrame 列总数
    print(dataFrame.min(axis=0)); # dataFrame 行最小值
    print(dataFrame.min(axis=1)); # dateFrame 列最小值

# csv 文件读写
def file_test():
    series, dataFrame = init_series_dataFrame();
    print(dataFrame);
    # utf-8: 处理不带 BOM 的文档
    # utf-8-sig：处理带有 BOM 的文档，将 BOM 作为签名单独处理
    dataFrame.to_csv("D:/download/result.csv", float_format="%.2f", encoding="utf-8-sig");

    gzbd_dataFrame = pd.read_csv("D:/download/gzbd.csv");
    print(gzbd_dataFrame);

if __name__ == "__main__":
    # series_test();
    # dataFrame_test();
    base_index_test();
    # arithmetic_test();
    # data_analysis_test();
    # file_test();