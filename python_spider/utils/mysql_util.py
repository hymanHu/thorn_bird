#!/usr/bin/env python3
# -*- coding: utf-8 -*-
import pymysql

'''
mysql utils
'''

__author__ = "HymanHu";

def get_connect_cursor():
    connect = pymysql.connect(host='localhost', user='root', passwd='root', db='maindb', charset='utf8')
    return connect, connect.cursor();

def execute_insert_update_delete(cursor, sql):
    result = cursor.execute(sql)
    return result

def execute_query(cursor, sql):
    cursor.execute(sql)
    return cursor.fetchall()

def commit_(connect):
    connect.commit()

def rollback_(connect):
    connect.rollback()

def close_connect_cursor(connect, cursor):
    if connect:
        connect.close()
    if cursor:
        cursor.close()

def execute_(sql):
    connect, cursor = None, None
    result = None
    try:
        connect, cursor = get_connect_cursor()
        if sql.startswith("select"):
            result = execute_query(cursor, sql)
        else:
            result = execute_insert_update_delete(cursor, sql)
            commit_(connect)
    except Exception as e:
        print(e)
    finally:
        close_connect_cursor(connect, cursor)

    return result

def batch_excute_(sqls):
    connect, cursor = None, None
    try:
        connect, cursor = get_connect_cursor()
        for sql in sqls:
            cursor.execute(sql)
        commit_(connect)
    except Exception as e:
        print(e)
    finally:
        close_connect_cursor(connect, cursor)

if __name__ == "__main__":
    pass