#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

from collections.abc import Iterable;

# ==== ASCII转换 ====
print("98-->%s;a-->%s"%(chr(98), ord('a')));

# ==== encode && decode ====
print("cdsa".encode("ascii")); # 输出b'cdsa'，转化为bytes类型；
#print("中文".encode("ascii")); # 报错，ascii只定义了127个字符，中文无法解析；
print("中文".encode("utf-8")); # 输出b'\xe4\xb8\xad\xe6\x96\x87'，转化为bytes类型，无法显示为ASCII字符的字节，用\x##显示；
print(b'cdsa'.decode("ascii")); # 输出cdsa，将bytes类型按照ascii解码；
print(b'\xe4\xb8\xad\xe6\x96\x87'.decode("utf-8")); # 输出中文，将bytes类型按照utf8解码；

# ==== 前缀字符串 ====
print(u'中文'); # 后面字符串是以Unicode编码
print(r'dddd'); # 后面字符串是普通字符串
print(b'qwerr'); # 后面是bytes

# ==== len ====
print(len("aaa")); # 3，对于str计算字符数
print(len("中文")); # 2，对于str计算字符数
print(len("aaa".encode("utf-8"))); # 3，对于bytes计算字节数
print(len("中文".encode("utf-8"))); # 6，对于bytes计算字节数 ---- 可见utf8中一个中文占3个字节

# ==== replace ====
a = "cdcacdsahymancdscda";
print(a.replace("hyman", "----"));
print(a);

# ==== find ====
print("cdsacdas".find("a")); # 字符串第一次出现下标，没有-1
print("cdsacdas".rfind("a")); # 字符串最后一次出现下标，没有-1

# ==== isspace ====
print("  ".isspace());

# ==== 字符串格式化 ====
print("%d----%2d----%02d"%(2, 3, 4)); # 2d（不足两位左边补空格）、02d（不足两位，左边补0）
print("%f----%.2f"%(222.2, 333.345)); # .2f（保留两位小数，四舍五入）
print("%x"%333); # 格式化为十六进制
print("%s%%%s"%("3", "2"));
print(list("%s" % x for x in range(2, 10))); # 将2-10生成器，转化为字符串list
print("Hi {0}, 成绩提高了{1:.1f}%".format("小明", 1.234));
print("Hi {0}, 成绩提高了{1}%".format("小明", "%.1f"%1.234));
print("-".join(["a", "b", "c"]));

# ==== 字符串切片 ====
s = "cdvdjkcdncdsc;adcjdsna";
print(s[:5]);
print(s[2:5]);
print(s[-3:]);
print(s[-5:-2]);
print(s[2:8:3]); # 取2-8位字符，每三个取一个
print(s[::3]); # 所有字符，每三个取一个
print(s[::-1]); # 所有字符，倒序
print(s[:]); # 所有字符

# ==== 字符串迭代 ====
s = "vdsvfvadas";
print(isinstance(s, Iterable));
for char in s:
    print(char);