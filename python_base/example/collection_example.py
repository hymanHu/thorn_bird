#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

from collections.abc import Iterable, Iterator;
import os;

# ==== list ====
l = list(range(10));
l = ["csa", 123, True, "cdsacda"];
# 从前取值，index从0开始往后；从后取值，index从-1开始往前
print(l[0] + "----" + l[-1]);
# 集合尾部添加元素
l.append("hymanhu");
# 将后面集合的元素添加到前面集合，注意和append的区别，append是将append的整体作为一个元素纳入前面集合；
l += list(range(3));
# 集合指定位置插入元素
l.insert(1, "hujiang");
# 删除集合最后一个元素
l.pop();
# 删除集合中指定位置元素
l.pop(0);
# 直接对集合元素进行赋值
l[0] = "hymanHu111";
print("list: %s, length: %s" % (l, len(l)));

# ==== list切片 ====
l = list(range(100));
print(l[:10]);
print(l[10:20]);
print(l[-10:]);
print(l[-20:-10]);
print(l[:10:2]); # 前十个，每两个取一个
print(l[::3]); # 所有数，每三个取一个
print(l[::-1]); # 所有数，倒序
print(l[:]); # 所有数

# ==== list迭代 ====
l = list(range(10));
print(isinstance(l, Iterable));
for item in l:
    print(item);
# enumerate 函数作用于可遍历对象，列出下标
for i, item in enumerate(l):
    print(i, item);

# ==== tuple ====
t = tuple(range(10));
t = ("aads", 123, True, None, 12.3);
# 定义只有一个元素的元祖，元素后追加“,”，以免误解成数学计算意义上的括号
t = ("cdsa",);
# 集合作为元祖的元素，我们可以修改集合的元素
t = ("vsv", ["aaa", "sss"]);
t[1][1] = "bbbb";
print("tuple: %s, length: %s"%(t, len(t)));

# ==== tuple切片 ====
t = tuple(range(10));
print(t[:5]);
print(t[2:5]);
print(t[-3:]);
print(t[-5:-3]);
print(t[2:8:2]); # 取2-8位，每两个取一个
print(t[::2]); # 所有数，两个取一个
print(t[::-1]); # 所有数，倒序
print(t[:]); # 所有数

# ==== tuple迭代 ====
t = tuple(range(10));
print(isinstance(t, Iterable));
for item in t:
    print(item);
for i, item in enumerate(t):
    print(i, item);

# ==== dict ====
d = {"name":"hyman","age":33,"money":22.3};
print("dict: %s, length: %s"%(d, len(d)));
# get 取值，没有返回 None，也可给定默认值
print(d.get("name"), d.get("name1"), d.get("name1", "hujiang"));
# 赋值取值
d["aaaa"] = "aaaa";
d["name"] = "hymanhu1";
print(d["name"], d["age"]);
# 删除
d.pop("money");
print("dict: %s, length: %s"%(d, len(d)));

# ==== dict迭代 ====
d = {"name":"hj", "age":30, "city":"cd"};
print(isinstance(d, Iterable));
for key in d:
    print(key, d.get(key));
for value in d.values():
    print(value);
for key, value in d.items():
    print(key, value);

# ==== set ====
s = set(["aaa",123, 123, True]);
s.add("fdsaa");
# 移除下标从1开始
s.remove(1);
print("set: %s, length: %s"%(s, len(s)));
# 交集、合集
s2 = set([123, "fdcasc"]);
print(s & s2);
print(s | s2);

# ==== 列表生成式 ====
l = list(range(10));
d = {"a":1,"b":2,"c":3};
l_ = [item * item for item in l];
l_ = [item * item for item in l if item % 2 == 0];
l_ = [item.lower() for item in ["Hyamn", 10, None, "Hu"] if isinstance(item, str)];
l_ = [x + y for x in "abc" for y in "qwe"];
l_ = [item.upper() for item in "asd"];
l_ = [item.lower() for item in l_];
# 注意，value值如果是int，需要使用str函数转换，不然会报错误
l_ = [key + "=" + str(value) for key, value in d.items()];
# 导入os模块，遍历当前文件夹下文件
l_ = [f for f in os.listdir(".")];
print(l_);

# ==== 生成器generator ====
# ---- 列表转生成器 ----
g = (item for item in range(10));
print(next(g), g.__next__(), next(g));
# ---- 函数转生成器 ----
def fun():
    i = 1;
    while True:
        temp = yield i ** 2;
        print(temp);
        i += 1;
f = fun();
# 第一次运行只能使用next或者send(None)
# send函数是Generator类的方法，作用相当于使生成器继续运行
# send参数，传递给yield返回值，即temp = "Hello World"
print(next(f), f.__next__(), next(f), f.send("hello world"));

# ==== 迭代对象、迭代器 ====
print(isinstance([], Iterable));
print(isinstance({}, Iterable));
print(isinstance("dsadas", Iterable));
print(isinstance((item for item in range(10)), Iterable));
print(isinstance([], Iterator));
print(isinstance({}, Iterator));
print(isinstance("dsadas", Iterator));
print(isinstance((item for item in range(10)), Iterator)); # 生成器是迭代器，其它的迭代对象不是
print(isinstance(iter([]), Iterator)); # 调用iter()函数将迭代对象转化为迭代器
print(isinstance(iter({}), Iterator));
print(isinstance(iter("sfdsfs"), Iterator));
