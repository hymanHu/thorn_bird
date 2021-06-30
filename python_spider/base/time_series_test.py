#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
时间序列预测
'''

# 将项目根目录添加到 sys.path，解决 cmd 下执行该模块找不到包的问题
import sys, os;
current_path = os.path.abspath(os.path.dirname(__file__));
separator = "\\" if os.name == "nt" else "/";
project_name = "python_spider" + separator;
root_path = current_path[:current_path.find(project_name) + len(project_name)];  # 获取项目根目录
sys.path.append(root_path);

import random;
from datetime import datetime, timedelta;
import numpy as np;
import pandas as pd;
from pandas import Series, DataFrame, DatetimeIndex;
import matplotlib.pyplot as plt;

# 构造时间段内铁路每两小时购票数量统计数据
def init_data(start, end):
    # 生成 start - end，每两小时间隔的时间序列
    datetimeIndex = pd.date_range(start=start, end=end, freq="2H");
    # 为时间序列每一个时间随机一个数值，代表两小时内订票数量
    data = np.random.randint(low=1, high=1000, size=len(datetimeIndex));
    # 构造 dataFrame，时间序列为 columns
    df = DataFrame(data=list(zip(data)), index=datetimeIndex, columns=["count"]);
    # 构造 dataFrame，时间序列作为数据列
    df = DataFrame(data=list(zip(datetimeIndex.values, data)), columns=["date", "count"]);
    # 将测试数据写入 csv
    df.to_csv(path_or_buf="/temp/time_series_data.csv", encoding="utf-8-sig");

# 绘制每月购票平均值曲线图
def time_series_fun_1():
    df = pd.read_csv("/temp/time_series_data.csv");
    print(df.head());
    print(df.shape);

    # 从时间列创建时间序列
    df.index = pd.to_datetime(df["date"], format="%Y-%m-%d %H:%M:%S");
    print(df);
    # 对 df 重新采样，按月取平均值
    df = df.resample(rule="M").mean();
    print(df);

    # 指定字体，可解决中文乱码问题
    plt.rcParams['font.sans-serif'] = ['SimHei'];
    plt.plot(df.index, df["count"], label="原始数据");
    # 指定标题以及 x、y 轴标签
    plt.title("铁路购票趋势图");
    plt.xlabel("时间");
    plt.ylabel("每月购票均值");
    plt.legend();
    plt.show();

# 朴素法预测
def time_series_fun_2():
    df = pd.read_csv("/temp/time_series_data.csv");
    # 取出最后一条数据
    last_data = df.loc[len(df) - 1];
    time = datetime.strptime(last_data["date"], "%Y-%m-%d %H:%M:%S");
    count = last_data["count"];

    # 未来三个月预测数据
    naive_forecast_start = time + timedelta(hours=2);
    naive_forecast_end = time + timedelta(days=90);
    datetimeIndex = pd.date_range(start=naive_forecast_start, end=naive_forecast_end, freq="2H");
    data = np.random.randint(low=count-20, high=count + 20, size=len(datetimeIndex));
    naive_forecast_df = DataFrame(data=list(zip(datetimeIndex.values, data)), columns=["date", "count"]);
    naive_forecast_df = df.append(naive_forecast_df);

    # 重新按月平均值采样数据
    df.index = pd.to_datetime(df["date"], format="%Y-%m-%d %H:%M:%S");
    df = df.resample(rule="M").mean();
    naive_forecast_df.index = pd.to_datetime(naive_forecast_df["date"], format="%Y-%m-%d %H:%M:%S");
    naive_forecast_df = naive_forecast_df.resample(rule="M").mean();

    # 绘制折线图
    plt.rcParams['font.sans-serif'] = ['SimHei'];
    plt.plot(naive_forecast_df.index, naive_forecast_df["count"], label="预测数据", linewidth=2);
    plt.plot(df.index, df["count"], label="原始数据", linewidth=2);
    # 指定标题以及 x、y 轴标签
    plt.title("铁路购票预测图");
    plt.xlabel("时间");
    plt.ylabel("每月购票均值");
    plt.legend(loc='upper left');
    # 显示图画
    plt.show();

if __name__ == "__main__":
    # init_data("20180101", "20210630");
    # time_series_fun_1();
    time_series_fun_2();

