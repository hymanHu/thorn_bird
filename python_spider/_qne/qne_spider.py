#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
去哪儿评论爬虫
https://dujia.qunar.com/pqd/list_九寨沟_成都?tf=pc_big_search
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
import emoji;
from datetime import datetime;
from _qne import qne_storage;

page_size = 60;
comment_page_size = 10;
page_count = 1;
headers = {
    "Cookie":"QN1=00006600306c34486f006ca9; QN300=s%3Dbaidu; QN99=6874; QunarGlobal=10.86.213.148_1147fecb_17a365d9c60_206d|1624410081947; QN205=s%3Dbaidu; QN277=s%3Dbaidu; QN267=09077237722cd1ab1a; csrfToken=wQapoBrAXj4YfZDyzf6WmUFD6X7DksdM; QN601=3b71720de3dfef5673a10e0121804a70; qunar-assist={%22show%22:false%2C%22audio%22:false%2C%22speed%22:%22middle%22%2C%22zomm%22:1%2C%22cursor%22:false%2C%22pointer%22:false%2C%22bigtext%22:false%2C%22overead%22:false}; qunar-assist-ignore=[%22https://www.qunar.com/%22]; QN163=0; QN48=3ebc2ab1-dc83-4937-b2e4-01ab26006ad8; QN667=A; fid=9bf5257c-3fc8-4408-88d3-7da7cafb0876; QN271=bd95f8bf-6003-4164-bbc7-95fde90a9f47; JSESSIONID=ED92CA4EDE83A0E6798C2F220EBE2B59; QN269=A201DC53D3BE11EB8988FA163EA45511; _i=VInJOmMoyLwqA3M1mf8Y98WNXqwq; _vi=WF-h4_PfZ60FJWpy7N_UMHdEbL3VnnPNtKE_X7i1oL3ZZAxUD2y68xysuUojeyAHMd8mOMwFhn4n7c-uPd4YhqKFmx-bvjv4thi02ezjmj8l2wN9_y5vU1WFq7tTpgi3EjVioSBi8us8H-wiLRDUk_a7lXFoKos4FY5-b4KM0azR; DJ001=WyLmiJDpg70iXQ%3D%3D; QN243=57; QN25=59bf29f4-e30c-4e15-8792-c204e8f79b34-9f992f90",
    "User-Agent":"Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:89.0) Gecko/20100101 Firefox/89.0",
};

# 解析产品列表页面
def parse_product_list_page(keyword, departure):
    print("==== 获取商家旅游产品列表 ====")
    tourism_products = [];
    url_list = list(
        "https://dujia.qunar.com/golfz/routeList/adaptors/pcTop?isTouch=0&t=all&o=pop-desc&lm=%d,%d&fhLimit=%d,%d&q=%s&d=%s&s=all&qs_ts=%d&tf=pc_big_search&tm=djnull&sourcepage=list&userResident=%s&random=564336&aroundWeight=1&qssrc=eyJ0cyI6IjE2MjQ0MTIwNjA0ODgiLCJzcmMiOiJhbGwuZW52YSIsImFjdCI6InNlYXJjaCIsInJhbmRvbSI6IjU2NDMzNiJ9&m=l,bookingInfo,browsingInfo,lm&displayStatus=pc&ddf=true&userId=00006600306c34486f006ca9&hlFields=title&gpscity=%s&lines6To10=0" % (
        page * page_size, page_size, page * page_size, page_size, keyword, departure,
        int(datetime.now().timestamp() * 1000), departure, departure) for page in range(0, page_count));
    for url in url_list:
        r = requests.get(url=url, headers=headers);
        if r.status_code == 200:
            result = r.json();
            for item in result.get("data").get("list").get("results"):
                tourism_product = {};
                tourism_product["id"] = item.get("id");
                tourism_product["url"] = item.get("url");
                tourism_product["title"] = item.get("title");
                tourism_product["departure"] = item.get("dep");
                tourism_product["arrive"] = item.get("arrive");
                tourism_product["star"] = item.get("details").get("star");
                tourism_product["hotel"] = item.get("details").get("hotel");
                tourism_product["hotelNight"] = item.get("details").get("hotelNight");
                tourism_product["hotelPos"] = item.get("hotelPos");
                tourism_product["traffic"] = item.get("details").get("traffic");
                tourism_product["tripTime"] = item.get("details").get("tripTime");
                tourism_product["citys"] = item.get("citys");
                tourism_product["sights"] = ",".join(item.get("sights"));
                tourism_product["productFeatures"] = ",".join(item.get("productFeatures")) if len(item.get("productFeatures")) > 0 else "";
                tourism_product["multiImgList"] = item.get("multiImgList");
                tourism_products.append(tourism_product);
        else:
            print("响应错误");
        time.sleep(10);

    # 循环产品列表，收集每个产品的评论信息
    all_comments = [];
    for product in tourism_products:
        try:
            all_comments += parse_single_product_page("https:" + product.get("url"));
        except Exception as e:
            print(e);

    return all_comments;

# 解析单张产品页面
def parse_single_product_page(url):
    comments = [];

    print("访问商家: %s" % url);
    r = requests.get(url=url, headers=headers);

    matchs = re.findall("location.href = '(.*?)' \+ window.location.hash;", r.text);
    real_url = "https:" + matchs[0] if len(matchs) > 0 else None;
    if real_url:
        # 从接口返回的链接会返回真实地址，如果直接访问真实地址，则无需重置 response
        r = requests.get(url=real_url, headers=headers);

    # 从真实页面中找出该产品各种套餐 id
    sub_ids = ",".join(set(re.findall("data-subId=\"(\d+)\"", r.text)));
    print("该产品子套餐 ids：%s" % sub_ids);
    # 根据套餐 ids 找出评论总数，并计算出评论分页总数
    r = requests.get("https://utjb3.package.qunar.com/user/comment/product/productCommentStatus.json?productIds=%s" % sub_ids, headers=headers);
    comments_count = r.json().get("data").get("totalRatings");
    comment_page_count = (comments_count // comment_page_size) if (comments_count % comment_page_size == 0) else ((comments_count // comment_page_size) + 1);
    print("该产品评论总页数：%s" % comment_page_count);

    # 每个产品评论取前 15 页有效数据
    comment_page_count = 15 if comment_page_count > 15 else comment_page_count;
    # 构建该产品评论分页 url 列表
    comments_url_list = list("https://utjb3.package.qunar.com/user/comment/product/queryComments.json?type=all&pageNo=%d&pageSize=%d&productIds=%s&rateStatus=ALL" % (page, comment_page_size, sub_ids) for page in range(1, comment_page_count + 1));
    for comment_url in comments_url_list:
        print("该产品评论第 %d 页：%s" % (comments_url_list.index(comment_url), comment_url));
        r = requests.get(url=comment_url, headers=headers);
        for item in r.json().get("data").get("mainCommentList"):
            comment = {};
            comment["productId"] = item.get("productId");
            content = item.get("content");
            if not content:
                content = item.get("commentContextVos")[0].get("content") if len(item.get("commentContextVos")) > 0 else "";
            # 去掉 content 中 emoji 字符
            # 方式一，将 emoji 字符转化为 :thumbs_up: 等标识
            # emoji.demojize(content);
            # 方式二，正则表达式
            emoji_pattern = re.compile(u'[\U00010000-\U0010ffff]', flags=re.UNICODE);
            comment["content"] = emoji_pattern.sub(r'', content);
            comment["tripStartDate"] = item.get("tripStartDate");
            comment["userName"] = item.get("shownUserName");

            # 保存评论数据
            qne_storage.save_comment_in_db(comment);

            comments.append(comment);
        time.sleep(20);

    print("该产品评论列表 %s" % comments);
    return comments;

if __name__ == "__main__":
    # parse_product_list_page("九寨沟", "成都");
    # url = "https://dujia.qunar.com/pi/detail_64496740?vendor=%E5%9B%BD%E6%97%85%E5%9B%9B%E5%B7%9D&function=%E8%B7%9F%E5%9B%A2%E6%B8%B8&departure=%E6%88%90%E9%83%BD&arrive=%E4%B9%9D%E5%AF%A8%E6%B2%9F&ttsRouteType=%E5%91%A8%E8%BE%B9%E6%B8%B8&filterDate=2021-06-24,2021-06-24";
    # url = "https://schp3.package.qunar.com/user/detail.jsp?abt=a&id=1276254803&filterDate=2021-06-25%2C2021-06-25&dep=5oiQ6YO9#tf=%E6%88%90%E9%83%BD_%E4%B9%9D%E5%AF%A8%E6%B2%9F_149&isAds=1";
    # url = "https://hofd3.package.qunar.com/user/detail.jsp?abt=a&id=1210142369&filterDate=2021-06-25%2C2021-06-25&dep=5oiQ6YO9#tf=%E6%88%90%E9%83%BD_%E4%B9%9D%E5%AF%A8%E6%B2%9F_149&isAds=1";
    # url = "https://hqgb8.package.qunar.com/user/detail.jsp?abt=a&id=3883481730&filterDate=2021-06-25%2C2021-06-25&dep=5oiQ6YO9#tf=%E6%88%90%E9%83%BD_%E4%B9%9D%E5%AF%A8%E6%B2%9F_149&isAds=1";
    # url = "https://hygl9.package.qunar.com/user/detail.jsp?id=2837839024&osrc=tts_tuan&rttp=%E5%91%A8%E8%BE%B9%E6%B8%B8&dep=5oiQ6YO9&arr=5Lmd5a%2Bo5rKf&ftdt=2021-06-25%2C2021-06-25&qssrc=eyJ0cyI6IjE2MjQ0OTY0ODg2NDYiLCJzcmMiOiJhbGwuZW52YSIsImFjdCI6InNlYXJjaCIsInJhbmRvbSI6IjEwODkxMiJ9&ts=1624496491776_365#vid=qb2c_hygl9&func=6Lef5Zui5ri4&djtf=dj_list_A-B-C_9-tts_%E7%9C%9F%E7%BA%AF%E7%8E%A9%E6%97%A0%E8%B4%AD%E7%89%A99_origin&tm=_search_origin&pid=2837839024&rid=58281780&vd=5Y2O5ri45Zu95peF";
    url = "https://scgl2.package.qunar.com/user/detail.jsp?id=1072257460&osrc=tts_tuan&rttp=%E5%91%A8%E8%BE%B9%E6%B8%B8&dep=5oiQ6YO9&arr=5Lmd5a%2Bo5rKf&ftdt=2021-06-29%2C2021-06-29&qssrc=eyJ0cyI6IjE2MjQ0OTY0ODg2NDYiLCJzcmMiOiJhbGwuZW52YSIsImFjdCI6InNlYXJjaCIsInJhbmRvbSI6IjEwODkxMiJ9&ts=1624496491776_365#vid=qb2c_scgl2&func=6Lef5Zui5ri4&djtf=dj_list_A-B-C_9-tts_%E5%8F%AF%E5%8D%87%E7%BA%A7%E4%BF%9D%E5%A7%86%E8%BD%A610_origin%2Cdj_list_A-B-C_9-tts_%E7%9C%9F%E7%BA%AF%E7%8E%A90%E8%B4%AD%E7%89%A910_origin%2Cdj_list_A-B-C_9-tts_%E4%B8%93%E5%B1%9E%E7%AE%A1%E5%AE%B610_origin&tm=_search_origin&pid=1072257460&rid=28136562&vd=5Zub5bed5Zu95peF";
    parse_single_product_page(url);
