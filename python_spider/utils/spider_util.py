#!/usr/bin/env python3
# -*- coding: utf-8 -*-
import random
from selenium import webdriver;
import time;

__author__ = "HymanHu";

'''
spider util
'''

def get_cookies(url):
    # webdriver 模拟 FireFox 浏览器，成功后会弹出浏览器访问该网页
    # driver = webdriver.Firefox(executable_path=r'D:\Program Files\Mozilla Firefox\geckodriver.exe');
    driver = webdriver.Firefox(executable_path=r'C:\Program Files\Mozilla Firefox\geckodriver.exe');
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

user_agent_list = [
    "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36",
    "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36",
    "Mozilla/5.0 (Windows NT 10.0; …) Gecko/20100101 Firefox/61.0",
    "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36",
    "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.62 Safari/537.36",
    "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36",
    "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0)",
    "Mozilla/5.0 (Macintosh; U; PPC Mac OS X 10.5; en-US; rv:1.9.2.15) Gecko/20110303 Firefox/3.6.15",
]

if __name__ == "__main__":
    url = "http://wsjkw.sc.gov.cn/scwsjkw/gzbd01/ztwzlmgl.shtml";
    request_headers = {
        'Cookie': get_cookies(url),
    }
    request_headers['User-Agent'] = random.choice(user_agent_list)
    print(request_headers)