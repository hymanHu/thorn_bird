#!/usr/bin/env python3
# -*- coding: utf-8 -*-
import requests
from _bdtp import bdtp_storage

'''
百度图片爬取，保存到本地文件夹
https://image.baidu.com/search/acjson
'''

__author__ = "HymanHu";

request_headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:80.0) Gecko/20100101 Firefox/80.0',
}
base_url_format = 'https://image.baidu.com/search/acjson?tn=resultjson_com&ipn=rj&ct=201326592&is=' \
            '&fp=result&queryWord={0}&cl=2&lm=-1&ie=utf-8&oe=utf-8&adpicid=&st=-1&z=&ic=0&hd=' \
            '&latest=&copyright=&word={1}&s=&se=&tab=&width=&height=&face=0&istype=2&qc=&nc=1' \
            '&fr=&expermode=&force=&pn={2}&rn=30&gsm=5a'
url_count = 3
def bdtp_data(keyword):
    images = []
    urls = [base_url_format.format(keyword, keyword, i * 30) for i in range(1, url_count + 1)]
    for url in urls:
        print("Visit url: %s"%url)
        try:
            r = requests.get(url, headers=request_headers)
            if r.status_code == 200:
                data = r.json().get("data")
                for item in data:
                    images.append(item.get("middleURL"))
            else:
                print("Returen error status code(%d)" % (r.status_code,))
        except Exception as e:
            print(e)

    return images

if __name__ == "__main__":
    keyword = "风铃"
    images = bdtp_data(keyword)
    bdtp_storage.bdtu_storage(keyword, images)