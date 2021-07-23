#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
TwoColorBall
'''

# 将项目根目录添加到 sys.path，解决 cmd 下执行该模块找不到包的问题
import sys, os;
current_path = os.path.abspath(os.path.dirname(__file__));
separator = "\\" if os.name == "nt" else "/";
project_name = "python_spider" + separator;
root_path = current_path[:current_path.find(project_name) + len(project_name)];  # 获取项目根目录
sys.path.append(root_path);

from utils.sqlalchemy_util import *;

# 定义实体类
class TwoColorBall(Base):
    # 表名
    __tablename__ = "lottery_twocolorball";
    # 创建表的参数
    __table_args__ = {
        "mysql_charset": "utf8"
    };

    # 属性
    id = Column(Integer, primary_key=True, autoincrement=True, nullable=False);
    create_date =Column(DateTime);
    issue =Column(String(55));
    open_time =Column(String(255));
    front_winning_num =Column(String(255));
    seq_front_winning_num =Column(String(255));
    back_winning_num =Column(String(255));
    seq_back_winning_num =Column(String(255));
    sale_money =Column(Float);
    prize_pool_money =Column(Float);
    first_award_num =Column(Integer);
    first_award_money =Column(Float);
    second_award_num =Column(Integer);
    second_award_money =Column(Float);
    third_award_num =Column(Integer);
    third_award_money =Column(Float);
    fourth_award_num =Column(Integer);
    fourth_award_money =Column(Float);
    fifth_award_num =Column(Integer);
    fifth_award_money =Column(Float);
    sixth_award_num =Column(Integer);
    sixth_award_money =Column(Float);