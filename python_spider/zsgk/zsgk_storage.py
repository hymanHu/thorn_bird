#!/usr/bin/env python3
# -*- coding: utf-8 -*-
from utils import mysql_util

__author__ = "HymanHu"

'''
掌上高考，数据存储
'''

def university_storage(universities):
    conn, cur = mysql_util.get_connect_cursor()
    try:
        for university in universities:
            school_id = university.get("school_id")
            query_sql = "select * from university where school_id = %s"%(school_id,)
            insert_sql = "insert into university (school_no, school_id, school_type, school_name, type, " \
                         "type_name, level, level_name, nature, nature_name, belong, central, code_enroll, " \
                         "colleges_level, department, doublehigh, f211, f985, is_recruitment, is_top, rank, " \
                         "rank_type, dual_class, dual_class_name, address, province_id, province_name, " \
                         "single_province, city_id, city_name, county_id, county_name, view_total_number) values " \
                         "('%s', %s, %s, '%s', %s, '%s', %s, '%s', %s, '%s', '%s', %s, %s, '%s', %s, %s, %s, %s, " \
                         "%s, %s, %s, %s, %s, '%s', '%s', %s, '%s', '%s', %s, '%s', %s, '%s', %s)"\
                         %(university.get("id", None), university.get("school_id", None),
                           university.get("school_type", None), university.get("name", None),
                           university.get("type", None), university.get("type_name", None),
                           university.get("level", None), university.get("level_name", None),
                           university.get("nature", None), university.get("nature_name", None),
                           university.get("belong", None), university.get("central", None),
                           university.get("code_enroll", None), university.get("colleges_level", None),
                           university.get("department", None), university.get("doublehigh", None),
                           university.get("f211", None), university.get("f985", None),
                           university.get("is_recruitment", None), university.get("is_top", None),
                           university.get("rank", None), university.get("rank_type", None),
                           university.get("dual_class", None), university.get("dual_class_name", None),
                           university.get("address", None), university.get("province_id", None),
                           university.get("province_name", None), university.get("single_province", None),
                           university.get("city_id", None), university.get("city_name", None),
                           university.get("county_id", None), university.get("county_name", None),
                           university.get("view_total_number", None))

            country_temp = mysql_util.execute_query(cursor=cur, sql=query_sql)
            if len(country_temp) == 0:
                result = mysql_util.execute_insert_update_delete(cur, insert_sql)
                if result > 0:
                    print("%s%s"%("ok-", insert_sql))
    except Exception as e:
        print(e)
        mysql_util.rollback_(conn)

    mysql_util.commit_(conn)
    mysql_util.close_connect_cursor(conn, cur)