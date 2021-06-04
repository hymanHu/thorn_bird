#!/usr/bin/env python3
# -*- coding: utf-8 -*-
import requests
import re
from bs4 import BeautifulSoup
from lxml import etree
from _gzbd import gzbd_storage
from utils import spider_util

'''
爬取四川卫健委疫情数据
http://wsjkw.sc.gov.cn/scwsjkw/gzbd01/ztwzlmgl.shtml
'''

__author__ = "HymanHu";

wjw_regin = "四川"
wjw_domain = "http://wsjkw.sc.gov.cn"
wjw_base_url = "/scwsjkw/gzbd01/ztwzlmgl.shtml"
wjw_base_url_format = "/scwsjkw/gzbd01/ztwzlmgl_{0}.shtml"
wjw_page_count = 3
request_headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:77.0) Gecko/20100101 Firefox/77.0',
    # 'Cookie': spider_util.get_cookies("%s%s" % (wjw_domain, wjw_base_url)),
};

# 获取冠状病毒所有数据
def gzbd_all_data():
    all_data = []

    # 创建新闻列表页url && 获取列表页的数据
    urls = [(wjw_domain + wjw_base_url_format).format(i) for i in range(2, wjw_page_count + 1)]
    urls.insert(0, wjw_domain + wjw_base_url)
    for url in urls:
        print("Visit url: %s"%(url,))
        # news_list = news_page_data(url)
        news_list = news_page_data_xpath(url)
        all_data += news_list

    print(all_data)
    return all_data;

# 爬取新闻列表页数据
def news_page_data(url):
    news_list = []

    try:
        r = requests.get(url, headers=request_headers)
        if r.status_code == 200:
            r.encoding = r.apparent_encoding

            bs = BeautifulSoup(r.text, "html.parser")
            li_list = bs.find(name="div", attrs={"class": "contMain fontSt"}).find_all(name='li')
            for li in li_list:
                child_span = li.findChildren("span", recursive=False)[0]
                child_a = li.findChildren("a", recursive=False)[0]
                new_dict = new_page_data(wjw_domain + child_a.get("href"))

                news_list.append(dict({"日期":child_span.get_text(), "地区":wjw_regin}, **new_dict))
        else:
            print("Return error status code(%d)" % (r.status_code,))
    except Exception as e:
        print(e)

    return news_list

# 爬取新闻页数据
def new_page_data(url):
    print("visit:", url)
    # 装载新闻页数据
    new_dict = {}

    try:
        # requests获取页面内容
        r = requests.get(url, headers=request_headers)
        if r.status_code == 200:
            r.encoding = r.apparent_encoding

            # bs4解析页面标签
            bs = BeautifulSoup(r.text, "html.parser")
            span_list = bs.find_all(name="span", attrs={"style": "font-size: 12pt;"})
            for span in span_list:
                line = span.get_text()
                if not line.__contains__("全省累计报"):
                    continue
                new_dict = new_line_parse(line)
        else:
            print("Return error status code(%d)" % (r.status_code,))
    except Exception as e:
        print(e)

    print(new_dict)
    return new_dict

# 处理新闻列表页数据 ---- xpath
def news_page_data_xpath(url):
    news_data = []

    r = requests.get(url)
    r.encoding = r.apparent_encoding

    xpath = etree.HTML(r.text)
    li_list = xpath.xpath("//div[@class='contMain fontSt']//li");
    for li in li_list:
        span = li.xpath("./span")[0]
        a = li.xpath("./a")[0]
        new_page_dict = new_page_data_xpath(wjw_domain + a.xpath("attribute::href")[0])
        new_page_dict["时间"] = span.text
        new_page_dict["地区"] = wjw_regin
        news_data.append(new_page_dict)

    print(news_data)
    return news_data

# 处理新闻页数据 ---- xpath
def new_page_data_xpath(url):
    print("visit:", url)
    new_dict = {}
    r = requests.get(url)
    r.encoding = r.apparent_encoding

    xpath = etree.HTML(r.text)
    # new_span = xpath.xpath("//span[@style='font-size: 12pt;'][contains(.//text(),'全省累计')]")[0];
    # new_dict = new_line_parse(new_span.text)
    span_list = xpath.xpath("//span[@style='font-size: 12pt;']/text()")
    for span_text in span_list:
        if span_text and not span_text.__contains__("全省累计"):
            continue
        new_dict = new_line_parse(span_text)

    print(new_dict)
    return new_dict

# 解析新闻字符串
def new_line_parse(new_line):
    new_dict = {}
    # 正则表达式提取数据，并装载到dict
    line_re_1 = r'全省累计报告新型冠状病毒肺炎确诊病例(\d+)例\(其中境外输入(\d+)例\），' \
                r'累计治愈出院(\d+)例，死亡(\d+)例，目前在院隔离治疗(\d+)例，(\d+)人尚在接受医学观察'
    line_re_2 = r'全省累计报告新型冠状病毒肺炎确诊病例(\d+)例（其中境外输入(\d+)例），' \
                r'累计治愈出院(\d+)例，死亡(\d+)例'
    line_re_3 = r'全省累计报告新型冠状病毒肺炎确诊病例(\d+)例（其中境外输入(\d+)例），' \
                r'累计治愈出院(\d+)例,死亡(\d+)例'
    line_re_4 = r'尚在集中隔离医学观察(\d+)例'
    line_re_5 = r'全省累计报告新型冠状病毒肺炎确诊病例(\d+)例\(其中境外输入(\d+)\），' \
                r'累计治愈出院(\d+)例，死亡(\d+)例，目前在院隔离治疗(\d+)例，(\d+)人尚在接受医学观察'
    line_re_6 = r'全省累计报告新型冠状病毒肺炎确诊病例(\d+)例\(其中境外输入(\d+)例\），' \
                r'累计治愈出院(\d+)例，死亡(\d+)例，目前在院隔离治疗(\d+)例，(\d+)尚在接受医学观察'
    re_1 = re.search(line_re_1, new_line)
    re_2 = re.search(line_re_2, new_line)
    re_3 = re.search(line_re_3, new_line)
    re_4 = re.search(line_re_4, new_line)
    re_5 = re.search(line_re_5, new_line)
    re_6 = re.search(line_re_6, new_line)
    if re_1:
        new_dict["确诊数"] = re_1.group(1)
        new_dict["境外输入数"] = re_1.group(2)
        new_dict["治愈数"] = re_1.group(3)
        new_dict["死亡数"] = re_1.group(4)
        new_dict["隔离数"] = re_1.group(5)
        new_dict["观察数"] = re_1.group(6)
    if re_5:
        new_dict["确诊数"] = re_5.group(1)
        new_dict["境外输入数"] = re_5.group(2)
        new_dict["治愈数"] = re_5.group(3)
        new_dict["死亡数"] = re_5.group(4)
        new_dict["隔离数"] = re_5.group(5)
        new_dict["观察数"] = re_5.group(6)
    if re_6:
        new_dict["确诊数"] = re_6.group(1)
        new_dict["境外输入数"] = re_6.group(2)
        new_dict["治愈数"] = re_6.group(3)
        new_dict["死亡数"] = re_6.group(4)
        new_dict["隔离数"] = re_6.group(5)
        new_dict["观察数"] = re_6.group(6)
    if re_2:
        new_dict["确诊数"] = re_2.group(1)
        new_dict["境外输入数"] = re_2.group(2)
        new_dict["治愈数"] = re_2.group(3)
        new_dict["死亡数"] = re_2.group(4)
    if re_3:
        new_dict["确诊数"] = re_3.group(1)
        new_dict["境外输入数"] = re_3.group(2)
        new_dict["治愈数"] = re_3.group(3)
        new_dict["死亡数"] = re_3.group(4)
    if re_4:
        new_dict["观察数"] = re_4.group(1)

    return new_dict

if __name__ == "__main__":
    # url = "http://wsjkw.sc.gov.cn/scwsjkw/gzbd01/2020/9/16/bfc30e1e1947441ca65d79c60f4ea79b.shtml";
    # print(new_page_data(url));
    # url = "http://wsjkw.sc.gov.cn/scwsjkw/gzbd01/ztwzlmgl.shtml";
    # print(news_page_data(url));
    gzbd_data = gzbd_all_data();
    gzbd_storage.storage_mysql(gzbd_data);

