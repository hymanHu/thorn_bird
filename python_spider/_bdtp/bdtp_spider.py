#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
百度图片爬取，保存到本地文件夹
https://image.baidu.com/search/acjson
'''

import sys, os;
import requests;
from _bdtp import bdtp_storage;

request_headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:80.0) Gecko/20100101 Firefox/80.0',
};

PAGE_COUNT = 3;
PAGE_SIZE = 30;
headers = {"User-Agent":"Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:88.0) Gecko/20100101 Firefox/88.0"};

def bdtp_data(keyword):
    urls = list("https://image.baidu.com/search/acjson?tn=resultjson_com&logid=11630114429471695285&"
                "ipn=rj&ct=201326592&is=&fp=result&queryWord=%s&cl=%d&lm=-1&ie=utf-8&oe=utf-8&"
                "adpicid=&st=&z=&ic=&hd=&latest=&copyright=&word=%s&s=&se=&tab=&width=&height=&"
                "face=&istype=&qc=&nc=1&fr=&expermode=&force=&pn=%d&rn=%d&gsm=3c&1621407427506=" % (keyword, page,
                keyword, page * PAGE_SIZE, PAGE_SIZE) for page in range(1, PAGE_COUNT + 1));

    images = [];
    for url in urls:
        r = requests.get(url, headers = headers);
        for image in r.json().get("data"):
            if image.get("middleURL"):
                images.append(image.get("middleURL"));

    print(images);
    return images;

if __name__ == "__main__":
    keyword = "美女";
    images = bdtp_data(keyword);
    bdtp_storage.bdtu_storage(keyword, images);

    # curPath = os.path.abspath(os.path.dirname(__file__));
    # rootPath = os.path.split(curPath)[0];
    # print(os.path);
    # print(curPath);
    # print(rootPath);

    # print(os.path.split("D:/projectCode/thorn_bird/python_spider/spider.py"));
    # print(os.path.split("D:/projectCode/thorn_bird/python_spider"));
    # print(curPath[:curPath.find("puthon_spider\\") + len("puthon_spider\\")]);
    # separator = "\\" if os.name == "nt" else "/";
    # projectName = "python_spider" + separator;
    # curPath = os.path.abspath(os.path.dirname(__file__));  # 获取当前文夹路径
    # rootPath = curPath[:curPath.find(projectName) + len(projectName)];  # 获取项目根目录
    # print(rootPath);
    # print(os.path.split("D:\\projectCode\\hqyj\\python_demo\\com\\thornBird\\base"));
    # curPath = os.path.abspath(os.path.dirname(__file__))
    # rootPath = os.path.split(curPath)[0]
    # sys.path.append(rootPath)