#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
xpath test
'''

# 将项目根目录添加到 sys.path，解决 cmd 下执行该模块找不到包的问题
import sys, os;
current_path = os.path.abspath(os.path.dirname(__file__));
separator = "\\" if os.name == "nt" else "/";
project_name = "python_spider" + separator;
root_path = current_path[:current_path.find(project_name) + len(project_name)];  # 获取项目根目录
sys.path.append(root_path);

import requests;
from lxml import etree;

def new_page_data(url):
    r = requests.get(url);
    r.encoding = r.apparent_encoding;

    html_xpath = etree.HTML(r.text);
    # new_span = html_xpath.xpath("//div[@class='wy_contMain fontSt']//span[contains(.//text(),'截至')]");
    new_span = html_xpath.xpath("//div[@class='wy_contMain fontSt']//span[position()=2]");
    print(type(new_span[0].text)); # <class 'str'>
    print(new_span[0].text)
    new_span = html_xpath.xpath("//div[@class='wy_contMain fontSt']//span[position()=2]//text()");
    print(type(new_span[0])); # <class 'lxml.etree._ElementUnicodeResult'>
    print(new_span[0])

def news_page_data(url):
    r = requests.get(url);
    r.encoding = r.apparent_encoding;

    html_xpath = etree.HTML(r.text);
    li_list = html_xpath.xpath("//div[@class='contMain fontSt']//li");
    for li in li_list:
        span = li.xpath("./span");
        # print(type(span));
        # print(etree.tostring(span[0]).decode("utf-8"));
        print(span[0].text);
        a = li.xpath("./a");
        print(a[0].text); # 获取 a 标签内容
        print(a[0].xpath("attribute::href")[0]); # 获取 a 标签节点 href 属性

if __name__ == "__main__":
    # url = "http://wsjkw.sc.gov.cn/scwsjkw/gzbd01/2020/9/3/fe0eb6e3101d4709a9bbd27f5a12ae78.shtml";
    # new_page_data(url);
    url = "http://wsjkw.sc.gov.cn/scwsjkw/gzbd01/ztwzlmgl.shtml";
    news_page_data(url);
