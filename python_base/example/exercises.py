#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

# ==== 练习 ====
# ---- 定义一个函数，接受0个或多个参数，累计乘积 ----
def product(*numbers):
    if len(numbers) == 0:
        raise TypeError("Param is error.");
    count = 1;
    for i in numbers:
        count *= i;
    return count;
print(product(*[1,2,4,6,7]));
print(product(1,2,4,6,7));

# ---- 递归实现汉诺塔游戏 ----
def hannuota(n, a, b, c):
    if n == 1:
        print(a, "---->", c);
    else:
        hannuota(n - 1, a, c, b); # 借助C柱，将n-1个圆盘从A柱移动到B柱
        print(a, "---->", c); # 将A柱最底层的圆盘移动到C柱
        hannuota(n - 1, b, a, c); # 借助A柱，将n-1个圆盘从B柱移动到C柱
hannuota(3, "a", "b", "c");

# ---- 画心形 ----
# 方式一
'''
    1、选择 (x² + y² - 1)³ - x²y³ = 0函数，函数等于0是一条心形线，取x,y=0,函数小于0的，说明内部小于0
    2、y轴从上到下，step=-1，x轴从左到右计算
    3、计算每行字符串：公式<=0，则添加给定的字符串，否则添加空格
    4、将每行字符串放到list中
'''
def heart():
    content = "I love U";
    lines = [];
    for y in range(12, -12, -1):
        line = "";
        for x in range(-30, 30):
            # 和原始的公式不一样, 做了x、y轴的缩放
            # formula = (x ** 2 + y ** 2 - 1) ** 3 - x ** 2 * y ** 3;
            formula = ((x * 0.05) ** 2 + (y * 0.1) ** 2 - 1) ** 3 - (x * 0.05) ** 2 * (y * 0.1) ** 3;
            if formula <= 0:
                # lineStr += content[x % len(content)]; # 画出比较耿直的心
                line += content[(x - y) % len(content)];  # 画出比较斜点的心
            else:
                line += " ";
        lines.append(line);
    # print("\n".join(lines));
    # 打印颜色
    for i in "\n".join(lines):
        print("\033[91m" + i, end="", flush=True);
heart();
# 方式二
'''
现在将 print("\n".join(lines)); 反向组装，简化代码
每一行可以是字符串，也可以是一个char list，然后使用"".join的方式连接
for in的另外一种写法，在join括号内定义，外层join是y循环，里层join是x循环
'''
print("\n".join("".join("Love"[(x-y) % len("Love")]for x in range(-30, 30))for y in range(12, -12, -1)));
'''
上面的代码打印出来的是一个长方形，现在要加入判断，引入心形公式
if判断逻辑决定是添加字符串字符，还是添加" ",所以在这个逻辑外面添加括号
这样就将上面的代码转为一句代码完成
'''
print("\n".join("".join(("Love"[(x-y) % len("Love")] if ((x * 0.05) ** 2 + (y * 0.1) ** 2 - 1) ** 3 -
(x * 0.05) ** 2 * (y * 0.1) ** 3 <= 0 else " ")for x in range(-30, 30))for y in range(12, -12, -1)));

# ---- 斐波拉契数列Fibonacci ----
def fibonacci(max):
    # 相当于 t = (0, 0, 1); n = t[0]; a = t[1]; b = t[2];
    n, a, b = 0, 0, 1;
    sb = "";
    while n <= max:
        sb += str(b) + ",";
        a, b = b, a + b;
        n += 1;
    return sb[:-1];
print(fibonacci(20));

# ---- trim函数 ----
def trim(s):
    if len(s) == 0 or s.isspace():
        return "";
    while s[0] == " ":
        s = s[1:];
    while s[-1] == "":
        s = s[:-1];
    return s;
print(trim("  cc dsac  "));

# ---- 查找list中的最大值和最小值 ----
def find_max_min(l):
    if len(l) == 0:
        return (None, None);
    if len(l) == 1:
        return (l[0], l[0]);
    max = l[0];
    min = l[0];
    for item in l:
        if item > max:
            max = item;
        if item < min:
            min = item;
    return (min, max);
print(find_max_min([]));
print(find_max_min([1]));
print(find_max_min(range(10)));

# ==== 杨辉三角形 ====
def yanghui():
    l = [1];
    while True:
        yield l;
        l = [1] + [l[n] + l[n + 1] for n in range(len(l) - 1)] + [1];
n = 0;
result =[];
for y in yanghui():
    # print(y);
    result.append(y)
    n += 1;
    if n == 10:
        break;
print(result);