#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

import math;

# ==== 位置参数或关键字参数 ====
def count(start, end = 5):
    if not isinstance(start, (int, float)):
        raise TypeError("Bad type");
    count = 0;
    while start <= end:
        count += start;
        start += 1;
    return count;
print(count(1, 100));

# ==== 可变参数 ====
def cal(*number):
    sum = 0;
    for i in number:
        sum += i;
    return sum;
print(cal());
print(cal(1,2,3,4,5,77));

# ==== 可变关键字参数 ====
def person(name, age, **kwargs):
    if "city" in kwargs:
        pass;
    print("name:%s;age:%s;city:%s"%(name, age, kwargs.get("city")));
kwargs = {"city":"chengdu"};
person("hj",44,**kwargs);
person("hj", 33, gender="M", city="chengdu");

# ==== 命名关键字参数 ====
def person(name, age, *, city):
    print("name:%s;age:%s;city:%s"%(name, age, city));
person("hj", 44, city="chengdu");

# ==== 多返回值 ====
def move(x, y, step, angle):
    nx = x + step * math.cos(angle);
    ny = y + step * math.sin(angle);
    return nx, ny;
print(move(12, 22, 4, 30));

# ==== 空函数 ====
def fun():
    pass;
print(fun());

# ==== 递归函数（计算阶乘） ====
def fact(number):
    if number == 1:
        return  number;
    return number * fact(number - 1);
print(fact(5));
# 尾递归函数
def fact2(number, sum):
    if number == 1:
        return sum;
    return fact2(number - 1, number * sum);
print(fact2(5, 1));

# ==== 内置函数 ====
print(int("22")); # 数据类型转换函数，注意，如果定义变量名和函数名一样，则不会调用该函数，会报错
print(float("22.2"));
print(str(22));
print(abs(-111)); # abs函数，求绝对值
print(max(12, 34, 123.4)); # max函数，求最大值
print(min(-21, -11, 0, 22.3)); # min函数，求最小值
print(" aa bb  cc  ".strip()); # 字符串去前后空格
print(hex(12)); # hex函数，将十进制数转十六进制
print(math.sqrt(3)); # 求平方根
print(sum(range(1, 101))); # 求和
print(sum(list(range(101))));
print("cdaDcdsa".capitalize()); # 将字符串第一个字符变成大写，其他小写



