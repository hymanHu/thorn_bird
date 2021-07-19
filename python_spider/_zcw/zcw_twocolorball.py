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

from sqlalchemy import Column, String, Integer, Float, DateTime, ForeignKey, create_engine, and_, or_;
from sqlalchemy.orm import sessionmaker, relationship;
from sqlalchemy.ext.declarative import declarative_base;
import random;
import time;
import re;
import json;
import requests;
from bs4 import BeautifulSoup;
from datetime import datetime;
import numpy as np;
import pandas as pd;
from pandas import DataFrame;
from statsmodels.tsa.api import Holt;
from statsmodels.tsa.api import SimpleExpSmoothing;

# 创建对象基类
Base = declarative_base();

# 创建数据库表
def init_db():
    engine = create_engine("mysql+mysqlconnector://root:root@localhost:3306/test");
    Base.metadata.create_all(engine, checkfirst=True);

# 创建数据库引擎，初始化 DB Session
def init_db_session():
    engine = create_engine("mysql+mysqlconnector://root:root@localhost:3306/test");
    session = sessionmaker(bind=engine);
    return session();

# 定义实体类
class TwoColorBall(Base):
    # 表名
    __tablename__ = "lottery_twocolorball";
    # 创建表的参数
    __table_args__ = {
        "mysql_charset": "utf8"
    };
    # 表结构
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

    # 插入数据库
    def insert_twocolorball(self):
        session = init_db_session();
        results = session.query(TwoColorBall).filter(TwoColorBall.issue == self.issue).all();
        if len(results) == 0:
            session.add(self);
            session.commit();
        session.close();

    # 修改数据
    def update_twocolorball(self):
        d = self.__dict__;
        d.pop("_sa_instance_state");
        session = init_db_session();
        session.query(TwoColorBall).filter(TwoColorBall.issue == self.issue).update(d);
        session.commit();
        session.close();

    # 删除数据
    def delete_twocolorball(self):
        session = init_db_session();
        session.query(TwoColorBall).filter(TwoColorBall.issue == self.issue).delete();
        session.commit();
        session.close();

    # 查询所有
    def get_twocolorballs(self):
        session = init_db_session();
        twocolorballs = session.query(TwoColorBall).all();
        session.close();
        return twocolorballs;

    # 查询单个
    def get_twocolorball_by_issue(self):
        session = init_db_session();
        twocolorball = session.query(TwoColorBall).filter(TwoColorBall.issue == self.issue).first();
        session.close();
        return twocolorball;

    # 多条件查询
    def get_twocolorballs_by_args(self):
        session = init_db_session();
        twocolorballs = session.query(TwoColorBall).filter(
            or_(
                TwoColorBall.issue == self.issue,
                TwoColorBall.open_time.like("%2021%")
            )
        ).all();
        session.close();
        return twocolorballs;

    # 原生 sql
    def execute_(sql):
        session = init_db_session();
        results = None;
        if sql.lower().startswith("select"):
            results = session.execute(sql).fetchall();
        else:
            results = session.execute(sql);
            session.commit();
        session.close();
        return results;

# ==== Spider ====
headers = {
    "Cookie":"PHPSESSID=p3rhl1db46sicot43t13bs0ma6; KLBRSID=13ce4968858adba085afff577d78760d|1626505318|1626505318; Hm_lvt_692bd5f9c07d3ebd0063062fb0d7622f=1626504922; Hm_lpvt_692bd5f9c07d3ebd0063062fb0d7622f=1626504940; Hm_lvt_12e4883fd1649d006e3ae22a39f97330=1626504922; Hm_lpvt_12e4883fd1649d006e3ae22a39f97330=1626504940; _ga=GA1.2.2016479514.1626504922; _gid=GA1.2.203748606.1626504922",
    "User-Agent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:89.0) Gecko/20100101 Firefox/89.0",
    "Referer":"https://www.zhcw.com/",
};

# 解析 http://kaijiang.zhcw.com/zhcw/html/ssq/list.html
def parse_winning_page_1():
    page_count = 137;
    url_list = list("http://kaijiang.zhcw.com/zhcw/html/ssq/list_%d.html" % page for page in range(2, page_count + 1));
    url_list.insert(0, "http://kaijiang.zhcw.com/zhcw/html/ssq/list.html");
    for url in url_list:
        print(url);
        r = requests.get(url);
        if r.status_code != 200:
            print("服务器响应错误。");
            continue;

        bs = BeautifulSoup(markup=r.text, features="html.parser");
        tr_list = bs.find_all(name="tr");
        for tr in tr_list:
            results = re.findall('<td align="center">(.*?)</td>', str(tr));
            if len(results) == 0:
                continue;
            twoColorBall = TwoColorBall(
                create_date=datetime.now().strftime("%Y-%m-%d %H:%M:%S"),
                issue=re.findall('<td align="center">(.*?)</td>', str(tr))[1],
                open_time=re.findall('<td align="center">(.*?)</td>', str(tr))[0],
                front_winning_num=" ".join(re.findall('<em class="rr">(.*?)</em>', str(tr))),
                back_winning_num=re.findall('<em>(.*?)</em>', str(tr))[0],
                sale_money=re.findall('<td><strong>(.*?)</strong></td>', str(tr))[0].replace(",", ""),
                first_award_num=re.findall('<td align="left" style="color:#999;"><strong>(.*?)</strong>', str(tr))[
                    0],
                second_award_num=re.findall('<td align="center"><strong class="rc">(.*?)</strong></td>', str(tr))[0]
            );
            print(twoColorBall.__dict__);
            twoColorBall.insert_twocolorball();
            time.sleep(3);

# 解析 https://www.zhcw.com/kjxx/ssq/
def parse_winning_page_2(issue_count=3000, page_size=100):
    page_count = (issue_count // page_size) if (issue_count % page_size == 0) else (issue_count // page_size + 1);
    url_list = list("https://jc.zhcw.com/port/client_json.php?callback=jQuery112204220254081055794_1626504921530"
                    "&transactionType=10001001&lotteryId=1&issueCount=%d&startIssue=&endIssue=&startDate=&endDate="
                    "&type=0&pageNum=%d&pageSize=%d&tt=0.07175752902295573&_=1626504921533" %
                    (issue_count, page, page_size) for page in range(1, page_count + 1));
    for url in url_list:
        print(url);
        r = requests.get(url, headers=headers);
        if r.status_code != 200:
            print("服务器响应错误。");
            continue;

        r.encoding == r.apparent_encoding;
        result = re.findall("jQuery112204220254081055794_1626504921530\((.*?)\)", r.text);
        if len(result) == 0:
            continue;
        result = json.loads(result[0]);
        for item in result["data"]:
            twoColorBall = TwoColorBall(
                create_date=datetime.now().strftime("%Y-%m-%d %H:%M:%S"),
                issue=item["issue"],
                open_time=item["openTime"],
                front_winning_num=item["frontWinningNum"],
                seq_front_winning_num=item["seqFrontWinningNum"],
                back_winning_num=item["backWinningNum"],
                seq_back_winning_num=item["seqBackWinningNum"],
                sale_money=item["saleMoney"],
                prize_pool_money=item["prizePoolMoney"],
                first_award_num=item["winnerDetails"][0]["baseBetWinner"]["awardNum"],
                first_award_money=item["winnerDetails"][0]["baseBetWinner"]["awardMoney"],
                second_award_num=item["winnerDetails"][1]["baseBetWinner"]["awardNum"],
                second_award_money=item["winnerDetails"][1]["baseBetWinner"]["awardMoney"],
                third_award_num=item["winnerDetails"][2]["baseBetWinner"]["awardNum"],
                third_award_money=item["winnerDetails"][2]["baseBetWinner"]["awardMoney"],
                fourth_award_num=item["winnerDetails"][3]["baseBetWinner"]["awardNum"],
                fourth_award_money=item["winnerDetails"][3]["baseBetWinner"]["awardMoney"],
                fifth_award_num=item["winnerDetails"][4]["baseBetWinner"]["awardNum"],
                fifth_award_money=item["winnerDetails"][4]["baseBetWinner"]["awardMoney"],
                sixth_award_num=item["winnerDetails"][5]["baseBetWinner"]["awardNum"],
                sixth_award_money=item["winnerDetails"][5]["baseBetWinner"]["awardMoney"],
            );
            print(twoColorBall.__dict__);
            twoColorBall.insert_twocolorball();
        time.sleep(3);

# ==== Storage ====
def save_twocolorball_into_csv():
    sql = "select open_time, issue, front_winning_num, back_winning_num from lottery_twocolorball order by issue desc";
    data = TwoColorBall.execute_(sql);
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
    if is_blue and num <= max:
        l.append(num);
        return l;
    if not is_blue and num <= max and not l.__contains__(num):
        l.append(num);
        return l;
    return add_number_pool(l, random.randint(1, max));

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
        l = add_number_pool(l, int(predict[0]), is_blue);
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
        l = add_number_pool(l, int(predict[0]), is_blue);
    print(l);
    return l;

# 模型训练数据集，通过几次数据来预测下一次，x1、x2、x3 为三次训练数据，y 为验证数据
def init_lstm_train_data(data, train_length=3):
    data_x, data_y = [], [];
    for i in range(len(data) - train_length):
        data_x.append(data[i : i + train_length]);
        data_y.append(data[i + train_length]);
    return np.asarray(data_x), np.asarray(data_y);

from keras.models import Sequential
from tensorflow import keras
def lstm_forecast(df=[]):
    # model = Sequential()
    # model.add(LSTM(50, activation='relu', input_shape=(1, 1)))
    # model.add(Dense(1))
    # model.compile(optimizer='adam', loss='mse')
    # print(model.summary())

    x_train = np.random.rand(10000, 2)
    y_train = 3 * x_train[:, 0] + 2 * x_train[:, 1] + 1
    model = keras.models.Sequential()
    # 使用add方法添加隐层
    model.add(keras.layers.Dense(512, activation='sigmoid', input_dim=2, use_bias=True))

    model.add(keras.layers.Dense(1, activation='sigmoid', use_bias=True))
    # 编译模型
    model.compile(loss=keras.losses.mean_squared_error,
                  optimizer=keras.optimizers.Adam(0.01),
                  metrics=['accuracy'])
    # 训练模型
    model.fit(x_train, y_train, batch_size=10)
    pass

# ==== 应用主入口 ====
def application():
    init_db();
    # 调整参数爬取记录
    parse_winning_page_2(issue_count=10, page_size=10);
    save_twocolorball_into_csv();
    df = init_data();
    holt_forecast(df);
    ses_forecast(df);

if __name__ == '__main__':
    # init_db();
    # parse_winning_page_1();
    # parse_winning_page_2();
    # save_twocolorball_into_csv();
    # df = init_data();
    # holt_forecast(df);
    # ses_forecast(df);
    # application();
    # data_x, data_y = init_lstm_train_data(data=np.asarray(df["红球1"]));
    # print(data_x[1]);
    # print(data_y);

    lstm_forecast();

    # x_train = np.random.rand(10000, 2)
    # y_train = 3 * x_train[:, 0] + 2 * x_train[:, 1] + 1
    # print(x_train)
    # print(x_train.shape)
    # print(y_train)
    # print(y_train.shape)