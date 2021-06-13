#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
爬取大众点评用户评论数据
http://www.dianping.com
'''
import re;
import requests;
from bs4 import BeautifulSoup;
from utils import dzdp_svg_util;

headers = {"User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:89.0) Gecko/20100101 Firefox/89.0",
           'Cookie': "fspop=test; cy=8; cye=chengdu; _lxsdk_cuid=179ec0476dec8-00501394ccf7af8-4c3f2d73-fa000-179ec0476dec8; _lxsdk=179ec0476dec8-00501394ccf7af8-4c3f2d73-fa000-179ec0476dec8; _hc.v=36a3593c-0b53-00ea-d85e-c967ffe1b400.1623162386; Hm_lvt_602b80cf8079ae6591966cc70a3940e7=1623162387,1623162769,1623479111; cityInfo=%7B%22cityId%22%3A8%2C%22cityName%22%3A%22%E6%88%90%E9%83%BD%22%2C%22provinceId%22%3A0%2C%22parentCityId%22%3A0%2C%22cityOrderId%22%3A0%2C%22isActiveCity%22%3Afalse%2C%22cityEnName%22%3A%22chengdu%22%2C%22cityPyName%22%3Anull%2C%22cityAreaCode%22%3Anull%2C%22cityAbbrCode%22%3Anull%2C%22isOverseasCity%22%3Afalse%2C%22isScenery%22%3Afalse%2C%22TuanGouFlag%22%3A0%2C%22cityLevel%22%3A0%2C%22appHotLevel%22%3A0%2C%22gLat%22%3A0%2C%22gLng%22%3A0%2C%22directURL%22%3Anull%2C%22standardEnName%22%3Anull%7D; s_ViewType=10; _lx_utm=utm_source%3DBaidu%26utm_medium%3Dorganic; _lxsdk_s=179fee547c4-5af-8eb-f90%7C%7C392; Hm_lpvt_602b80cf8079ae6591966cc70a3940e7=1623480060; _dp.ac.v=7559e8d9-0c01-443e-b28b-ba794866df66; dplet=6ee076214656055856f7b98853667f2f; dper=2fce3b21058cfe52cd18573ec91b6d2b5a30567996969c0f831b76250e4b478708a162d54a17e28929c9f53069b1e4315041a3e6f2ed36c07fa60aa009fde9dc20b57e3b842583980fec01d7d9ca8aee803e25bf5d82cb1e54547d20a5061959; ll=7fd06e815b796be3df069dec7836c3df; ua=dpuser_69796934290; ctu=fdd460a043c8b52b1251553197af12aeb57ad5fe3c74f58b05053a9f668130e2"};

'''
获取商家评论所有数据
http://www.dianping.com/shop/l5r6wdVV3NuyOsGu
http://www.dianping.com/shop/l5r6wdVV3NuyOsGu/review_all
http://www.dianping.com/shop/l5r6wdVV3NuyOsGu/review_all/p2
'''
def get_all_reviews(url):
    l = [];
    reviews_page_count = 1;
    r = requests.get(url=url, headers=headers);
    print(r.text)
    if r.status_code == 200:
        # r.encoding = r.apparent_encoding;
        # print(r.text);

        # 获取 svg 样式文件，并将之保存到本地
        css_url = re.findall('<link rel="stylesheet" type="text/css" href="(//s3plus.meituan.*?)">', r.text);
        css_url = "http:" + css_url[0];
        print(css_url);
        css_response = requests.get(css_url);
        with open(file="css_file.css", mode="w", encoding="utf-8") as f:
            f.write(css_response.text);

        # 获取 css 中的 svg 文件，并将之保存到本地
        svg_url = re.findall("svgmtsi\[class\^=\"qx\"\].*?background-image: url\((.*?)\);", css_response.text);
        svg_url = "http:" + svg_url[0];
        print(svg_url);
        svg_response = requests.get(svg_url);
        with open(file="svg_file.svg", mode="w", encoding="utf-8") as f:
            f.write(svg_response.text);

        # 获取每个商家评论总页数
        bs = BeautifulSoup(r.text, "html.parser");
        reviews_page_count = int(bs.find_all(name="a", attrs={"class": "PageLink"})[-1].get("title"));
        print(reviews_page_count);
    else:
        print("连接服务器失败.");

    # 爬取商家所有评论内容
    url_list = list("http://www.dianping.com/shop/l5r6wdVV3NuyOsGu/review_all/p%d" % page for page in range(2, reviews_page_count + 1));
    url_list.insert(0, "http://www.dianping.com/shop/l5r6wdVV3NuyOsGu/review_all");
    print(url_list);
    for url in url_list:
        l += get_reviews(url);
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
        div_list = bs.find_all(name="div", attrs={"class":"main-review"});
        for div in div_list:
            name = div.findChildren(name="a", attrs={"class":"name"})[0].get_text().strip();
            content = str(div.findChildren(name="div", attrs={"class":"review-words Hide"})[0]).strip().replace("\n", "");
            for svg in re.findall('(\<svgmtsi class=\".*?\"\>\<\/svgmtsi\>)', content):
                clazz = re.findall('\<svgmtsi class=\"(.*?)\"\>\<\/svgmtsi\>', svg)[0];
                content = content.replace(svg, dzdp_svg_util.decode_svg(clazz, svg_class_map, svg_list));
            content = "".join(re.findall('Hide">(.*?)<div', content));
            # 此处不能用 dict 临时变量，同一个变量会覆盖掉之前的内容
            l.append({"name": name, "content":content});
    else:
        print("链接服务器失败");

    print(l);
    return l;

if __name__ == "__main__":
    url = "http://www.dianping.com/shop/l5r6wdVV3NuyOsGu/review_all";
    get_reviews(url);
    # get_all_reviews(url);
