#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

# ==== input and output ====
print("Hello World");
# 遇到逗号，在拼接字符串的时候自动添加空格
print("Hello", "World");
# name = input();
# print("Hello", name);
name = "HymanHu";
print("Hello %s"%name);
first_name = "Hu";
last_name = "Hyman";
print("Hello %s%s"%(last_name, first_name));

# ==== 数据类型 ====
a = 33;
print("a的数据类型%s, 值%s"%(type(a), a));
a = 33.3;
print("a的数据类型%s, 值%s"%(type(a), a));
b = float(a);
print("b的数据类型%s, 值%s"%(type(b), b));
a = "33";
print("a的数据类型%s, 值%s"%(type(a), a));
a = 3 > 2;
print("a的数据类型%s, 值%s"%(type(a), a));
a = None;
print("a的数据类型%s, 值%s"%(type(a), a));
a = b'asd';
print("a的数据类型%s, 值%s"%(type(a), a));
a = ["aaa", "bbb"];
print("a的数据类型%s, 值%s"%(type(a), a));
a = ("aaa", "bbb");
print("a的数据类型%s, 值%s"%(type(a), a));

# ==== 运算符 ====
print((100 + 22.2 - 5 * 2) / 2);
print(5 // 2); # 地板除，取整
print(5 % 2);
print(2 ** 3); # 乘方
a = True and False;
print("a的数据类型%s, 值%s"%(type(a), a));
a = True or False;
print("a的数据类型%s, 值%s"%(type(a), a));
a = not False;
print("a的数据类型%s, 值%s"%(type(a), a));

# ==== 变量、常量 ====
MAX_VALUE = 333;
a = 'aaa';
b = a;
a = 'sss';
print("%s====%s===%s"%(MAX_VALUE, a, b));

a = int(33.3); # int函数在内建作用域
__name = "HymanHu"; # 全局作用域
def fun():
    name = "JiangHu"; # 闭包函数外的函数域
    print(name);
    def fun2():
        name = "Hawkist"; # 局部作用域
        print(name);

fun();

# ==== 条件判断 ====
a = 20;
if a < 10:
    print("aaaa");
elif 10 <= a < 20:
    print("bbb");
else:
    print("ccc");
a = " ";
if a and a.strip():
    print(a);
else:
    print("Null string");
# 三目运算符
a, b, c = 1, 2, 3;
print(a if (b > c) else c);

# ==== 循环 ====
a = list(range(10));
sum = 0;
for x in a:
    print(x);
    sum += x;
print("sum: %s"%sum);
sum = 0;
i = 0;
while i < 10:
    sum += i;
    i += 1;
print("sum: %s"%sum);
i = 0;
while i < 10:
    if i > 5:
        break;
    i += 1;
print(i);