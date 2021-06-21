#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
mysql utils
'''

# 将项目根目录添加到 sys.path，解决 cmd 下执行该模块找不到包的问题
import sys, os;
current_path = os.path.abspath(os.path.dirname(__file__));
separator = "\\" if os.name == "nt" else "/";
project_name = "python_spider" + separator;
root_path = current_path[:current_path.find(project_name) + len(project_name)];  # 获取项目根目录
sys.path.append(root_path);

import pymysql;

def get_connect_cursor():
    connect = pymysql.connect(host='localhost', user='root', passwd='root', db='test', charset='utf8');
    return connect, connect.cursor();

def execute_insert_update_delete(cursor, sql):
    print(sql);
    result = cursor.execute(sql);
    return result;

def execute_query(cursor, sql):
    cursor.execute(sql);
    return cursor.fetchall();

def commit_(connect):
    connect.commit();

def rollback_(connect):
    connect.rollback()

def close_connect_cursor(connect, cursor):
    if connect:
        connect.close();
    if cursor:
        cursor.close();

def execute_(sql):
    connect, cursor = None, None;
    result = None;
    try:
        connect, cursor = get_connect_cursor();
        if sql.startswith("select"):
            result = execute_query(cursor, sql);
        else:
            result = execute_insert_update_delete(cursor, sql);
            commit_(connect);
    except Exception as e:
        print(e);
        connect.rollback();
    finally:
        close_connect_cursor(connect, cursor);

    return result;

def batch_excute_(sqls):
    connect, cursor = None, None;
    try:
        connect, cursor = get_connect_cursor();
        for sql in sqls:
            cursor.execute(sql);
        commit_(connect);
    except Exception as e:
        print(e)
        connect.rollback();
    finally:
        close_connect_cursor(connect, cursor);

if __name__ == "__main__":
    pass;