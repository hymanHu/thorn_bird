#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
掌上高考数据爬取
https://gkcx.eol.cn/school/search
'''

import requests
from _zsgk import zsgk_storage

request_headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:80.0) Gecko/20100101 Firefox/80.0',
}
base_url_format = 'https://api.eol.cn/gkcx/api/?access_token=&admissions=&central=&department=&dual_class=&' \
           'f211=&f985=&is_dual_class=&keyword=&page={0}&province_id=&request_type=&school_type=&signsafe=&' \
           'size=20&sort=view_total&top_school_id=&type=&uri=apidata/api/gk/school/lists'
url_count = 148
def universities_data():
    universities = [];
    urls = [base_url_format.format(i) for i in range(1, url_count + 1)]
    for url in urls:
        print("Visit url: %s"%url)
        try:
            r = requests.get(url, headers=request_headers)
            r.encoding = r.apparent_encoding
            if r.status_code == 200:
                universities += r.json().get("data").get("item")
            else:
                print("Returen error status code(%d)" % (r.status_code,))
        except Exception as e:
            print(e)

    return universities

if __name__ == "__main__":
    universities = universities_data()
    zsgk_storage.university_storage(universities)