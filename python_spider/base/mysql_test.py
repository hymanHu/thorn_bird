#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
mysql test
'''

import mysql_util;

def inset_resource():
    conn, cur = mysql_util.get_connect_cursor();
    sql = "insert into resource (resource_uri, resource_name, permission) values ('aa', 'bb', 'cc')";
    mysql_util.execute_insert_update_delete(cur, sql);
    mysql_util.commit_(conn);
    mysql_util.close_connect_cursor(conn, cur);

def query_resource():
    conn, cur = mysql_util.get_connect_cursor();
    sql = "select * from resource";
    result = mysql_util.execute_query(cur, sql);
    print(result);
    mysql_util.close_connect_cursor(conn, cur);

if __name__ == "__main__":
    # inset_resource();
    query_resource();
