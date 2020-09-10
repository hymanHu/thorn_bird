#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
spider util
'''

from selenium import webdriver;
import time;

def get_cookies(url):
    # webdriver 模拟 FireFox 浏览器，成功后会弹出浏览器访问该网页
    driver = webdriver.Firefox(executable_path=r'D:\Program Files\Mozilla Firefox\geckodriver.exe');
    driver.get(url);
    time.sleep(3);
    cookies = driver.get_cookies();
    driver.quit();
    items = [];
    for i in range(len(cookies)):
        cookie = cookies[i];
        item = cookie["name"] + "=" + cookie["value"];
        items.append(item);
        cookies_str = ";".join(item for item in items);
    return cookies_str;

if __name__ == "__main__":
    url = "http://wsjkw.sc.gov.cn/scwsjkw/gzbd01/ztwzlmgl.shtml";
    get_cookies(url);