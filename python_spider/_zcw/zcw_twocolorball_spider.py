#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
中彩网双色球数据爬虫
http://kaijiang.zhcw.com/zhcw/html/ssq/list.html
https://www.zhcw.com/kjxx/ssq/
'''

# 将项目根目录添加到 sys.path，解决 cmd 下执行该模块找不到包的问题
import sys, os;
current_path = os.path.abspath(os.path.dirname(__file__));
separator = "\\" if os.name == "nt" else "/";
project_name = "python_spider" + separator;
root_path = current_path[:current_path.find(project_name) + len(project_name)];  # 获取项目根目录
sys.path.append(root_path);

from _zcw.TwoColorBall import TwoColorBall;
from utils.sqlalchemy_util import *;
import time;
import re;
import json;
import requests;
from bs4 import BeautifulSoup;
from datetime import datetime;

headers = {
    "Cookie":"PHPSESSID=p3rhl1db46sicot43t13bs0ma6; KLBRSID=13ce4968858adba085afff577d78760d|1626505318|1626505318; Hm_lvt_692bd5f9c07d3ebd0063062fb0d7622f=1626504922; Hm_lpvt_692bd5f9c07d3ebd0063062fb0d7622f=1626504940; Hm_lvt_12e4883fd1649d006e3ae22a39f97330=1626504922; Hm_lpvt_12e4883fd1649d006e3ae22a39f97330=1626504940; _ga=GA1.2.2016479514.1626504922; _gid=GA1.2.203748606.1626504922",
    "User-Agent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:89.0) Gecko/20100101 Firefox/89.0",
    "Referer":"https://www.zhcw.com/",
};
sleep_time = 5;

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
                first_award_num=re.findall(
                    '<td align="left" style="color:#999;"><strong>(.*?)</strong>', str(tr)
                )[0],
                second_award_num=re.findall(
                    '<td align="center"><strong class="rc">(.*?)</strong></td>', str(tr)
                )[0]
            );
            print(twoColorBall.__dict__);
            insert_(twoColorBall, "issue");
            time.sleep(sleep_time);

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
            insert_(twoColorBall, "issue");
        time.sleep(sleep_time);

if __name__ == '__main__':
    pass
    # parse_winning_page_1();
    # parse_winning_page_2();