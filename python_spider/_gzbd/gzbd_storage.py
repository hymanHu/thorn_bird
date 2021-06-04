#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu"

'''
_gzbd 数据存储
'''

from utils import mysql_util, excel_util;
from datetime import datetime;

def storage_excel(gzbd_data):
    header = ["地区", "日期", "确诊数", "境外输入数", "治愈数", "死亡数", "隔离数", "观察数"]
    body = list()
    for item in gzbd_data:
        line = [];
        line.append(item["日期"]);
        line.append(item["地区"]);
        line.append(item.get("确诊数", None));
        line.append(item.get("境外输入数", None));
        line.append(item.get("治愈数", None));
        line.append(item.get("死亡数", None));
        line.append(item.get("隔离数", None));
        line.append(item.get("观察数", None));
        body.append(line);
    file_path = "/temp/gzbd_data.xlsx";
    excel_util.create_excel(header, body, file_path);

def storage_mysql(gzbd_data):
    connection, cursor = None, None;
    try:
        connection, cursor = mysql_util.get_connect_cursor();
        for item in gzbd_data:
            coronavirus_date = item["时间"];
            query_sql = "select * from spider_coronavirus where date = '%s' and diagnosis is null" % (coronavirus_date,)
            insert_sql = "insert into spider_coronavirus (date, region, diagnosis, overseas_import, cure, " \
                         "death, therapy, observation, create_date) values ('%s', '%s', %s, %s, %s, %s, %s, %s, '%s')" % \
                         (item["时间"], item["地区"], item.get("确诊数", None), item.get("境外输入数", None),
                          item.get("治愈数", None), item.get("死亡数", None), item.get("隔离数", None),
                          item.get("观察数", None), datetime.now().strftime("%Y-%m-%d %H:%M:%S"));
            insert_sql = insert_sql.replace("None", "Null");

            result = mysql_util.execute_query(cursor, query_sql);
            if len(result) == 0:
                mysql_util.execute_insert_update_delete(cursor, insert_sql);

        mysql_util.commit_(connection);
    except Exception as e:
        print(e);
        mysql_util.rollback_(connection);
    finally:
        mysql_util.close_connect_cursor(connection, cursor);

if __name__ == "__main__":
    pass;