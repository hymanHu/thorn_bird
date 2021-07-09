#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
pandas test
'''

# 将项目根目录添加到 sys.path，解决 cmd 下执行该模块找不到包的问题
import sys, os;
current_path = os.path.abspath(os.path.dirname(__file__));
separator = "\\" if os.name == "nt" else "/";
project_name = "python_spider" + separator;
root_path = current_path[:current_path.find(project_name) + len(project_name)];  # 获取项目根目录
sys.path.append(root_path);

import numpy as np;
import pandas as pd;
from pandas import Series, DataFrame, DatetimeIndex;

# series 数据结构
def series_test():
    print("==== 使用 list 构造 series ====");
    data_list = list(i for i in range(1, 10));
    index_list = list("index_%d" % i for i in range(1, 10));
    # 默认索引列，从 0 开始
    series = Series(data_list);
    print(series);
    series = Series(data_list, index_list);
    print(series);

    print("==== 使用 dict 构造 series ====");
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

    print("==== 新增 ====");
    series["index_10"] = 100;  # 新增一个值
    print(series);

    print("==== 删除 ====");
    print(series.drop("index_10"));
    print(series.drop(["index_10", "index_9"]));

    print("==== 修改 ====");
    series["index_9"] = 99;
    print(series);

    print("==== 查询 ====");
    print(series.index);  # 打印索引 Index 对象
    print(series.index.values);  # 打印索引列表
    print(series.values);  # 打印值列表
    print(series.get("index_9"), series["index_9"]);  # 根据索引或对应的值
    print(series[["index_8", "index_9"]]);  # 取多索引
    print(series["index_1":"index_3"]); # 索引切片
    print(series[[1,3]]); # 索引下标取值
    print(series[0:4]); # 索引下标切片
    print(np.asarray(series)); # Series 转 list

# dataFrame 数据结构
def dataFrame_test():
    print("==== 使用 list 构造 dataFrame ====");
    # 默认行索引列表、列索引列表，从 0 开始
    data_list = [[12, 14, 9, 11], [10, 8, 7, 11], [16, 6,9,13], [22, 17, 34, 22]];
    columns_list = ["第一季度", "第二季度", "第三季度", "第四季度"];
    index_list = ["宇宙公司", "河系公司", "恒星系公司", "行星系公司"];
    dataFrame = DataFrame(data_list);
    print(dataFrame);
    dataFrame = DataFrame(data_list, columns=columns_list); # 指定列索引列表
    print(dataFrame);
    dataFrame = DataFrame(data_list, columns=columns_list, index=index_list); # 指定行索引列表、列索引列表
    print(dataFrame);

    print("==== 使用 dict 构造 series ====")
    # 自动将 dict key 转换为列索引列表
    data_dict = {"第一季度":[12, 14, 9, 11],
                 "第二季度":[10, 8, 7, 11],
                 "第三季度":[16, 6, 9, 13],
                 "第四季度":[22, 17, 34, 22]};
    dataFrame = DataFrame(data_dict);
    print(dataFrame);
    # 指定列索引列表，与 dict key 相同的显示值，否则显示 NaN
    dataFrame = DataFrame(data_dict, columns=columns_list);
    print(dataFrame);
    dataFrame = DataFrame(data_dict, columns=columns_list, index=index_list);
    print(dataFrame);

    print("==== 新增 ====");
    dataFrame["是否及格"] = (dataFrame["第四季度"] > 20);
    print(dataFrame);

    print("==== 删除 ====");
    print(dataFrame.drop("宇宙公司", axis=0)); # 按行删除
    print(dataFrame.drop(["宇宙公司", "河系公司"], axis=0)); # 按行删除多行
    print(dataFrame.drop("是否及格", axis=1)); # 按列删除
    print(dataFrame.drop(["第四季度", "是否及格"], axis=1)); # 按列删除多列

    print("==== 修改 ====");
    dataFrame["第四季度"] = Series([11, 22, 33, 44], index=index_list);
    print(dataFrame);

    print("==== 查询 ====");
    print(dataFrame.shape); # 多少行、多少列数据，返回 tuple
    print("---- 列索引 ----");
    print(dataFrame["第四季度"]); # 按列取值，返回 series
    print(dataFrame[["第一季度", "第二季度"]]); # 按列取多列，返回 dataFrame
    print("---- 行索引 ----");
    print(dataFrame.loc["行星系公司"]); # 按行取值，返回 series
    print(dataFrame.loc[["宇宙公司", "行星系公司"]]); # 按行取多行，返回 dataFrame
    print(dataFrame["宇宙公司":"行星系公司"]); # 按行切片，返回 dataFrame
    print(dataFrame[0:2]); # 按行下标切片，返回 dataFrame
    print(dataFrame.loc[len(dataFrame) - 1]); # 取最后一行数据
    print("---- 组合索引、条件索引 ----");
    print(dataFrame.loc["宇宙公司", ["第一季度", "第二季度"]]);  # 根据行/列索引取值，返回 series
    print(dataFrame.loc[["宇宙公司", "恒星系公司"], ["第一季度", "第二季度"]]);  # 根据行/列索引取值，返回 dataFrame
    print(dataFrame[dataFrame["第一季度"] < 11]);  # 条件索引，取某列值小于 11 的行，返回 dataFrame
    print("---- 遍历 ----");
    print(dataFrame.index.values); # 获取行索引列表
    print(dataFrame.columns.values); # 获取列索引列表
    # iterrows() 方式，效率低，不推荐
    for index, row in dataFrame.iterrows():
        print(index, row['第一季度']);  # 字典方式访问
    # itertuples() 方式，效率高
    for row in dataFrame.itertuples():
        print(row.Index, row.第一季度);
    # zip 方式，效率最高，无 index
    for x, y in zip(dataFrame["第一季度"], dataFrame["第二季度"]):
        print(x, y);

# datetimeIndex 数据结构
def datetimeIndex_test():
    '''
    start ---- 开始时间
    end ---- 结束时间
    periods ---- 时间周期内显示数据条目数
    freq ---- 时间序列频率，D、H、T、S （天、时、分、秒）等
    前三者是互斥的，不能同时存在
    '''
    # 创建时间序列，默认以天为单位
    datetimeIndex = pd.date_range(start="20210530", end="20210630");
    print(datetimeIndex.values);
    print(datetimeIndex.to_list());
    print(datetimeIndex.to_series().values);
    print(datetimeIndex.to_frame());
    # 创建时间序列，每四小时间隔
    datetimeIndex = pd.date_range(start="20210530", end="20210630", freq="4H");
    print(datetimeIndex);
    # 从 20210530 开始创建时间序列，每 4 小时间隔，显示 20 条数据
    datetimeIndex = pd.date_range(start="20210530", periods=20, freq="4H");
    print(datetimeIndex);

# 初始化 series and dataFrame
def init_series_dataFrame():
    # numpy 应用
    # print(np.arange(10));  # 创建 list
    # print(np.arange(15).reshape(3, 5));  # 创建二维 list，元素从 arange 函数获得，3 * 5 = 15

    # series_data_list = [12, 14, 9, 11];
    series_data_list = np.arange(4);
    # dataFrame_data_list = [[12, 14, 9, 11], [10, 8, 7, 11], [16, 6, 9, 13], [22, 17, 34, 22]];
    dataFrame_data_list = np.arange(16).reshape(4, 4);
    columns_list = ["第一季度", "第二季度", "第三季度", "第四季度"];
    index_list = ["宇宙公司", "河系公司", "恒星系公司", "行星系公司"];
    series = Series(series_data_list, index=index_list);
    dataFrame = DataFrame(dataFrame_data_list, columns=columns_list, index=index_list);
    return series, dataFrame;

# 进阶功能
def advanced_function():
    series, dataFrame = init_series_dataFrame();

    print("==== reindex ====");
    # 重新定义索引列表，并为 NaN 数据指定默认值，还可绑定方法 method=
    print(series.reindex(["宇宙公司", "河系公司", "恒星系公司", "行星系公司", "地球公司"], fill_value=0));
    print(dataFrame.reindex(["宇宙公司1", "河系公司", "恒星系公司", "行星系公司", "地球公司"], fill_value=0, axis=0));

    print("==== sort ====");
    print(dataFrame.sort_values(by="第四季度", ascending=False));
    print(dataFrame.sort_index(axis=0, ascending=False));

    print("==== map、apply、applymap ====");
    # 对某行或某列所有数据进行某种计算操作，Series 提供 map、apply 函数，dataFrame 提供 apply、applymap 函数
    dataFrame["第四季度"] = dataFrame["第四季度"].apply(lambda item:item+2);
    print(dataFrame);
    dataFrame.loc["宇宙公司"] = dataFrame.loc["宇宙公司"].apply(lambda item:item+2);
    print(dataFrame);
    # 每列最大值与最小值差值
    print(dataFrame.apply(lambda item:item.max() - item.min(), axis=0));
    # 每行最大值与最小值差值
    print(dataFrame.apply(lambda item:item.max() - item.min(), axis=1));

    print("==== groupby ====");
    dataFrame = pd.read_csv("pandas_content.csv");
    # 先对分组列进行 apply 操作，再进行分组，返回 group 对象，as_index 分组使用的属性是否成为新的表格的索引
    group = dataFrame.groupby(by=[dataFrame["trip_start_date"].apply(lambda item: item[0:7])], as_index=True);
    print(group.count()); # 统计每月评论人数，不包含 NaN，渲染所有列
    print("----");
    print(group.size()); # 统计每月评论人数，包含 NaN
    # 重命名统计列，并将 group 对象转化为 dataFrame 对象
    print(group["trip_start_date"].size().reset_index(name='count'));

# 算术运算
def arithmetic_test():
    print("==== 算术运算 ====");
    series_1, dataFrame_1 = init_series_dataFrame();
    series_2, dataFrame_2 = init_series_dataFrame();

    print(series_1 + series_2);  # series 运算，重叠的部分元素运算，不重叠的部分 NaN
    print(dataFrame_1 + dataFrame_2);  # dataFrame 运算，重叠的部分元素运算，不重叠的部分 NaN
    # sub 减法，div 除法， floordiv 地板除，mul 乘法，pow 指数
    print(dataFrame_1.add(series_1, axis=0));  # 按照行索引做 + 运算，不重叠部分 NaN
    print(dataFrame_1.add(series_1, axis=1));  # 按照列索引做 + 运算，不重叠部分 NaN

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
    print(dataFrame["第四季度"].quantile(0.25)); # 取 dateFrame 某列 1/4 分位数数值

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
    series_test();
    # dataFrame_test();
    # datetimeIndex_test();
    # advanced_function();
    # arithmetic_test();
    # data_analysis_test();