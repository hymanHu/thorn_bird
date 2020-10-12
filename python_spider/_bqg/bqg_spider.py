#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import requests
from bs4 import BeautifulSoup
from _bqg import bqg_storage
import time

'''
笔趣阁小说爬取，保存到本地文件
'''

__author__ = "HymanHu";

bqg_base_url = "https://www.qu.la"
headers = {"User-Agent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:81.0) Gecko/20100101 Firefox/81.0"}
def novel_data(novel_name, url):
    time.sleep(5)

    r = requests.get(url, headers=headers)
    r.encoding = r.apparent_encoding

    soap = BeautifulSoup(r.text, "html.parser")
    # 查找下一页链接
    a_list = soap.find("div", attrs={"class": "section-opt"}).find_all("a")
    next_link = [bqg_base_url + item.get("href") for item in a_list if str(item.text).startswith("下")][0]
    # 查找标题
    title = soap.find("h1", attrs={"class": "title"}).text
    # 查找内容
    content = soap.find("div", attrs={"id", "content"}).prettify()
    soap = BeautifulSoup(content, "html.parser")
    lines = soap.text.split("\n")
    lines = [line for line in lines if len(line.strip()) != 0]
    lines.insert(0, "\n")
    lines.insert(1, title)
    lines.insert(2, "\n")
    print("visit:", url)
    print(lines)
    bqg_storage.novel_save(novel_name, lines)

    if next_link:
        novel_data(novel_name, next_link)

if __name__ == '__main__':
    url = "https://www.qu.la/book/2970/2763033.html"
    novel_data("超品相师", url)