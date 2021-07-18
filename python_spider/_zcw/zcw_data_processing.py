#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
中彩网双色球数据分析
'''

# 将项目根目录添加到 sys.path，解决 cmd 下执行该模块找不到包的问题
import sys, os;
current_path = os.path.abspath(os.path.dirname(__file__));
separator = "\\" if os.name == "nt" else "/";
project_name = "python_spider" + separator;
root_path = current_path[:current_path.find(project_name) + len(project_name)];  # 获取项目根目录
sys.path.append(root_path);

import random;
import numpy as np;
import pandas as pd;
from statsmodels.tsa.api import Holt;
from statsmodels.tsa.api import SimpleExpSmoothing;

def init_twocolorball_data():
    df = pd.read_csv("/temp/twocolorball.csv", encoding="gbk").drop(labels="Unnamed: 0", axis=1);
    print(df);
    return df;

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
        l.append(int(predict[0]));
    print(l);
    return l;

def ses_forecast(df):
    l = [];
    for i in range(1, 8):
        column = "红球%d" % i if i < 7 else "蓝球";
        fit_model = SimpleExpSmoothing(np.asarray(df[column])).fit(
            smoothing_level=random.randint(1, 10) / 10,
            optimized=False
        );
        predict = fit_model.predict();
        l.append(int(predict[0]));
    print(l);
    return l;

if __name__ == "__main__":
    df = init_twocolorball_data();
    result_1 = holt_forecast(df);
    result_2 = ses_forecast(df);


