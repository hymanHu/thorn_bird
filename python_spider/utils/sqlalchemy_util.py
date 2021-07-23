#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
sqlalchemy util
'''

# 将项目根目录添加到 sys.path，解决 cmd 下执行该模块找不到包的问题
import sys, os;
current_path = os.path.abspath(os.path.dirname(__file__));
separator = "\\" if os.name == "nt" else "/";
project_name = "python_spider" + separator;
root_path = current_path[:current_path.find(project_name) + len(project_name)];  # 获取项目根目录
sys.path.append(root_path);

from sqlalchemy import Column, String, Integer, BigInteger, Float, DateTime, ForeignKey, create_engine, and_, or_;
from sqlalchemy.orm import sessionmaker, relationship;
from sqlalchemy.ext.declarative import declarative_base;

# 创建对象基类
Base = declarative_base();

# 初始化数据库引擎
def init_db_engine():
    engine = None;
    try:
        engine = create_engine("mysql+mysqlconnector://root:root@localhost:3306/test");
    except Exception as e:
        print("数据库连接失败，异常：%s" % e);
    return engine;

# 创建数据库表
def init_db():
    engine = init_db_engine();
    if engine:
        Base.metadata.create_all(engine, checkfirst=True);

# 初始化 DB Session
def init_db_session():
    engine = init_db_engine();
    if engine:
        session = sessionmaker(bind=engine);
        return session();
    else:
        return None;

# 新增
def insert_(entity, key):
    session = init_db_session();
    if session:
        # select * from coronavirus where date == ?
        '''
        根据实体 bean 的某个字段作为唯一标识，查询数据库是否已经存在，不存在则插入新的数据
        构造 sql（列举）： select * from coronavirus where date == ?
        '''
        results = session.query(type(entity)).filter(
            type(entity).__dict__.get(key) == entity.__dict__.get(key)
        ).all();
        if len(results) == 0:
            session.add(entity)
            session.commit();
        session.close();

# 修改
def update_(entity, key):
    d = entity.__dict__;
    d.pop("_sa_instance_state");
    session = init_db_session();
    if session:
        session.query(type(entity)).filter(
            type(entity).__dict__.get(key) == entity.__dict__.get(key)
        ).update(d);
        session.commit();
        session.close();

# 删除
def delete_(entity, key):
    session = init_db_session();
    if session:
        session.query(type(entity)).filter(
            type(entity).__dict__.get(key) == entity.__dict__.get(key)
        ).delete();
        session.commit();
        session.close();

# 查询所有
def get_all(entity):
    results = None;
    session = init_db_session();
    if session:
        results = session.query(type(entity)).all();
        session.close();
    return results;

# 查询单个
def get_one(entity, key):
    result = None;
    session = init_db_session();
    if session:
        result = session.query(type(entity)).filter(
            type(entity).__dict__.get(key) == entity.__dict__.get(key)
        ).first();
        session.close();
    return result;

# 原生 sql
def execute_(sql):
    results = None;
    session = init_db_session();
    if session:
        if sql.lower().startswith("select"):
            results = session.execute(sql).fetchall();
        else:
            results = session.execute(sql);
            session.commit();
        session.close();
    return results;

if __name__ == '__main__':
    pass