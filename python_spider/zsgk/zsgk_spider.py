#!/usr/bin/env python3
# -*- coding: utf-8 -*-
import requests
from zsgk import zsgk_storage

__author__ = "HymanHu";

'''
掌上高考数据爬取
https://gkcx.eol.cn/school/search
'''

request_headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:80.0) Gecko/20100101 Firefox/80.0',
}

def universities_data():
    universities = [];
    urls = ['https://api.eol.cn/gkcx/api/?access_token=&admissions=&central=&department=&dual_class='
            '&f211=&f985=&is_dual_class=&keyword=&page={0}&province_id=&request_type=&school_type='
            '&signsafe=&size=20&sort=view_total&top_school_id=&type=&uri=apidata/api/gk/school/lists'
                .format(i) for i in range(1, 149)]
    for url in urls:
        print(url)
        try:
            r = requests.get(url, headers=request_headers)
            r.encoding = r.apparent_encoding
            if r.status_code == 200:
                universities += r.json().get("data").get("item")
            else:
                print("Returen error status code(%d)" % (r.status_code,))
        except Exception as e:
            print(e)
            print("Connection refused by the server..")

    zsgk_storage.university_storage(universities)

if __name__ == "__main__":
    universities_data()