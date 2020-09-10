#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
mysql utils
'''

import pymysql;


def get_connect_cursor():
    conn = pymysql.connect(host='localhost', user='root', passwd='root', db='test_1', charset='utf8');
    return conn, conn.cursor();

def execute_insert_update_delete(cursor, sql):
    result = cursor.execute(sql);
    return result;

def execute_query(cursor, sql):
    cursor.execute(sql);
    return cursor.fetchall();

def commit_(conn):
    conn.commit();

def close_connect_cursor(conn, cur):
    cur.close();
    conn.close();

def execute_(sql):
    connect, cursor = get_connect_cursor();
    result = None;
    if sql.startswith("select"):
        result = execute_query(cursor, sql);
        close_connect_cursor(connect, cursor);
    else:
        result = execute_insert_update_delete(cursor, sql);
        commit_(connect);
        close_connect_cursor(connect, cursor);
    return result;

if __name__ == "__main__":
    pass;