#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
爬取大众点评用户评论数据
http://www.dianping.com
'''

# 将项目根目录添加到 sys.path，解决 cmd 下执行该模块找不到包的问题
import sys, os;
current_path = os.path.abspath(os.path.dirname(__file__));
separator = "\\" if os.name == "nt" else "/";
project_name = "python_spider" + separator;
root_path = current_path[:current_path.find(project_name) + len(project_name)];  # 获取项目根目录
sys.path.append(root_path);

import time;
import re;
import requests;
from bs4 import BeautifulSoup;
from utils import dzdp_svg_util;

headers = {"User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:89.0) Gecko/20100101 Firefox/89.0",
           'Cookie': "_lxsdk_cuid=17a137cb6331a-0db516b1fcf3f9-1a397840-100200-17a137cb634c8; _lxsdk=17a137cb6331a-0db516b1fcf3f9-1a397840-100200-17a137cb634c8; _hc.v=d84b7dd1-bb7f-8419-821d-4b52bca9fde0.1623824578; Hm_lvt_602b80cf8079ae6591966cc70a3940e7=1623824886,1623920514,1624010046,1624021003; dplet=405d6db9e3fc442b8bd12132ab13b2b7; dper=f029adad1290a1a85527aaed96c5624979fd591c0b9fb9e0c47d45a931028faa20e40ff7566a27e7b37cb6cb6e96894251038f7b47ec20b5d9d9a38efaf39f3358a0999a3230c4d562c940b499ac478932c501e04d830220d674ac8edf3ec257; ua=dpuser_69796934290; ctu=fdd460a043c8b52b1251553197af12ae44e1dd6b5050ac0215e157dc1577a862; fspop=test; cy=8; cye=chengdu; s_ViewType=10; ll=7fd06e815b796be3df069dec7836c3df; _lx_utm=utm_source%3DBaidu%26utm_medium%3Dorganic; _lxsdk_s=17a1f31eac5-3-b1c-96%7C%7C171; Hm_lpvt_602b80cf8079ae6591966cc70a3940e7=1624021265"};

# 下载 css、svg、woff 文件
def download_file(url):
    reviews_page_count = 1;

    r = requests.get(url=url, headers=headers);
    if r.status_code == 200:
        # 获取 svg 样式文件（包含 svg 或者 woff），并将之保存到本地
        css_response = None;
        css_url = re.findall('<link rel="stylesheet" type="text/css" href="(//s3plus.meituan.*?)">', r.text);
        if len(css_url) > 0:
            css_url = "http:" + css_url[0];
            print("css: %s", css_url);
            css_response = requests.get(css_url);
            with open(file="css_file.css", mode="w", encoding="utf-8") as f:
                f.write(css_response.text);

        # 获取 css 中的 woff 文件，并将之保存在本地
        if css_response:
            woff_url = re.findall(',url\("(//s3plus.meituan.*?)"\)', css_response.text);
            if len(woff_url) > 0:
                woff_url = list(set(woff_url));
                for item in woff_url:
                    woff = "http:" + item;
                    file_name = "woff_file_%s.woff" % woff_url.index(item);
                    print("woff: %s" % woff);
                    woff_response = requests.get(woff);
                    with open(file=file_name, mode="w", encoding="utf-8") as f:
                        f.write(woff_response.text);

        # 获取 css 中的 svg 文件，并将之保存到本地
        if css_response:
            clazz_prefix = ["ut", "cr", "lf", "lpt"];
            for item in clazz_prefix:
                svg_url = re.findall('svgmtsi\[class\^=\"' + item + '\"\].*?background-image: url\((.*?)\);', css_response.text);
                if len(svg_url) > 0:
                    break;

            if len(svg_url) > 0:
                svg_url = "http:" + svg_url[0];
                print(svg_url);
                svg_response = requests.get(svg_url);
                with open(file='svg_file.svg', mode='w', encoding='utf-8') as f:
                    f.write(svg_response.text);

        # 获取每个商家评论总页数
        bs = BeautifulSoup(r.text, "html.parser");
        a_list = bs.find_all(name="a", attrs={"class": "PageLink"});
        if len(a_list) > 0:
            reviews_page_count = int(a_list[-1].get("title"));
            print(reviews_page_count);
    else:
        print("连接服务器失败.");

    return reviews_page_count;

'''
获取商家所有评论数据
http://www.dianping.com/shop/l5r6wdVV3NuyOsGu
http://www.dianping.com/shop/l5r6wdVV3NuyOsGu/review_all
http://www.dianping.com/shop/l5r6wdVV3NuyOsGu/review_all/p2
'''
def get_all_reviews(url, reviews_page_count):
    l = [];
    url_list = list(url + "/p%d" % page for page in range(2, reviews_page_count + 1));
    url_list.insert(0, url);
    for item in url_list:
        l += get_reviews(item);
        time.sleep(20);
    return l;

# 获取商家评论分页数据
def get_reviews(url):
    print("Visit %s" % url);
    svg_class_map = dzdp_svg_util.init_svg_class_map();
    svg_list = dzdp_svg_util.init_svg_list()
    l = [];
    r = requests.get(url=url, headers=headers);
    if r.status_code == 200:
        # r.encoding = r.apparent_encoding;

        bs = BeautifulSoup(r.text, "html.parser");
        div_list = bs.find_all(name="div", attrs={"class": "main-review"});
        for div in div_list:
            name = div.findChildren(name="a", attrs={"class": "name"})[0].get_text().strip();
            div_list = div.findChildren(name="div", attrs={"class": "review-words Hide"});
            if len(div_list) > 0:
                content = str(div_list[0]).strip().replace("\n", "");
                for svg in re.findall('(\<svgmtsi class=\".*?\"\>\<\/svgmtsi\>)', content):
                    clazz = re.findall('\<svgmtsi class=\"(.*?)\"\>\<\/svgmtsi\>', svg)[0];
                    content = content.replace(svg, dzdp_svg_util.decode_svg(clazz, svg_class_map, svg_list));
                content = "".join(re.findall('Hide">(.*?)<div', content)).replace(" ", "");

                # 将评论写入文本
                with open(file="content.txt", mode='a', encoding="utf-8") as f:
                    f.write(content);
                    f.write("\n");

                # 此处不能用 dict 临时变量，同一个变量会覆盖掉之前的内容
                l.append({"name": name, "content": content});
    else:
        print("链接服务器失败");

    print(l);
    return l;

if __name__ == "__main__":
    # url = "http://www.dianping.com/shop/l5r6wdVV3NuyOsGu";
    url = "http://www.dianping.com/shop/l4twNneJonrrRkFe/review_all";
    reviews_page_count = download_file(url);
    # get_reviews(url);
    get_all_reviews(url, reviews_page_count);
