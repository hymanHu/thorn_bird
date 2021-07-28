#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
中彩网双色球数据处理
'''

# 将项目根目录添加到 sys.path，解决 cmd 下执行该模块找不到包的问题
import sys, os;
current_path = os.path.abspath(os.path.dirname(__file__));
separator = "\\" if os.name == "nt" else "/";
project_name = "python_spider" + separator;
root_path = current_path[:current_path.find(project_name) + len(project_name)];  # 获取项目根目录
sys.path.append(root_path);

from utils.sqlalchemy_util import *;
import random;
import numpy as np;
import pandas as pd;
from pandas import DataFrame;
from statsmodels.tsa.api import Holt;
from statsmodels.tsa.api import SimpleExpSmoothing;

# ==== Storage ====
def save_twocolorball_into_csv():
    sql = "select open_time, issue, front_winning_num, back_winning_num from lottery_twocolorball order by issue";
    data = execute_(sql);
    column_list = ["开奖日期", "期号", "红球", "蓝球"];
    df = DataFrame(data=data, columns=column_list);
    # 将红球按空格拆分为多列
    df = pd.concat([
        df[["开奖日期", "期号"]],
        df["红球"].str.split(" ", expand=True).rename(columns={0:'红球1', 1:'红球2', 2:'红球3', 3:'红球4', 4:'红球5', 5:'红球6'}),
        df["蓝球"],
    ], axis=1);
    print(df.head());
    df.to_csv(path_or_buf="/temp/twocolorball.csv", encoding="gbk");

# ==== Data Processing ====
def add_number_pool(l, num, is_blue=False):
    max = 16 if is_blue else 33;
    if is_blue and num <= max and num > 0:
        l.append(num);
        return l;
    if not is_blue and num <= max and num > 0 and not l.__contains__(num):
        l.append(num);
        l.sort();
        return l;
    return add_number_pool(l, random.randint(1, max), is_blue);

def init_data():
    df = pd.read_csv("/temp/twocolorball.csv", encoding="gbk").drop(labels="Unnamed: 0", axis=1);
    df = df.sort_values(by="期号", ascending=True);
    print(df.head());
    return df;

def ses_forecast(df):
    l = [];
    for i in range(1, 8):
        column = "红球%d" % i if i < 7 else "蓝球";
        fit_model = SimpleExpSmoothing(np.asarray(df[column])).fit(
            smoothing_level=random.randint(1, 10) / 10,
            optimized=False
        );
        predict = fit_model.predict();
        is_blue = False if i < 7 else True;
        l = add_number_pool(l, int(round(predict[0], 0)), is_blue);
    print(l);
    return l;

def holt_forecast(df):
    l = [];
    for i in range(1, 8):
        column = "红球%d" % i if i < 7 else "蓝球";
        fit_model = Holt(np.asarray(df[column])).fit(
            smoothing_level=random.randint(1, 10) / 10,
            smoothing_slope=random.randint(1, 10) / 10,
            optimized=False
        );
        predict = fit_model.predict();
        is_blue = False if i < 7 else True;
        l = add_number_pool(l, int(round(predict[0], 0)), is_blue);
    print(l);
    return l;

if __name__ == '__main__':
    pass;