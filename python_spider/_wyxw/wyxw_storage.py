#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
网易国内新闻存储
'''

from utils import mysql_util;
from datetime import datetime;

def wyxw_storage(news_list):
    connection, cursor = None, None;
    try:
        connection, cursor = mysql_util.get_connect_cursor();
        for news in news_list:
            query_sql = "select * from spider_news where title = '%s'" % news.get("title");
            insert_sql = "insert into spider_news (title, digest, url, view_count, label, keywords, " \
                         "news_date, type, channel, source, image_url, detail, create_date) " \
                         "values ('%s', '%s', '%s', %s, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')" \
                         % (news.get("title"), news.get("digest"), news.get("url"), news.get("view_count"),
                            news.get("label"), news.get("keywords"), news.get("news_date"), news.get("type"),
                            news.get("channel"), news.get("source"), news.get("image_url"),
                            news.get("detail"), datetime.now().strftime("%Y-%m-%d %H:%M:%S"));
            news_temp = mysql_util.execute_query(cursor, query_sql);
            if len(news_temp) == 0:
                print(insert_sql);
                mysql_util.execute_insert_update_delete(cursor, insert_sql);
        mysql_util.commit_(connection);
    except Exception as e:
        print(e);
        mysql_util.rollback_(connection);
    finally:
        mysql_util.close_connect_cursor(connection, cursor);
