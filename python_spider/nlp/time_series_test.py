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
from statsmodels.tsa.api import SimpleExpSmoothing;
from statsmodels.tsa.api import Holt;

# 构造时间段内铁路每两小时购票数量统计数据
def init_data(start, end):
    # 生成 start - end，每两小时间隔的时间序列
    datetimeIndex = pd.date_range(start=start, end=end, freq="2H");
    # 为时间序列每一个时间随机一个数值，代表两小时内订票数量
    data = np.random.randint(low=500, high=1000, size=len(datetimeIndex));
    # 构造 dataFrame，时间序列为 columns，data=[(246,), (559,)...]
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

'''
朴素预测法：并不适合变化很大的数据集，最适合稳定性很高的数据集
方式一：在原有的基础上，增加多行数据（未来时间段），以原始数据最后一条为依据
方式二：在原有的基础上，增加一列，每行数据以原始的 count 数据为依据
'''
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
    print(naive_forecast_df);

    # 重新按月平均值采样数据
    df.index = pd.to_datetime(df["date"], format="%Y-%m-%d %H:%M:%S");
    df = df.resample(rule="M").mean();
    # 从时间列创建时间序列
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

'''
平均法：数据集在一段时间内出现小幅变动，但平均值基本维持不变；
取所有数据的平均值 || 取某个窗口期的平均值
'''
def time_series_fun_3():
    # 读取 csv 文件，删除无用列
    df = pd.read_csv("/temp/time_series_data.csv").drop(labels="Unnamed: 0", axis=1);

    # 取出 count 列平均值，以及最后一条数据的时间
    mean = df["count"].mean();
    last_data = df.loc[len(df) - 1];
    time = datetime.strptime(last_data["date"], "%Y-%m-%d %H:%M:%S");

    # 未来三个月预测数据
    mean_forecast_start = time + timedelta(hours=2);
    mean_forecast_end = time + timedelta(days=90);
    datetime_index = pd.date_range(start=mean_forecast_start, end=mean_forecast_end, freq="2H");
    data = np.random.randint(low=int(mean) - 20, high=int(mean) + 20, size=len(datetime_index));
    # 创建未来预测 dateFrame，并追加到原有数据上
    mean_forecast_dateFrame = df.append(DataFrame(data=list(zip(datetime_index.values, data)), columns=["date", "count"]));

    # 按月平均值重新采集数据
    df.index = pd.to_datetime(df["date"], format="%Y-%m-%d %H:%M:%S");
    df = df.resample(rule="M").mean();
    mean_forecast_dateFrame.index = pd.to_datetime(mean_forecast_dateFrame["date"], format="%Y-%m-%d %H:%M:%S");
    mean_forecast_dateFrame = mean_forecast_dateFrame.resample(rule="M").mean();

    # 绘制折线图
    plt.rcParams['font.sans-serif'] = ['SimHei'];
    plt.plot(mean_forecast_dateFrame.index, mean_forecast_dateFrame["count"], label="预测数据", linewidth=2);
    plt.plot(df.index, df["count"], label="原始数据", linewidth=2);
    # 指定标题以及 x、y 轴标签
    plt.title("铁路购票预测图");
    plt.xlabel("时间");
    plt.ylabel("每月购票均值");
    plt.legend(loc='upper left');
    # 显示图画
    plt.show();

'''
平滑指数法：通过加权平均值计算出预测值
    平均法无论取所有样本还是取某个窗口期的样本，都显得过于武断，
    指数法在考虑所有数据的同时也能给数据赋予不同的权重
    比如：近期的数据比更早的数据有更大的权重
    from statsmodels.tsa.api import SimpleExpSmoothing
'''
def time_series_fun_4():
    # 读取 csv 文件，删除无用列
    df = pd.read_csv("/temp/time_series_data.csv").drop(labels="Unnamed: 0", axis=1);

    # 取出最后一条数据
    last_data = df.loc[len(df) - 1];
    time = datetime.strptime(last_data["date"], "%Y-%m-%d %H:%M:%S");

    # 未来三个月预测数据
    SES_forecast_start = time + timedelta(hours=2);
    SES_forecast_end = time + timedelta(days=90);
    datetime_index = pd.date_range(start=SES_forecast_start, end=SES_forecast_end, freq="2H");
    # 传入历史数据集，设置权重值（0 - 1），训练出适应模型
    fit_model = SimpleExpSmoothing(np.asarray(df["count"])).fit(smoothing_level=0.7, optimized=False);
    # 用适应模型获取预测数据
    data = fit_model.predict(start=0, end=len(datetime_index));
    SES_forecast_dataFrame = df.append(DataFrame(data=list(zip(datetime_index, data)), columns=["date", "count"]));
    SES_forecast_dataFrame["count"] = SES_forecast_dataFrame["count"].apply(lambda item:int(item));

    # 按月平均值重新采集数据
    df.index = pd.to_datetime(df["date"], format="%Y-%m-%d %H:%M:%S");
    df = df.resample(rule="M").mean();
    SES_forecast_dataFrame.index = pd.to_datetime(SES_forecast_dataFrame["date"], format="%Y-%m-%d %H:%M:%S");
    SES_forecast_dataFrame = SES_forecast_dataFrame.resample(rule="M").mean();

    # 绘制折线图
    plt.rcParams['font.sans-serif'] = ['SimHei'];
    plt.plot(SES_forecast_dataFrame.index, SES_forecast_dataFrame["count"], label="预测数据", linewidth=2);
    plt.plot(df.index, df["count"], label="预测数据", linewidth=2);
    # 指定标题以及 x、y 轴标签
    plt.title("铁路购票预测图");
    plt.xlabel("时间");
    plt.ylabel("每月购票均值");
    plt.legend(loc='upper left');
    # 显示图画
    plt.show();

'''
霍尔特线性趋势法
    将数据及分解为几个组成部分：趋势 Trend，季节性 Seasonal 和残差 Residual，这里示例线性趋势
    from statsmodels.tsa.api import Holt
'''
def time_series_fun_5():
    # 读取 csv 文件，删除无用列
    df = pd.read_csv("/temp/time_series_data.csv").drop(labels="Unnamed: 0", axis=1);

    # 取出最后一条数据
    last_data = df.loc[len(df) - 1];
    time = datetime.strptime(last_data["date"], "%Y-%m-%d %H:%M:%S");

    # 未来三个月预测数据
    Holt_forecast_start = time + timedelta(hours=2);
    Holt_forecast_end = time + timedelta(days=90);
    datetime_index = pd.date_range(start=Holt_forecast_start, end=Holt_forecast_end, freq="2H");
    # 传入历史数据集，设置权重值（0 - 1），训练出适应模型
    fit_model = Holt(np.asarray(df["count"])).fit(smoothing_level=0.7, smoothing_slope=0.1, optimized=False);
    # 用适应模型获取预测数据
    data = fit_model.predict(start=0, end=len(datetime_index));
    Holt_forecast_dataFrame = df.append(DataFrame(data=list(zip(datetime_index, data)), columns=["date", "count"]));
    Holt_forecast_dataFrame["count"] = Holt_forecast_dataFrame["count"].apply(lambda item: int(item));

    # 按月平均值重新采集数据
    df.index = pd.to_datetime(df["date"], format="%Y-%m-%d %H:%M:%S");
    df = df.resample(rule="M").mean();
    Holt_forecast_dataFrame.index = pd.to_datetime(Holt_forecast_dataFrame["date"], format="%Y-%m-%d %H:%M:%S");
    Holt_forecast_dataFrame = Holt_forecast_dataFrame.resample(rule="M").mean();

    # 绘制折线图
    plt.rcParams['font.sans-serif'] = ['SimHei'];
    plt.plot(Holt_forecast_dataFrame.index, Holt_forecast_dataFrame["count"], label="预测数据", linewidth=2);
    plt.plot(df.index, df["count"], label="预测数据", linewidth=2);
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
    # time_series_fun_2();
    # time_series_fun_3();
    # time_series_fun_4();
    time_series_fun_5();
