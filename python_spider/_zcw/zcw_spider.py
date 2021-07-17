#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
中彩网双色球数据爬取
http://kaijiang.zhcw.com/zhcw/html/ssq/list.html ---- 双色球历史记录1
https://www.zhcw.com/kjxx/ssq/ ---- 双色球历史记录2
'''

# 将项目根目录添加到 sys.path，解决 cmd 下执行该模块找不到包的问题
import sys, os;
current_path = os.path.abspath(os.path.dirname(__file__));
separator = "\\" if os.name == "nt" else "/";
project_name = "python_spider" + separator;
root_path = current_path[:current_path.find(project_name) + len(project_name)];  # 获取项目根目录
sys.path.append(root_path);

import time;
import re;
import json;
import requests;
from bs4 import BeautifulSoup;
from _zcw import zcw_storage;

headers = {
    "Cookie":"PHPSESSID=p3rhl1db46sicot43t13bs0ma6; KLBRSID=13ce4968858adba085afff577d78760d|1626505318|1626505318; Hm_lvt_692bd5f9c07d3ebd0063062fb0d7622f=1626504922; Hm_lpvt_692bd5f9c07d3ebd0063062fb0d7622f=1626504940; Hm_lvt_12e4883fd1649d006e3ae22a39f97330=1626504922; Hm_lpvt_12e4883fd1649d006e3ae22a39f97330=1626504940; _ga=GA1.2.2016479514.1626504922; _gid=GA1.2.203748606.1626504922",
    "User-Agent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:89.0) Gecko/20100101 Firefox/89.0",
    "Referer":"https://www.zhcw.com/",
};

# 获取所有历史数据
def parse_winning_page_1():
    l = [];
    page_count = 137;
    url_list = list("http://kaijiang.zhcw.com/zhcw/html/ssq/list_%d.html" % page for page in range(2, page_count + 1));
    url_list.insert(0, "http://kaijiang.zhcw.com/zhcw/html/ssq/list.html");
    for url in url_list:
        l += parse_single_winning_page_1(url);
        time.sleep(3);
    print(l);
    return l;

# 解析单张历史页面
def parse_single_winning_page_1(url):
    print(url);
    l = [];
    r = requests.get(url);
    if r.status_code == 200:
        bs = BeautifulSoup(markup=r.text, features="html.parser");
        tr_list = bs.find_all(name="tr");
        for tr in tr_list:
            results = re.findall('<td align="center">(.*?)</td>', str(tr));
            if len(results) > 0:
                d = {};
                d["issue"] = re.findall('<td align="center">(.*?)</td>', str(tr))[1];
                d["open_time"] = re.findall('<td align="center">(.*?)</td>', str(tr))[0];
                d["front_winning_num"] = " ".join(re.findall('<em class="rr">(.*?)</em>', str(tr)));
                d["back_winning_num"] = re.findall('<em>(.*?)</em>', str(tr))[0];
                d["sale_money"] = re.findall('<td><strong>(.*?)</strong></td>', str(tr))[0].replace(",", "");
                d["first_award_num"] = re.findall('<td align="left" style="color:#999;"><strong>(.*?)</strong>', str(tr))[0];
                d["second_award_num"] = re.findall('<td align="center"><strong class="rc">(.*?)</strong></td>', str(tr))[0];
                zcw_storage.save_twocolorball_into_db(d);
                l.append(d);
    else:
        print("服务器响应错误。");

    print(l);
    return l;

# 取最新第一页数据
def parse_single_winning_page_2(issue_count=2700, page_size=100):
    l = [];
    url = "https://jc.zhcw.com/port/client_json.php?callback=jQuery112204220254081055794_1626504921530&transactionType=10001001&lotteryId=1&issueCount=%d&startIssue=&endIssue=&startDate=&endDate=&type=0&pageNum=1&pageSize=%d&tt=0.07175752902295573&_=1626504921533" % \
          (issue_count, page_size);
    r = requests.get(url, headers=headers);
    if r.status_code == 200:
        r.encoding == r.apparent_encoding;
        result = re.findall("jQuery112204220254081055794_1626504921530\((.*?)\)", r.text);
        if len(result) > 0:
            result = json.loads(result[0]);
            for item in result["data"]:
                d = {};
                d["issue"] = item["issue"]
                d["open_time"] = item["openTime"]
                d["front_winning_num"] = item["frontWinningNum"]
                d["seq_front_winning_num"] = item["seqFrontWinningNum"]
                d["back_winning_num"] = item["backWinningNum"]
                d["seq_back_winning_num"] = item["seqBackWinningNum"]
                d["sale_money"] = item["saleMoney"]
                d["prize_pool_money"] = item["prizePoolMoney"]
                d["first_award_num"] = item["winnerDetails"][0]["baseBetWinner"]["awardNum"]
                d["first_award_money"] = item["winnerDetails"][0]["baseBetWinner"]["awardMoney"]
                d["second_award_num"] = item["winnerDetails"][1]["baseBetWinner"]["awardNum"]
                d["second_award_money"] = item["winnerDetails"][1]["baseBetWinner"]["awardMoney"]
                d["third_award_num"] = item["winnerDetails"][2]["baseBetWinner"]["awardNum"]
                d["third_award_money"] = item["winnerDetails"][2]["baseBetWinner"]["awardMoney"]
                d["fourth_award_num"] = item["winnerDetails"][3]["baseBetWinner"]["awardNum"]
                d["fourth_award_money"] = item["winnerDetails"][3]["baseBetWinner"]["awardMoney"]
                d["fifth_award_num"] = item["winnerDetails"][4]["baseBetWinner"]["awardNum"]
                d["fifth_award_money"] = item["winnerDetails"][4]["baseBetWinner"]["awardMoney"]
                d["sixth_award_num"] = item["winnerDetails"][5]["baseBetWinner"]["awardNum"]
                d["sixth_award_money"] = item["winnerDetails"][5]["baseBetWinner"]["awardMoney"]
                zcw_storage.save_twocolorball_into_db(d, update=True);
                l.append(d);
    else:
        print("服务器响应错误。");

    print(l);
    return l;


if __name__ == "__main__":
    # url = "http://kaijiang.zhcw.com/zhcw/html/ssq/list.html";
    # parse_single_winning_page_1(url);
    # parse_winning_page_1();
    parse_single_winning_page_2(page_size=100);