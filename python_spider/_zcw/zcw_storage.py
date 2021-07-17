#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
中彩网双色球数据存储
'''

# 将项目根目录添加到 sys.path，解决 cmd 下执行该模块找不到包的问题
import sys, os;
current_path = os.path.abspath(os.path.dirname(__file__));
separator = "\\" if os.name == "nt" else "/";
project_name = "python_spider" + separator;
root_path = current_path[:current_path.find(project_name) + len(project_name)];  # 获取项目根目录
sys.path.append(root_path);

from utils import mysql_util;
from datetime import datetime;

def save_twocolorball_into_db(d, update=False):
    query_sql = "select * from lottery_twocolorball where issue = '%s'" % d["issue"];
    insert_sql = "insert into lottery_twocolorball(create_date, issue, open_time, front_winning_num, seq_front_winning_num, " \
                 "back_winning_num, seq_back_winning_num, sale_money, prize_pool_money, first_award_num, first_award_money, " \
                 "second_award_num, second_award_money, third_award_num, third_award_money, fourth_award_num, " \
                 "fourth_award_money, fifth_award_num, fifth_award_money, sixth_award_num, sixth_award_money) values (" \
                 "'%s','%s','%s','%s','%s','%s','%s',%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)" % \
                 (datetime.now().strftime("%Y-%m-%d %H:%M:%S"), d.get("issue", ""), d.get("open_time", ""),
                  d.get("front_winning_num", ""), d.get("seq_front_winning_num", ""), d.get("back_winning_num", ""),
                  d.get("seq_back_winning_num", ""), d.get("sale_money", 0), d.get("prize_pool_money", 0),
                  d.get("first_award_num", 0), d.get("first_award_money", 0), d.get("second_award_num", 0),
                  d.get("second_award_money", 0), d.get("third_award_num", 0), d.get("third_award_money", 0),
                  d.get("fourth_award_num", 0), d.get("fourth_award_money", 0), d.get("fifth_award_num", 0),
                  d.get("fifth_award_money", 0), d.get("sixth_award_num", 0), d.get("sixth_award_money", 0));
    update_sql = "update lottery_twocolorball set open_time = '%s', front_winning_num='%s', seq_front_winning_num='%s', " \
                 "back_winning_num='%s', seq_back_winning_num='%s', sale_money=%s, prize_pool_money=%s, first_award_num=%s, " \
                 "first_award_money=%s, second_award_num=%s, second_award_money=%s, third_award_num=%s, " \
                 "third_award_money=%s, fourth_award_num=%s, fourth_award_money=%s, fifth_award_num=%s, " \
                 "fifth_award_money=%s, sixth_award_num=%s, sixth_award_money=%s where issue='%s'" % \
                 (d.get("open_time", ""),
                  d.get("front_winning_num", ""), d.get("seq_front_winning_num", ""), d.get("back_winning_num", ""),
                  d.get("seq_back_winning_num", ""), d.get("sale_money", 0), d.get("prize_pool_money", 0),
                  d.get("first_award_num", 0), d.get("first_award_money", 0), d.get("second_award_num", 0),
                  d.get("second_award_money", 0), d.get("third_award_num", 0), d.get("third_award_money", 0),
                  d.get("fourth_award_num", 0), d.get("fourth_award_money", 0), d.get("fifth_award_num", 0),
                  d.get("fifth_award_money", 0), d.get("sixth_award_num", 0), d.get("sixth_award_money", 0), d.get("issue", ""));
    # print(query_sql);
    # print(insert_sql);
    # print(update_sql);
    result = mysql_util.execute_(query_sql);
    if len(result) == 0:
        mysql_util.execute_(insert_sql);
    elif len(result) > 0 and update:
        mysql_util.execute_(update_sql);

if __name__ == "__main__":
    d = {'issue': '2021079', 'open_time': '2021-07-15', 'front_winning_num': '01 03 10 24 28 29', 'back_winning_num': '13', 'sale_money': '345574370', 'first_award_num': '8', 'second_award_num': '95'};
    save_twocolorball_into_db(d);