#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
去哪儿评论存储
'''

# 将项目根目录添加到 sys.path，解决 cmd 下执行该模块找不到包的问题
import sys, os;
current_path = os.path.abspath(os.path.dirname(__file__));
separator = "\\" if os.name == "nt" else "/";
project_name = "python_spider" + separator;
root_path = current_path[:current_path.find(project_name) + len(project_name)];  # 获取项目根目录
sys.path.append(root_path);

from utils import mysql_util;
from datetime import datetime;
from pandas import DataFrame;

# 评论排除列表
comments_exclude = ["用户未及时评价, 该评价为系统默认好评!", "用户未填写文字评价。"];

# 保存单条评论信息到数据库
def save_comment_in_db(comment):
    content = comment.get("content");
    if content and not comments_exclude.__contains__(content):
        query_sql = "select * from spider_comment where content = '%s' and user_name = '%s'" % (content, comment.get("userName"));
        insert_sql = "insert into spider_comment (create_date, product_id, content, trip_start_date, user_name) " \
                     "values ('%s', '%s', '%s', '%s', '%s')" % (datetime.now().strftime("%Y-%m-%d %H:%M:%S"), comment.get("productId"),
                        content, comment.get("tripStartDate"), comment.get("userName"));
        result = mysql_util.execute_(query_sql);
        if len(result) == 0:
            mysql_util.execute_(insert_sql);

# 将数据库数据转储为 csv 文件
def save_comment_in_file(target_csv_file, target_txt_file):
    print("==== 查询数据 ====");
    query_sql = "select * from spider_comment order by trip_start_date";
    data = mysql_util.execute_(query_sql);

    print("==== 将数据写入 csv 文件 ====");
    column_list = ["id", "create_date", "product_id", "content", "trip_start_date", "user_name"];
    dataFrame = DataFrame(data=data, columns=column_list);
    dataFrame.to_csv(path_or_buf=target_csv_file, encoding="utf-8-sig", index=False);

    print("==== 将评论信息写入 txt 文件 ====");
    with open(file=target_txt_file, mode="a", encoding="utf-8") as f:
        for item in data:
            f.write(item[3] + "\n");

if __name__ == "__main__":
    # comment = {'productId': '4219314304', 'content': '非常满意的一次旅行，景色确实美   九寨沟值得一去，没有强制消费 ', 'tripStartDate': '2019-12-19', 'userName': 'l***g'};
    # save_comment_in_db(comment);
    save_comment_in_file("/temp/target.csv", "/temp/target.txt");