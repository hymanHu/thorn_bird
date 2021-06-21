#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu"

'''
掌上高考，数据存储
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

def university_storage(universities):
    connection, cursor = None, None;
    try:
        connection, cursor = mysql_util.get_connect_cursor();
        for university in universities:
            id = university.get("id");
            query_sql = "select * from spider_university where id = '%s'"%(id,);
            insert_sql = "insert into spider_university (code, name, type, level, nature, belong, central, department, " \
                         "doublehigh, f211, f985, is_recruitment, dual_class, address, province_name, single_province, " \
                         "city_name, county_name, view_total_number, create_date) values " \
                         "('%s', '%s', '%s', '%s', '%s', '%s', %s, %s, %s, %s, %s, %s, '%s', " \
                         "'%s', '%s', '%s', '%s', '%s', %s, '%s')" \
                         % (university.get("id", None), university.get("name", None),
                            university.get("type_name", None), university.get("level_name", None),
                            university.get("nature_name", None), university.get("belong", None),
                            university.get("central", None), university.get("department", None),
                            university.get("doublehigh", None), university.get("f211", None),
                            university.get("f985", None), university.get("is_recruitment", None),
                            university.get("dual_class_name", None), university.get("address", None),
                            university.get("province_name", None), university.get("single_province", None),
                            university.get("city_name", None), university.get("county_name", None),
                            university.get("view_total_number", None), datetime.now().strftime("%Y-%m-%d %H:%M:%S"));

            country_temp = mysql_util.execute_query(cursor=cursor, sql=query_sql);
            if len(country_temp) == 0:
                mysql_util.execute_insert_update_delete(cursor, insert_sql);

        mysql_util.commit_(connection);
    except Exception as e:
        print(e);
        mysql_util.rollback_(connection);
    finally:
        mysql_util.close_connect_cursor(connection, cursor);