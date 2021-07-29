#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
中彩网双色球应用
'''

# 将项目根目录添加到 sys.path，解决 cmd 下执行该模块找不到包的问题
import sys, os;
current_path = os.path.abspath(os.path.dirname(__file__));
separator = "\\" if os.name == "nt" else "/";
project_name = "python_spider" + separator;
root_path = current_path[:current_path.find(project_name) + len(project_name)];  # 获取项目根目录
sys.path.append(root_path);

from _zcw.zcw_twocolorball_spider import *;
from _zcw.zcw_twocolorball_data_processing import *;
from utils.sqlalchemy_util import *;

# ==== 应用主入口 ====
def application():
    init_db();
    # 调整参数爬取记录
    parse_winning_page_2(issue_count=10, page_size=10);
    save_twocolorball_into_csv();
    df = init_data();
    ses_result = ses_forecast(df);
    holt_result = holt_forecast(df);
    lstm_result = lstm_forecast(df);
    print("SES 预测结果：%s" % ses_result);
    print("HOLT 预测结果：%s" % holt_result);
    print("LSTM 预测结果：%s" % lstm_result);

if __name__ == '__main__':
    pass
    application();