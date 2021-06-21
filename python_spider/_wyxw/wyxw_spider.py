#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
网易国内新闻爬虫
https://news.163.com/domestic/
'''

# 将项目根目录添加到 sys.path，解决 cmd 下执行该模块找不到包的问题
import sys, os;
current_path = os.path.abspath(os.path.dirname(__file__));
separator = "\\" if os.name == "nt" else "/";
project_name = "python_spider" + separator;
root_path = current_path[:current_path.find(project_name) + len(project_name)];  # 获取项目根目录
sys.path.append(root_path);

import requests;
from bs4 import BeautifulSoup;
import json;
from datetime import datetime;
from _wyxw import wyxw_storage;

page_count = 2;

def get_news_data():
    # 构建新闻分页 url 列表
    url_pattern = "https://temp.163.com/special/00804KVA/cm_guonei_%02d.js?callback=data_callback";
    news_page_url_list = list(url_pattern % page for page in range(2, page_count + 1));
    news_page_url_list.insert(0, "https://temp.163.com/special/00804KVA/cm_guonei.js?callback=data_callback");
    print("爬取新闻分页页数：%d" % len(news_page_url_list));
    print(news_page_url_list);

    # 从次新闻分页列表中获取新闻信息，装入新闻列表中
    news_list = [];
    news_list_error = [];
    for url in news_page_url_list:
        r = requests.get(url);
        r.encoding = r.apparent_encoding;
        for news in json.loads(r.text[len("data_callback("):-1]):
            dict = {};
            dict["title"] = news.get("title");
            dict["digest"] = news.get("digest"); # 摘要
            dict["url"] = news.get("tlink");
            dict["view_count"] = news.get("tienum");
            dict["label"] = news.get("label");
            keywords = [];
            for keyword in news.get("keywords"):
                keywords.append(keyword.get("keyname"));
            dict["keywords"] = ",".join(keywords);
            dict["news_date"] = datetime.strptime(news.get("time"), "%m/%d/%Y %H:%M:%S");
            dict["news_type"] = news.get("news_type");
            dict["channel"] = news.get("channelname"); # 渠道
            dict["source"] = news.get("source"); # 来源
            dict["image_url"] = news.get("imgurl");
            dict["detail"] = get_news_detail(news.get("tlink"));
            if not wyxw_storage.wyxw_storage(dict):
                news_list_error.append(dict["url"]);
            else:
                news_list.append(dict);

    print("爬取新闻总数：%d" % len(news_list));
    print(news_list);
    return news_list, news_list_error;

# 获取每个新闻详情
def get_news_detail(url):
    print("Vist %s" % url);
    try:
        r = requests.get(url);
        r.encoding = r.apparent_encoding;

        bs = BeautifulSoup(r.text, "html.parser");
        div = bs.find(name="div", attrs={"class": "post_body"});
        lines = [];
        if div:
            for child in div.children:
                if child.name == "p":
                    # 新闻中有视频时，页面将样式放在 p 标签中，去掉样式内容
                    style_list = child.findChildren("style", recursive=False);
                    if len(style_list) > 0:
                        continue;
                    # 去掉特殊字符串 ^，！，$，#，&
                    lines.append(child.get_text().replace("'", "").replace("^", "")
                                 .replace("!", "").replace("$", "").replace("#", "").replace("&", ""));
            detail = "\r\n".join(lines);
            print(detail);
            return detail;
        else:
            return "";
    except Exception as e:
        print(e);
        return "";

if __name__ == "__main__":
    # url = "https://www.163.com/news/article/G9FMGA1100019K82.html";
    # get_news_detail(url);
    news_list, news_list_error = get_news_data();
    print(news_list_error);
