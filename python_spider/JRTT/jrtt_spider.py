#!/usr/bin/env python3
# -*- coding: utf-8 -*-
import requests

__author__ = "HymanHu";

'''
今日头条 spider
'''

def jrtt_page(url):
    r = requests.get(url)
    r.encoding = r.apparent_encoding
    print(r.content)

if __name__ == "__main__":
    url = "https://www.toutiao.com/";
    jrtt_page(url)

