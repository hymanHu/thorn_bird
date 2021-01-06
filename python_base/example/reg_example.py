#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

import re;

# ==== 匹配字符串 ====
email_re = r'^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$';
# 如果匹配成功，将返回一个Math对象，失败则返回None
if re.match(email_re, "hujiangux@163.com"):
    print("ok");
else:
    print("error");

# ==== 切分字符串 ====
print("a b c".split(" "));
print(re.split(r"\s+", "a b  c"));
print(re.split(r"[\s\,\;]+", "a,b;; c   d"));

# ==== 分组 ====
# 分组提取电话号码
math = re.match(r"^(\d{3})-(\d{3,8})$", "010-12345");
print(math.groups()); # ('010', '12345')
print(math.group(0)); # 010-12345
print(math.group(1)); # 010
print(math.group(2)); # 12345
# 分组提起时间
math = re.match(r"^(0[0-9]|1[0-9]|2[0-3]|[0-9])\:"
    r"(0[0-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0-9]|[0-9])\:"
    r"(0[0-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0-9]|[0-9])$", "19:05:30");
print(math.groups());
# 贪婪匹配
print(re.match(r"^(\d+)(0*)$", "102300").groups()); # ('102300', '')
print(re.match(r"^(\d+?)(0*)$", "102300").groups()); # ('1023', '00')

# ==== Email验证、找出用户名 ====
email_re = r'^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$';
email_name_re = r'<?([^@|^>]*).*@.*';
print(re.match(email_re, "hyman@163.com"));
print(re.match(email_re, "bill.gates@microsoft.com"));
print(re.match(email_re, "y_cat-st@example.com"));
print(re.match(email_name_re, "<Tom Paris> tom@voyager.org").groups());
print(re.match(email_name_re, "tom@voyager.org").groups());


