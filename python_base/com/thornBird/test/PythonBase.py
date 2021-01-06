# input and output
import math;
import urllib
from collections.abc import Iterable;
from collections.abc import Iterator;
from functools import reduce;
import os;

print("Hello World");
# 遇到逗号，在拼接字符串的时候自动添加空格
print("Hello", "World");
print("200+100=", 200 + 100);
# -----------------------------------
#name = input();
#print(name);
# -----------------------------------
# 数据类型
a = 33;
print("a的数据类型%s"%(type(a)));
a = 33.3;
b = float(a);
print("b的数据类型%s,值%s"%(type(b), b));
a = "33";
print("a的数据类型%s"%(type(a)));
b = int(a);
print("b的数据类型%s"%(type(b)));
a = 3 > 2;
print("a的数据类型%s, value:%s"%(type(a), a));
# 加减乘除
print((100 + 200 - 20 * 2) / 2);
print(5 // 2);
print(5 % 2);
# and\or\not运算
a = True and False;
print("a的数据类型%s, value:%s"%(type(a), a));
a = True or False;
print("a的数据类型%s, value:%s"%(type(a), a));
a = not True;
print("a的数据类型%s, value:%s"%(type(a), a));
a = None;
print("a的数据类型%s, value:%s"%(type(a), a));
'''
字符串转义
\n ---- 换行
\t ---- 制表符
'''
print("I\'m ok.")
# 字符串替换，尾部追加，不换行
print("a的数据类型%s"%(type(a)), end="----");
print("b的数据类型%s"%(type(b)));
# -----------------------------------
# 常用数学函数
print("向上求整：", math.ceil(b));
print("向下求整：", math.floor(b));
print("四舍五入：", round(b));
a = max(1, 2, 3, 4, 5);
print("最大值：", a);
a = min(1, 2, 3, 4, 5);
print("最小值：", a);
# -----------------------------------
# for 循环
for i in range(10):
    print(i, end="-");
print("");
# 指定范围起始
for i in range(1, 11):
    print(i, end="-");
print("");
# 指定循环间隔
for i in range(1, 11, 2):
    print(i, end="-");
print("");

print(ord('a'));
print(chr(98));
print(b"abd");
print("cdsa".encode("ascii"));
print("cdsa".encode("utf-8"));
print("中文".encode("utf-8"));
print(b'cdsa'.decode("ascii"));
print(b'\xe4\xb8\xad\xe6\x96\x87'.decode("utf-8"));

print(len("aaa"));
print(len("中文"));
print(len("aaa".encode("ascii")));
print(len("中文".encode("utf-8")));

a = 1;
print("a的数据类型%s,值为%d"%(type(a), a));
print("%2d ---- %02d ---- %d%%" % (3, 3, 2));
print('%.2f' % 3.1415926);

print("Hi {0}, 成绩提高了{1:.1f}%".format("小明", 1.234));
print("Hi {0}, 成绩提高了{1}%".format("小明", '%.1f' % 1.234));

L = ["csa", 123, True, "cdsacda"];
print("list: %s, length: %d" % (L, len(L)));
print(L[0] + "--" + L[-1]);
L.append("ffffff");
L.insert(1, "jjjjj");
L.pop();
L.pop(1);
L[1] = "sssss";
print(L);
t = ("cdsa", "fdsa");
print("tuple: %s, length: %d" % (t, len(t)));
t = (1,);
print("tuple: %s, length: %d" % (t, len(t)));
t = (1, ["cdsa", "cdsa"]);
t[1][0] = "aaaa";
print("tuple: %s, length: %d" % (t, len(t)));

a = 20;
if a > 6:
    print("aaaaaaaaa");
    print("bbbbbbbb");
elif a > 18:
    print("ccccccc");
else:
    print("ddddddddd");

# a = input("birthday:")
# 注意输入类型为String，需要转化，如果输入字母，则报错
# b = int(a);
'''
if b > 2000:
    print("00+");
else:
    print("00-");
'''

a = ["cdsa", "vdsadsa", "ffdsadsa"];
for item in a:
    print(item);
a = range(100);
s = 0;
for item in a:
    s += item;
print(s);
# ==================================
s = 0;
n = 0;
while n < 100:
    s += n;
    n += 2;
print(s);
n = 0;
while n < 10:
    if n > 5:
        break;
    print(n);
    n += 1;
n = 0;
while n < 10:
    n += 1;
    if n % 2 == 0:
        continue;
    print(n);

d = {"hyman":88, "bob":77, "lisa":86};
print(d);
print(d["hyman"]);
d["hyman"] = 99;
print(d["hyman"]);
print("hyman" in d);
print(d.get("hyman1"));
print(d.get("hyman1", 55));
d.pop("lisa");
print(d);

s1 = set([1, 2, 3, 1, 2, 3, 4]);
print(s1);
s1.add(10);
s1.remove(1)
print(s1);
s2 = set([3, 4, 5, 6]);
print(s1 & s2);
print(s1 | s2);

string = "cdcacdsahymancdscda";
print(string.replace("hyman", "HHHHHH"));
print(string);

print(abs(-199));
print(max(1, 2, 34.3, 5));
print(min(1, 4, 5, -3.3, 5.6));
print(int("23"));
print(float("3.33"));
print(str(22));
print(hex(1));

def count(start, end = 5):
    if not isinstance(start, (int, float)):
        raise TypeError("Bad type");
    item = start;
    count = 0;
    while item <= end:
        count += item;
        item += 1;
    return count;
print(count(1));
print(count(1, 6));
# --------------------------------
def addEnd(L=None):
    if L is None:
        L = [];
    L.append("NONE");
    return L;
print(addEnd());
print(addEnd());
# --------------------------------
def calc(*numbers):
    sum = 0;
    for item in numbers:
        sum += item;
    return sum;
print(calc());
print(calc(1, 2, 5, 9));
a = [2, 3, 5, 7];
print(calc(*a));
# ---- 关键字参数 ----
def person(name, age, **keyWord):
    if "city" in keyWord:
        pass;
    print("name:", name, "age:", age, "others:", keyWord);
person("Hyman", "40");
person("Hyman", "40", gender = "M", city = "chengdu");
extra = {"gender":"M1", "city":"chengdu1"};
person("Hyman", "40", **extra);
def person1(name, age, *, city):
    print(name, age, city);
person1("hyman", 40, city = "chengdu");
#print(person("Hyman", "40"));
# --------------------------------
def move(x, y, step, angle):
    nx = x + step * math.cos(angle);
    ny = y + step * math.sin(angle);
    return nx, ny;
print(move(12, 33, 10, 30))
# --------------------------------
def nullFunction():
    pass;
print(nullFunction());

print(math.sqrt(3));
print(math.cos(30));
print(math.sin(30));

def product(*numbers):
    if len(numbers) == 0:
        raise TypeError("list is null");
    sum = 1;
    for item in numbers:
        sum *= item;
    return sum;
numbers = [1, 2, 3, 5, 7];
print(product(*numbers));
# ---- 递归函数（计算阶乘） ----
def fact(n):
    if n == 1:
        return 1;
    return n*fact(n - 1);
print(fact(5));
def fact2(n, sum):
    if n == 1:
        return sum;
    return fact2(n - 1, n * sum);
print(fact2(5, 1));
def hannuota(n, a, b, c):
    if n == 1:
        print(a, "---->", c);
    else:
        hannuota(n -1, a, c, b);
        print(a, "---->", c);
        hannuota(n - 1, b, a, c);
hannuota(10, "a", "b", "c");

# ---- list切片 ----
L = list(range(22));
print(L);
print(L[:10]);
print(L[10:20]);
print(L[-10:]);
print(L[-20:-10]);
print(L[:10:2]); # 前十个，每两个取一个
print(L[::3]); # 所有数，每三个取一个
print(L[:]); # 取所有

# ---- tuple切片 ----
T = (1, 2, 3, 5, 22, 34, 56);
print(T[:5]);
print(T[2:5]);
print(T[-3:]);
print(T[-3:-1]);
print(T[::2]);
print(T[:]);

# ---- 字符串切片 ----
s = "dsafdffdas sdafdsa";
print(s[0]);
print(s[-1]);
print(s[:5]);
print(s[2:5]);
print(s[-3:]);
print(s[:10:2]); # 所有数，每三个取一个
print(s.strip());

# 定义一个trim()函数，去掉前后空格
def trim(s):
    if len(s) == 0 or s.isspace():
        return '';
    while s[0] == ' ':
        s = s[1:];
    while s[-1] == ' ':
        s = s[:-1];
    return s;
print(trim(""));
print(trim("  dsadad  "));

# ---- list迭代 ----
print(isinstance(L, Iterable));
for item in L:
    print(item);
for i, item in enumerate(L):
    print(i, item);
# ---- tuple迭代 ----
print(isinstance(T, Iterable));
for item in T:
    print(item);
for i, item in enumerate(T):
    print(i, item);
# ---- dict迭代 ----
print(isinstance(d, Iterable));
for key in d:
    print(key, d.get(key));
for value in d.values():
    print(value);
for key, value in d.items():
    print(key, value);
# ---- str迭代 ----
print(isinstance(s, Iterable));
for char in s:
    print(char);

# ---- 查找list中的最大值和最小值 ----
def findMaxAndMin(l):
    if len(l) == 0:
        return (None, None);
    elif len(l) == 1:
        return (l[0], l[0]);
    max = l[0];
    min = l[0];
    for item in l:
        if item > max:
            max = item;
        if item < min:
            min = item;
    return (max, min);
print(findMaxAndMin(L));

l1 = [item * item for item in L];
print(l1);
l1 = [item * item for item in L if item % 2 == 0];
print(l1);
l2 = [x + y for x in "abc" for y in "defg"];
print(l2);
l2 = [item.upper() for item in "adsad"];
print(l2);
l2 = [item.lower() for item in l2];
print(l2);
# 注意，value值如果是int，需要使用str函数转换，不然会报错误
l3 = [key + "=" + str(value) for key, value in d.items()];
print(l3);
# 导入os模块，遍历当前文件夹下文件
l4 = [f for f in os.listdir(".")];
print(l4);

# 将L1转为L2
L1 = ['Hello', 'World', 18, 'Apple', None];
L2 = [item.lower() for item in L1 if isinstance(item, str)]; # 使用isinstance函数判断每项是否为字符串
print(L2);

g = (item * item for item in L);
print(next(g));
for item in g:
    print(item);

# ---- 斐波拉契数列Fibonacci（除第一个和第二个数之外，任意一个数字都由前两个数相加得到） ----
def fibonacci(max):
    # 相当于 t = (0, 0, 1); n = t[0]; a = t[1]; b = t[2];
    n, a, b = 0, 0, 1;
    sb = "";
    while n < max:
        sb += str(b) + ",";
        a, b = b, a + b;
        n += 1;
    return sb[:-1];
print(fibonacci(20));

# ---- 杨辉三角形，函数生成器 ----
# 把每一行看做一个list，下一行除了头和尾，是上一行每两个数之和
def yanghui():
    L = [1];
    while True:
        yield L;
        L = [1] + [L[n] + L[n + 1] for n in range(len(L) - 1)] + [1];
result = [];
n = 0;
for t in yanghui():
    #result.append(t);
    print(t);
    n += 1;
    if n == 10:
        break;

print(isinstance([], Iterable));
print(isinstance({}, Iterable));
print(isinstance("cdsa", Iterable));
print(isinstance([item for item in range(10)], Iterable));
print(isinstance([], Iterator));
print(isinstance({}, Iterator));
print(isinstance("ccdsacdas", Iterator));
print(isinstance((item for item in range(10)), Iterator)); # 生成器是迭代器，其它的迭代对象不是
print(isinstance(iter([]), Iterator)); # 调用iter()函数将迭代对象转化为迭代器
print(isinstance(iter({}), Iterator));
print(isinstance(iter("cdadas"), Iterator));

def functionCall(x, y, f):
    return f(x) + f(y);
f = abs;
print(functionCall(-1, -2, f));

# ---- map函数 ----
def f(x):
    return x * x;
i = map(f, list(range(10)));
print(list(i));
print(list(map(str, range(10))));

def add(x, y):
    return x + y;
print(reduce(add, range(100)));
print(sum(list(range(100))));
print(sum(range(100)));

# ---- 将序列[1, 3, 5, 7, 9]变换成整数13579 ----
def f(x, y):
    return x * 10 + y;
print(reduce(f, [1, 3, 5, 7, 9]));

# ---- 传入str，依次到map中找对应的int进行拼接，还可以使用lambda表达式简化函数定义
def str2int(s):
    def f1(x, y):
        return x * 10 + y;
    m = {'0': 0, '1': 1, '2': 2, '3': 3, '4': 4, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9};
    def f2(x):
        return m[x];
    return reduce(f1, map(f2, s));
print(str2int("13579"));
m = {'0': 0, '1': 1, '2': 2, '3': 3, '4': 4, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9};
def f3(x):
    return m[x];
def str2int2(s):
    return reduce(lambda x, y : x * 10 + y, map(f3, "13957"));

print("cdacdA".capitalize());

l = ['adam', 'LISA', 'barT'];
def f(x):
    return x.capitalize();
print(list(map(f, l)));
print(list(map(lambda x : x.capitalize(), l)));

def f(l):
    return reduce(lambda x, y : x * y, l);
print(f([1, 2, 3, 4]));

print(list(range(10)));
print(list(range(10))[::-1]);
print(reduce(lambda x, y : x / 10 + y, map(int, list(range(10))[::-1] + [0])));
def str2Float(x):
    l1, l2 = x.split(".");
    l2 = l2[::-1] + "0";
    return reduce(lambda x, y : x * 10 + y, map(int, l1)) + reduce(lambda x, y : x / 10 + y, map(int, l2));
print(str2Float("32142.4321"));

s = " ";
if s and s.strip():
    print(s);
else:
    print("aaaa");

def notEmpty(x):
    return x and x.strip();
print(list(filter(notEmpty, ['A', '', 'B', None, 'C', '  '])));

print("-".join(["a", "b", "c"])); # 将字符串join插入list，返回字符串a-b-c
print(list("%s" % x for x in range(2, 5))); # 格式化int生成器，并转化为字符串list：['2', '3', '4']
print(",".join("%s" % x for x in range(2, 5))); #结合上面两个功能，输出2,3,4
print(list(x for x in range(2, 10))); # 输出int list
print([y for y in range(2, 10) if 10 % y == 0]); # 输出循环中最大数的因子数列[2, 5]
# int list 排除所有的因子数列，得到素数数列，格式化为字符串，调用join函数，返回素数字符串
print(",".join("%s" % x for x in range(2, 100) if not [y for y in range(2, x) if x % y == 0]));

def f(n):
    return lambda x : x % n > 0;

print(list(filter(f(2), range(2, 100))));

# 定义一个奇数迭代器
def oddIter():
    n = 1;
    while True:
        n += 2;
        yield n;
# 定义筛选函数，返回是另一个函数
def validate(n):
    return lambda x : x % n > 0;
# 求素数迭代器
def primeNumber():
    yield 2;
    l = oddIter();
    while True:
        n = next(l);
        yield n;
        l = filter(validate(n), l);
l = [];
# 打印100内的素数
for n in primeNumber():
    if n < 100:
        l.append(n);
    else:
        break;
print(",".join(map(str, l)));

print(math.sqrt(16));

l = [];
for i in range(2, 100):
    # for j in range(2, i):
    for j in range(2, (int)(math.sqrt(i) + 1)):
        if i % j == 0:
            break;
    else:
        l.append(i);
print(",".join(map(str, l)));

def f(n):
    return str(n)==str(n)[::-1]
print(list(filter(f, range(1, 100))));
print(list(filter(lambda x : str(x) == str(x)[::-1], range(1, 100))));

def f(n):
    l = [];
    for item in str(n):
        l.insert(0, item);
    return "".join(l) == str(n);
print(list(filter(f, range(1, 100))));

def fn(n):
    return str(n) == reduce(lambda x, y : y + x, str(n));
print(list(filter(fn, range(1, 100))));

print(sorted([36, 5, -12, 9, -21]));
print(sorted([36, 5, -12, 9, -21], key = abs));
print(sorted(['bob', 'about', 'Zoo', 'Credit'])); # 默认根据第一个字符ASCII码
print(sorted(['bob', 'about', 'Zoo', 'Credit'], key = str.lower));
print(sorted(['bob', 'about', 'Zoo', 'Credit'], key = str.lower, reverse=True));

l = [('Bob', 75), ('Adam', 92), ('Bart', 66), ('Lisa', 88)]; # list每个元素是tuple，装载每个学生信息
print(sorted(l)); # 自然排序，按照姓名排序
print(sorted(l, key = lambda x : x[0].lower()));
print(sorted(l, key = lambda x : x[1])); # 按分数排序
print(sorted(l, key = lambda x : x[1], reverse=True)); # 按分数倒序排序

def f():
    l = [];
    for i in range(1, 4):
        def f2():
            return i * i;
        l.append(f2);
    return l;
l1, l2, l3 = f();
print(l1());
print(l2());
print(l3());

def f():
    def f2(j):
        def f3():
            return j * j;

        return f3;
    l = [];
    for i in range(1, 4):
        l.append(f2(i));
    return l;
l1, l2, l3 = f();
print(l1());
print(l2());
print(l3());

l = [0];
l[0] += 1;
print(l);

def fn():
    x = [0];
    def fun():
        x[0] += 1;
        return x[0];
    return fun;
f1 = fn();
print(f1(), f1(), f1());

def fn():
    x = 0;
    def fun():
        nonlocal x;
        x += 1;
        return x;
    return fun;
f1 = fn();
print(f1(), f1(), f1());

def f():
    x = "aaaaa";
    def fn():
        x = "cdscdas";
        return x;
    return fn;
print(f()());

print(list(filter(lambda x : x % 2 == 0, range(1, 20))));

import time;
def log(fun):
    def wrapper(*args, **keywords):
        print("call %s()" % fun.__name__);
        return fun(*args, **keywords);
    return wrapper;
@log
def f():
    print(time.time());
    print(time.localtime(time.time()));
    print(time.strftime("%Y-%m-%d %H:%M:%S", time.localtime(time.time())));
f();
# ---- 带参数的修饰器 ----
def log(text):
    def decorator(fun):
        def wrapper(*args, **kw):
            print("%s %s()" % (text, fun.__name__));
            return fun(*args, **kw);
        return wrapper;
    return decorator;
@log("execute")
def f():
    print(time.time());
    print(time.localtime(time.time()));
    print(time.strftime("%Y-%m-%d %H:%M:%S", time.localtime(time.time())));
f();

def logDecorator(fun):
    def wraper(*args, **kw):
        print("Call %s in %s" % (fun.__name__, time.strftime("%Y-%m-%d %H:%M:%S", time.localtime(time.time()))));
        return fun(*args, **kw);
    return wraper;
@logDecorator
def test():
    print("test");
test();

import functools;
int2 = functools.partial(int, base=2); # 定义新函数，固定住**kw中base=2参数；
print(int2("101010"));
max2 = functools.partial(max, 10); #定义新函数，固定住*args参数中的10，也就是10是固定参数
print(max2(2, 4, 6, 9)); # 相当于max2(10, 2, 4, 6, 9);结果是10

class Student(object):
    def __init__(self, id, name, age):
        self.__id = id;
        self.name = name;
        self.age = age;
    def setId(self, id):
        if id > 0:
            self.__id = id;
        else:
            raise ValueError("Bad data");
    def getId(self):
        return self.__id;
    def printStudentInfo(self):
        print("%s %s %s" % (self.__id, self.name, self.age));
    def getGrade(self):
        if self.age > 40:
            return "C";
        elif self.age > 20:
            return "B";
        else:
            return "A";
hymanHu = Student(1, "HymanHu", 20);
jiangHu = Student(2, "Jianghu", 30);
hymanHu.printStudentInfo();
print(hymanHu.getGrade());
print(hymanHu.name);
# print(hymanHu.__id);
hymanHu.setId(2);
print(hymanHu.getId());
jiangHu.printStudentInfo();
print(jiangHu.getGrade());

class Animal(object):
    def run(self):
        print("Animal running……");
class Dog(Animal):
    def run(self):
        print("Dog running……");
class Cat(Animal):
    def run(self):
        print("Cat running……");
dog = Dog();
cat = Cat();
print(isinstance(dog, Dog));
print(isinstance(dog, Animal));
dog.run();
cat.run();

class Clock(object):
    def run(self):
        print("Clock running……");
def run(animal):
    animal.run();
dog = Dog();
cat = Cat();
clock = Clock();
run(dog);
run(cat);
run(clock);

print(type(123)); # <class 'int'>
print(type("aaaa")); # <class 'str'>
print(type(None)); # <class 'NoneType'>
print(type(abs)); # <class 'builtin_function_or_method'>
print(type(dog)); # <class '__main__.Dog'>
import types;
print(type("cdsa") == str);
print(type(run) == types.FunctionType);
print(type(abs) == types.BuiltinFunctionType);
print(type(lambda x : x + 1) == types.LambdaType);
print(type((x for x in range(1, 10))) == types.GeneratorType);

print(isinstance("dsac", str));
print(isinstance([1, 2], (list, t))); # 还能用几个候选项用于判断
print(isinstance(run, types.FunctionType));
print(isinstance(dog, Animal));

print(dir("dsad"));
print(dir(dog));

print(hasattr(hymanHu, "name"));
setattr(hymanHu, "name", "aaaaa");
print(getattr(hymanHu, "name"));
#print(getattr(hymanHu, "name1")); # 获取不存在的属性，抛出AttributeError
print(hasattr(hymanHu, "printStudentInfo"));
func = getattr(hymanHu, "printStudentInfo");
func();

class Student(object):
    name = "HymanHu"
hyman = Student();
print(Student.name); # 类属性，结果HymanHu
print(hyman.name); # 实例属性，在没有给实例属性赋值，且属性名和类属性一样的情况下，值相同，HymanHu
hyman.name = "JiangHu";
print(Student.name); # 类属性，结果HymanHu
print(hyman.name); # 实例属性，结果JiangHu

class Student(object):
    count = 0;
    def __init__(self, name):
        Student.count += 1;
        self.name = name;
hyman = Student("HymanHu");
jianghu = Student("JiangHu");
print(Student.count);

from types import MethodType;
class Human(object):
    pass;
def setAge(self, age):
    self.age = age;
def setSex(self, sex):
    self.sex = sex;
Human.setSex = setSex;
# 给类动态绑定方法
jianghu = Human();
jianghu.setSex("man");
print(jianghu.sex);
# 给实例绑定属性和方法，但是对另外的实例不起作用
hyman = Human();
hyman.name = "HymanHu";
hyman.setAge = MethodType(setAge, hyman); # 第一参数函数名，第二个参数是实例对象
hyman.setAge(33);
print(hyman.name);
print(hyman.age);

class Human(object):
    __slots__ = ("name", "age");
hyman = Human();
hyman.name = "Hyman";
# hyman.sex = "man";
print(hyman.name);
# print(hyman.sex); # AttributeError: 'Human' object has no attribute 'sex'

import datetime;
class Student(object):
    @property
    def getAge(self):
        return self._age;
    @getAge.setter
    def setAge(self, age):
        if not isinstance(age, int):
            raise ValueError("Age must integer.");
        if age < 0 or age > 200:
            raise ValueError("Age must be in 0 ~ 200.");
        self._age = age;
    @property
    def birthday(self):
        return datetime.datetime.now().year - self._age;
hyman = Student();
# hyman.setAge(44);
hyman.setAge = 44;
print(hyman.getAge);
print(hyman.birthday);

class Animal(object):
    def run(self):
        print("Animal running……");
class FlyMixIn(object):
    def fly(self):
        print("Animal fly……");
class Dog(Animal):
    pass;
class Cat(Animal):
    pass;
class Bird(Animal, FlyMixIn):
    pass;
dog = Dog();
cat = Cat();
print(isinstance(dog, Dog));
print(isinstance(dog, Animal));
dog.run();
cat.run();
bird = Bird();
bird.run();
bird.fly();

class Student(object):
    def __init__(self, name):
        self.name = name;
    def __str__(self):
        return "Student object: %s" % self.name;
    __repr__ = __str__;
hyman = Student("Hyman");
print(hyman);

class Fib(object):
    def __init__(self, max):
        self.a, self.b = 0, 1;
        self.max = max;
    def __iter__(self):
        return self;
    def __next__(self):
        self.a, self.b = self.b, self.a + self.b;
        if self.a > self.max:
            raise StopIteration();
        return self.a;
    # 该方法返回迭代对象元素，item可能是int下标，也可以是切片对象slice
    def __getitem__(self, item):
        if isinstance(item, int):
            a, b = 1, 1;
            for i in range(item):
                a, b = b, a + b;
            return a;
        if isinstance(item, slice):
            start = item.start;
            end = item.stop;
            if start is None:
                start = 0;
            a, b = 1, 1;
            L = [];
            for i in range(end):
                if i >= start:
                    L.append(a);
                a, b = b, a + b;
            return L;
result = "";
fib = Fib(100);
for i in fib:
    result += str(i) + ",";
print(result[:-1]);
print(fib[3]);
print(fib[:5]);

class Chain(object):
    def __init__(self, path = ""):
        self.path = path;
    def __getattr__(self, item):
        return Chain("%s/%s" % (self.path, item));
    def __str__(self):
        return self.path;
    __repr__ = __str__;
chain = Chain();
print(chain.user.status.list);
print(chain.users.hyman.repos);

class Student(object):
    def __init__(self, name):
        self.name = name;
    def __call__(self, *args, **kwargs):
        print("My name is %s" % self.name);
student = Student("Hyman");
print(callable(student));
student();

from enum import Enum, unique;
Month = Enum("Month", ('Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'));
# value属性则是自动赋给成员的int常量，默认从1开始计数
print(Month.Jan.name, Month.Jan.value);
print(dir(Month));
for month, item in Month.__members__.items():
    print(month, item.value);

# unique装饰器检查有没有重复值
@unique
class WeekDay(Enum):
    Sun = 0;
    Mon = 1;
    Tue = 2;
    Wed = 3;
    Thu = 4;
    Fri = 5;
    Sat = 6;
print(WeekDay.Mon.name, WeekDay.Mon.value, WeekDay(1));
for weekDay, item in WeekDay.__members__.items():
    print(weekDay, item.value);

@unique
class Gender(Enum):
    Male = 0;
    Female = 1;
class Student(object):
    def __init__(self, name, gender):
        self.name = name;
        self.gender = gender;
hyman = Student("Hyman", Gender.Male);
print(hyman.name, hyman.gender);

def fn(self, name="Hyman"):
    print("name is %s" % name);
Hello = type("Hello", (object,), dict(hello = fn));
hello = Hello();
hello.hello();

class MyMetaclass(type):
    def __new__(typ, classNmae, parentClassList, classAttrs):
        classAttrs["add"] = lambda self, value : self.append(value);
        return type.__new__(typ, classNmae, parentClassList, classAttrs);
class MyList(list, metaclass=MyMetaclass):
    pass;
l = MyList();
l.add(1);
print(l);

# 创建列类，添加列名和数据类型属性
class Field(object):
    def __init__(self, columnName, columnType):
        self.columnName = columnName;
        self.columnType = columnType;
    def __str__(self):
        return "<%s : %s>" % (self.__class__.__name__, self.columnName);
    __repr__ = __str__;
# 根据不同的数据类型创建不同的列子类
class StringField(Field):
    def __init__(self, columnName):
        super(StringField, self).__init__(columnName, "varchar(100)");
class IntegerField(Field):
    def __init__(self, columnName):
        super(IntegerField, self).__init__(columnName, "bigint");
field = Field("userId", int);
print(field);

# 创建Model元类
class ModelMetaclass(type):
    '''
        思路：Model是dict子类，每个key对应一个列对象
        1、将不同的Model子类中classAttrs（属性和方法）的属性过滤出来，装载到mappings里面
        2、返回Model对应的表名，在此默认Model子类类名
    '''
    def __new__(typ, className, parentClassList, classAttrs):
        print("Metaclass new model……");
        if className == "Model":
            return type.__new__(typ, className, parentClassList, classAttrs);
        print("Found model: %s" % className);
        mappings = dict();
        for key, value in classAttrs.items():
            if isinstance(value, Field):
                print("Found mappings: %s : %s" % (key, value));
                mappings[key] = value;
        # 删除classAttrs中的列属性
        for key in mappings.keys():
            classAttrs.pop(key);
        classAttrs["__mappings__"] = mappings; # 列和属性的映射关系
        classAttrs["__table__"] = className; # 假定表名和类名一致
        return type.__new__(typ, className, parentClassList, classAttrs);

class Model(dict, metaclass=ModelMetaclass):
    def __init__(self, **kw):
        print("init model……");
        super(Model, self).__init__(**kw);
    def __getattr__(self, key):
        try:
            return self[key];
        except KeyError:
            raise AttributeError("Model object has no attribute %s" % key);
    def __setattr__(self, key, value):
        self[key] = value;
    '''
        1、遍历mappings，得到对应的列对象，build sql语句
        2、调用getattr函数，将每列的值装载到args这个list中
    '''
    def save(self):
        fields = [];
        params = [];
        args = [];
        for key, value in self.__mappings__.items():
            fields.append(value.columnName);
            params.append("?");
            args.append(getattr(self, key, None));
        sql = "insert into %s (%s) values (%s)" % (self.__table__, ",".join(fields), ",".join(params));
        print("SQL : %s" % sql);
        print("Args : %s" % str(args));

class User(Model):
    id = IntegerField("id");
    name = StringField("user_name");
    email = StringField("email_package");
    password = StringField("password");

user = User(id = 1, name = "HymanHu", email = "HymanHu@163.com", password = "111111");
user.save();

# def fn():
#     return 1 / int("s");
# def fn1():
#     return fn() * 2;
# def fn2():
#     print(fn1() * 3);
# fn2();

'''
    1、选择 (x² + y² - 1)³ - x²y³ = 0函数，函数等于0是一条心形线，取x,y=0,函数小于0的，说明内部小于0
    2、y轴从上到下，step=-1，x轴从左到右计算
    3、计算每行字符串：公式<=0，则添加给定的字符串，否则添加空格
    4、将每行字符串放到list中
'''
# content = "*";
# lines = [];
# for y in range(12, -12, -1):
#     lineStr = "";
#     for x in range(-30, 30):
#         # 和原始的公式不一样, 做了x、y轴的缩放
#         # formula = (x ** 2 + y ** 2 - 1) ** 3 - x ** 2 * y ** 3;
#         formula = ((x * 0.05) ** 2 + (y * 0.1) ** 2 - 1) ** 3 - (x * 0.05) ** 2 * (y * 0.1) ** 3;
#         if formula <= 0:
#             # lineStr += content[x % len(content)]; # 画出比较耿直的心
#             lineStr += content[(x - y) % len(content)]; # 画出比较斜点的心
#         else:
#             lineStr += " ";
#     lines.append(lineStr);
# print("\n".join(lines));
# 打印颜色
# for i in "\n".join(lines):
#     print("\033[91m"+i,end="", flush=True);

# 现在将 print("\n".join(lines)); 反向组装，简化代码
# 每一行可以是字符串，也可以是一个char list，然后使用"".join的方式连接
# for in的另外一种写法，在join括号内定义，外层join是y循环，里层join是x循环
# print("\n".join("".join("Love"[(x-y) % len("Love")]for x in range(-30, 30))for y in range(30, -30, -1)));
# 上面的代码打印出来的是一个长方形，现在要加入判断，引入心形公式
# if判断逻辑决定是添加字符串字符，还是添加" ",所以在这个逻辑外面添加括号
# 这样就将上面的代码转为一句代码完成
# print("\n".join("".join((" I Love U"[(x-y) % len(" I Love U")] if ((x * 0.05) ** 2 + (y * 0.1) ** 2 - 1) ** 3 -
# (x * 0.05) ** 2 * (y * 0.1) ** 3 <= 0 else " ")for x in range(-30, 30))for y in range(30, -30, -1)));

import logging;
# logging.basicConfig(level=logging.NOTSET);
logging.basicConfig(level=logging.DEBUG,
    format="%(asctime)s - %(filename)s[line:%(lineno)d] - %(levelname)s: %(message)s");
logging.debug("论完美不如松岛枫");
logging.info("论身材不如濑亚美莉");
logging.warning("论颜值不如波多野结衣");
logging.error("论业绩不如吉泽明步");
logging.critical("但是苍老师最红，你有意见么");


import logging;
import os.path;
import time;
# 设置变量
fileFormat = "PythonLog_" + time.strftime("%Y%m%d", time.localtime(time.time()));
logFormat = logging.Formatter("%(asctime)s - %(filename)s[line:%(lineno)d] - %(levelname)s: %(message)s");
logPath = "/log";
logLevel = logging.DEBUG;
# 创建logger
logger = logging.getLogger();
logger.setLevel(logLevel);
# 创建一个 stream handler，输出到控制台 --- 无需设置，logger会自动输出到控制台
# logConsoleHandler = logging.StreamHandler();
# logConsoleHandler.setLevel(logLevel);
# logConsoleHandler.setFormatter(logFormat);
# logger.addHandler(logConsoleHandler);
# 创建一个 file handler，输出到文件
logFile = os.path.abspath(logPath) + "/" + fileFormat + ".log";
logFileHandler = logging.FileHandler(logFile, mode = "w");
logFileHandler.setLevel(logLevel);
logFileHandler.setFormatter(logFormat);
logger.addHandler(logFileHandler);
# 调用日志
logger.debug("论完美不如松岛枫……");
logger.info("论身材不如濑亚美莉……");
logger.warning("论颜值不如波多野结衣……");
logger.error("论业绩不如吉泽明步……");
logger.critical("但是苍老师最红，你有意见么……");

try:
    print("start try block");
    # a = 1 / int("a");
    a = 1 / 2;
    print("result is %s" % a);
except ValueError as e:
    logger.debug(e);
    logging.exception(e);
except ZeroDivisionError as e:
    logger.debug(e);
else:
    logger.debug("no exception");
finally:
    print("start finally block");
print("end");

# def fn(x):
#     if not isinstance(x, int):
#         raise TypeError("Type error");
# fn("cdsa");

class MyException(Exception):
    pass;

print("99 + 88 + 7.6".split("+"));

def fn(x):
    n = int(x);
    assert n != 0, "n is Zero";
    print(x);
    return 10 / n;
print(fn(1));

class MyDict(dict):
    def __init__(self, **kw):
        super().__init__(**kw);
    def __getattr__(self, key):
        try:
            return self[key];
        except KeyError:
            raise AttributeError("Dict object has no attribute for %s" % key);
    def __setattr__(self, key, value):
        self[key] = value;

import unittest;
# 如果测试对象在单独的文件里面，from *** import MyDict;
class TestMyDict(unittest.TestCase):
    def testInit(self):
        d = MyDict(a = 1, b = "aaa");
        self.assertEqual(d.a, 1);
        self.assertEqual(d.b, "aaa");
        self.assertTrue(isinstance(d, dict));
    def testDictError(self):
        d = MyDict();
        # 断言错误
        with self.assertRaises(AttributeError):
            value = d.testKey;

import sys;
import os;
curPath = os.path.abspath(os.path.dirname(__file__));
rootPath = os.path.split(curPath)[0];
sys.path.append(rootPath);

print(os.path.dirname(os.path.dirname(__file__)));
print(sys.path);

# 读取全部，read(size)按照字符长度读写
f = open("D:\\projectCode\\hqyj\python_demo\\resource\\test.txt", "r", encoding ="utf-8");
text = f.read();
print(text);
f.close();
# 读取到list中
f = open("D:\\projectCode\\hqyj\python_demo\\resource\\test.txt", "r", encoding ="utf-8");
lines = f.readlines();
print(lines); # 注意除开最后一行，其余每行都有\n换行符
for line in lines:
    print(line.strip("\n"));
f.close();
# 读取文件捕获IO异常
try:
    f = open("D:\\projectCode\\hqyj\python_demo\\resource\\test.txt", "r", encoding ="utf-8");
    print(f.readlines());
except IOError as e:
    print(e);
finally:
    if f:
        f.close();
# 使用with语句对try、except、finally模块的缩写
with open("D:\\projectCode\\hqyj\python_demo\\resource\\test.txt", "r", encoding = "utf-8") as f:
    print(f.readlines());

# with open("D:\\projectCode\\hqyj\python_demo\\resource\\test.txt", "a", encoding = "utf-8") as f:
#     f.write("\n");
#     f.write("Hello world\n");
#     f.write("Hello world!");

from io import StringIO;
sio = StringIO();
sio.write("Hello World!");
print(sio.getvalue());

sio = StringIO("Hello world\nHello world!");
print(sio.readlines());

from io import BytesIO;
bio = BytesIO();
bio.write("你好".encode("utf-8"));
print(bio.getvalue());
bio = BytesIO(b'\xe4\xbd\xa0\xe5\xa5\xbd');
print(bio.read());

import os;
print(os.name); # 操作系统，nt(Windows)、posix(Linux、Unix、Mac OS X)
# print(os.uname()); # 操作系统详细信息，不支持Windows系统
print(os.environ); # 获取操作系统环境变量
print(os.environ.get("CLASSPATH")); # 获取环境变量中某个值
print(os.path.abspath(".")); # 查看当前目录绝对路径
print(os.path.isfile(".")); # 判断是否为文件
print(os.path.isdir(".")); # 判断是否为文件夹
''''
join ---- 文件目录组装
split ---- 文件目录拆分成tuple，最后一个元素是最后级别的目录或文件夹
why ---- 可以正确处理不同操作系统的分隔符，只是对字符串的操作
'''
print(os.path.join("D:/", "testDir"));
print(os.path.split("D:\\projectCode\\hqyj\\python_demo\\com\\thornBird\\base"));
print(os.path.splitext("D:\\sql\\testdb.sql")) # 拆分文件全路径，可以得到文件后缀
print(os.listdir(".")); # 文件夹下所有的文件和目录
print(os.listdir(os.path.split(os.path.abspath("."))[0])); # 查找当前目录同级文件和目录，包含自己
if not os.path.exists("D:/testDir"):
    os.mkdir("D:/testDir"); # 创建文件夹
# os.rmdir("D:/testDir"); # 删除文件夹
if not os.path.exists("D:/testDir/test.txt"):
    # os.mknod("test.txt"); # Windows不支持mknod
    with open("D:/testDir/test.txt", "a", encoding="utf-8") as f:
        f.write("\nHello world\n");
# os.rename("D:/testDir/test.txt", "D:/testDir/test1.txt"); # 文件重命名
# os.remove("D:/testDir/test1.txt"); # 删除文件

print([x for x in os.listdir(".")]); # 打印出当前目录下所有文件和目录
print([x for x in os.listdir(".") if os.path.isfile(x)]); # 打印出当前目录下所有文件
print([x for x in os.listdir(".") if os.path.isfile(x) and os.path.splitext(x)[1] == ".py"]) # 打印当前目录py文件

def dirList(dir):
    dir = os.path.abspath(dir);
    for x in os.listdir(dir):
        sonDir = os.path.join(dir, x);
        if os.path.isdir(sonDir):
            dirList(sonDir);
        else:
            print(sonDir);
dirList(".");
print("-----------------------------");
dirList("D:\\projectCode\\hqyj\\python_demo\\com");
print(os.path.isdir("D:\\projectCode\\hqyj\\python_demo\\com\\thornBird"));

def fileSearch(dir, keyWord):
    dir = os.path.abspath(dir);
    for item in os.listdir(dir):
        sonDir = os.path.join(dir, item);
        if os.path.isdir(sonDir):
            fileSearch(sonDir, keyWord);
        else:
            if item.find(keyWord) != -1:
                print(sonDir);
fileSearch("D:\\projectCode\\hqyj\\python_demo\\com", "init");

print("cdsacdas".find("a"));

import pickle;
d = dict(name = "hymanHu", age = 20);
# pickle.dumps && pickle.loads
db = pickle.dumps(d);
print(db);
d2 = pickle.loads(db);
print(d2);
# pickle.dump && pickle.load
f = open("D:\\testDir\\test.txt", "wb");
pickle.dump(d, f);
f.close();
f = open("D:\\testDir\\test.txt", "rb");
d1 = pickle.load(f);
f.close();
print(d1);

# ---- Json 序列化和反序列化 ----
import json;
# json.dumps && json.loads
d = dict(name = "hymanHu1", age = 30);
dj = json.dumps(d);
print(dj);
d2 = json.loads(dj);
print(d2);
# json.dump && json.load
f = open("D:\\testDir\\test.txt", "w");
json.dump(d, f);
f.close();
f = open("D:\\testDir\\test.txt", "r");
d2 = json.load(f);
print(d2);

# 对象和Json互转
class Student(object):
    def __init__(self, name, age):
        self.name = name;
        self.age = age;
student = Student("JiangHu", 44);
def stu2Dict(stu):
    return {
        "name" : stu.name,
        "age" : stu.age
    };
def dict2Stu(d):
    return Student(d["name"], d["age"]);
# 方式一：转Json时传入自定义对象转dict函数
print(json.dumps(student, default=stu2Dict));
# 方式二：转Json时传入重写的object.__dict__函数
studentJson = json.dumps(student, default=lambda obj : obj.__dict__);
print(studentJson);
student2 = json.loads(studentJson, object_hook=dict2Stu);
print(student2.name, student2.age);

d = dict(name = "胡江", age = 30);
print(json.dumps(d, ensure_ascii=False));
print(json.dumps(d, ensure_ascii=True));

# import os;
# print("Process %s start" % os.getpid());
# childPId = os.fork();
# if childPId == 0:
#     print("I am child process(%s) and my parent is %s" % (os.getpid(), os.getppid()));
# else:
#     print("I(%s) just create child process, id is %s" % (os.getpid(), childPId));

# from multiprocessing import Process;
# import os;
#
# def processCall(name):
#     print("Run process %s(pid = %s)" % (name, os.getpid()));
# if __name__ == "__main__":
#     print("Parent Process is %s" % (os.getpid()));
#     # 创建进程实例，传入函数以及参数
#     childProcess = Process(target=processCall, args=("test",));
#     print("Child process start");
#     # 开始进程
#     childProcess.start();
#     # join()方法可以等待子进程结束后再继续往下运行，通常用于进程间的同步
#     childProcess.join();
#     print("Child process is end");
#
# from multiprocessing import Pool;
# import os, time, random;
#
# def logTime(processName):
#     print("Run task(%s), pid is %s" % (processName, os.getpid()));
#     start = time.time();
#     time.sleep(random.random() * 3);
#     end = time.time();
#     print("This task(%s) run %0.2f seconds" % (processName, (end - start)));
# if __name__ == "__main__":
#     print("Parent process is %s" % os.getpid());
#     pool = Pool(4);
#     for i in range(5):
#         pool.apply_async(logTime, args=("process" + str(i),));
#     print("Waiting all process done");
#     # close调用后不能再添加进程了
#     pool.close();
#     # join等待多个子进程执行完毕
#     pool.join();
#     print("All process done");
#
# import subprocess;
# print("$ nslookup www.baidu.com");
# r = subprocess.call(["nslookup", "www.baidu.com"]);
# print("Result:", r);

# from multiprocessing import Process, Queue;
# import os, time, random;
#
# def writeQueue(queue):
#     print("Process(%s) to write" % os.getpid());
#     for value in ["A", "B", "C"]:
#         print("Put %s into queue" % value);
#         queue.put(value);
#         time.sleep(random.random());
# def readQueue(queue):
#     print("Process(%s) to read" % os.getpid());
#     while True:
#         value = queue.get(True);
#         print("Read value %s from queue" % value);
# if __name__ == "__main__":
#     queue = Queue();
#     pw = Process(target=writeQueue, args=(queue,));
#     pr = Process(target=readQueue, args=(queue,));
#     pw.start();
#     pr.start();
#     # 等待pw进程结束
#     pw.join();
#     # pr进程里面是死循环，强行结束
#     pr.terminate();

# import threading, time;
#
# def loop():
#     print("Thread %s is running" % threading.current_thread().name);
#     for i in range(5):
#         print("Thread %s print number %d" % (threading.current_thread().name, i));
#         time.sleep(1);
#     print("Thread %s is end" % threading.current_thread().name);
#
# print("Thread %s is running" % threading.current_thread().name);
# loopThread = threading.Thread(target=loop, name="LoopThread");
# loopThread.start();
# loopThread.join();
# print("Thread %s is end" % threading.current_thread().name);

# import time, threading;
#
# # 银行存款余额
# balance = 0;
# # 获取线程锁
# lock = threading.Lock();
# def changeBalance(x):
#     # 函数内部对函数外的变量进行操作，就需要在函数内部声明其为global
#     global balance;
#     # 先存后取，balance期望值是0
#     balance = balance + x;
#     balance = balance - x;
# def bankTread(x):
#     for i in range(1000000):
#         # 未加锁的情况
#         # changeBalance(x);
#         # 加锁的情况
#         lock.acquire(); # 获取线程锁
#         try:
#             changeBalance(x);
#         finally:
#             lock.release(); # 释放锁
#
# thread1 = threading.Thread(target=bankTread, args=(4,), name="BankThread1");
# thread2 = threading.Thread(target=bankTread, args=(8,), name="BankThread2");
# thread1.start();
# thread2.start();
# thread1.join();
# thread2.join();
# print("The balance is %s" % balance);

# import threading, multiprocessing;
#
# def loop():
#     x = 0;
#     while True:
#         x = x ^ 1;
# for i in range(multiprocessing.cpu_count()):
#     thread = threading.Thread(target=loop);
#     thread.start();

# import threading;
#
# # 创建全局 ThreadLocal 变量
# localThreadStudent = threading.local();
#
# def threadMethod(name):
#     # 为每个线程修改 ThreadLocal 变量副本
#     localThreadStudent.name = name;
#     print("Thread %s student name %s" % (threading.current_thread().name, localThreadStudent.name));
#
# thread1 = threading.Thread(target=threadMethod, args=("HymanHu",), name="ThreadA");
# thread2 = threading.Thread(target=threadMethod, args=("JiangHu",), name="ThreadB");
# thread1.start();
# thread2.start();
# thread1.join();
# thread2.join();

import re;
# ---- 匹配字符串 ----
# 如果匹配成功，将返回一个Math对象，失败则返回None
test = "010-12345";
if re.match(r"^\d{3}\-\d{3,8}$", test):
    print("Ok");
else:
    print("Error");
# ---- 切分字符串 ----
# 如果使用str的split方法，无法识别连续空格
print(re.split(r"\s+", "a b   c"));
# 将匹配逗号、空格、分号
print(re.split(r"[\s\,\;]+", "a,b;; c   d"));
# ---- 分组 ----
m = re.match(r"^(\d{3})-(\d{3,8})$", "010-12345");
print(m.groups()); # ('010', '12345')
print(m.group(0)); # 010-12345
print(m.group(1)); # 010
print(m.group(2)); # 12345
# 分组提取时间
t = "19:05:30";
m = re.match(r"^(0[0-9]|1[0-9]|2[0-3]|[0-9])\:"
             r"(0[0-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0-9]|[0-9])\:"
             r"(0[0-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0-9]|[0-9])$", t);
print(m.groups());
# ---- 贪婪匹配 ----
print(re.match(r"^(\d+)(0*)$", "102300").groups()); # ('102300', '')
print(re.match(r"^(\d+?)(0*)$", "102300").groups()); # ('1023', '00')

emailReg = r'^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$';
emailNameReg = r'<?([^@|^>]*).*@.*';
print(re.match(emailReg, "hyman@163.com"));
print(re.match(emailReg, "bill.gates@microsoft.com"));
print(re.match(emailReg, "y_cat-st@example.com"));
print(re.match(emailNameReg, "<Tom Paris> tom@voyager.org").groups());
print(re.match(emailNameReg, "tom@voyager.org").groups());

from datetime import datetime, timedelta, timezone;

print(type(datetime.now()));
print(datetime.now()); # 2020-02-22 14:35:43.328559
print(datetime(2020, 2, 22, 13, 37, 55)); # 2020-02-22 13:37:55
# datetime和timestamp相互转化
print(datetime.now().timestamp()); # 1582353597.854907
# 以本地时区做转化
print(datetime.fromtimestamp(1582353597.854907)); # 2020-02-22 14:39:57.854907
# 以UTC标准时区做转化
print(datetime.utcfromtimestamp(1582353597.854907)); # 2020-02-22 06:39:57.854907
# datetime和字符串相互转化
print(datetime.strptime("2020-02-22 14:28:55", "%Y-%m-%d %H:%M:%S")); # 2020-02-22 14:28:55
print(datetime.now().strftime("%Y/%m/%d %H:%M:%S")); # 2020/02/22 14:50:45
# datetime 加减
print(datetime.now() + timedelta(days=1));
print(datetime.now() - timedelta(hours=10));
print(datetime.now() + timedelta(hours=1, minutes=10));
# datetime 设置时区
print(datetime.utcnow()); # utc标准时间
utcTime = datetime.now().replace(tzinfo=timezone.utc); # 拿到utc时间
print(utcTime); # 设置当前时间为utc标准时间
print(utcTime.astimezone(timezone(timedelta(hours=-8)))); # utc转西八区时间
print(utcTime.astimezone(timezone(timedelta(hours=8)))); # utc转东八区时间

from datetime import datetime, timedelta, timezone;
import re;

def transferToTimestamp(dateStr, timeZoneStr, formatStr):
    dt = datetime.strptime(dateStr, formatStr);
    print(dt);
    timeZoneGroup = re.match(r'^UTC(\+|-)([0-9]|1[0-2]|0[0-9]):00$', timeZoneStr).groups();
    print(timeZoneGroup);
    if timeZoneGroup[0] == "+":
        dt = dt.replace(tzinfo=timezone(timedelta(hours=int(timeZoneGroup[1]))));
        print(dt);
    else:
        db = dt.replace(tzinfo=timezone(timedelta(hours=-int(timeZoneGroup[1]))));
        print(dt);
    return dt.timestamp();
print(transferToTimestamp("2020-02-22 15:32:27", "UTC+8:00", "%Y-%m-%d %H:%M:%S"));

from collections import namedtuple;
Circle = namedtuple("Circle",["x", "y", "r"]);
Point = namedtuple("Point", ["x", "y"]);
p = Point(1, 2);
print(isinstance(p, Point), isinstance(p, tuple));
print(p.x, p.y);

from collections import deque;
d = deque(["x", "y", "z"]);
d.append("a");
d.appendleft("b")
print(isinstance(d, deque), isinstance(d, list));
print(d);

from collections import defaultdict;
d = defaultdict(lambda : "N/A");
d["key1"] = "aaa";
print(d["key1"], d["key2"]);

from collections import OrderedDict;
print(dict([('a', 1), ('c', 3), ('b', 2)]));
print(OrderedDict([('a', 1), ('c', 3), ('b', 2)]));
# OrderedDict可以实现一个FIFO（先进先出）的dict，当容量超出限制时，先删除最早添加的Key
class LastUpdatedOrderedDict(OrderedDict):
    def __init__(self, capacity):
        super(LastUpdatedOrderedDict, self).__init__()
        self._capacity = capacity
    def __setitem__(self, key, value):
        containsKey = 1 if key in self else 0
        if len(self) - containsKey >= self._capacity:
            last = self.popitem(last=False)
            print('remove:', last)
        if containsKey:
            del self[key]
            print('set:', (key, value))
        else:
            print('add:', (key, value))
        OrderedDict.__setitem__(self, key, value)

from collections import ChainMap
import os, argparse
# 构造缺省参数:
defaults = {
    'color': 'red',
    'user': 'guest'
}
# 构造命令行参数:
parser = argparse.ArgumentParser()
parser.add_argument('-u', '--user')
parser.add_argument('-c', '--color')
namespace = parser.parse_args()
command_line_args = { k: v for k, v in vars(namespace).items() if v }
# 组合成ChainMap:
combined = ChainMap(command_line_args, os.environ, defaults)
# 打印参数:
print('color=%s' % combined['color'])
print('user=%s' % combined['user'])

from collections import Counter;
c = Counter();
c.update("wwwwiiiiiffffllll")
print(c);
for ch in "cdsajdfkdakasjdsakdsdsa":
    c[ch] = c[ch] + 1;
print(c);

import base64;
print(base64.b64encode(b'binary\x00string'));
print(base64.b64decode(b'YmluYXJ5AHN0cmluZw=='));
print(base64.urlsafe_b64encode(b'i\xb7\x1d\xfb\xef\xff'));
print(base64.urlsafe_b64decode('abcd--__'));

import struct;
# >表示字节顺序是big-endian，也就是网络序
# I表示4字节无符号整数，H表示2字节无符号整数
# pack将其他类型转bytes
print(struct.pack(">I", 1024)); # b'\x00\x00\x04\x00'
print(struct.pack(">H", 1024)); # b'\x04\x00'
# pack将bytes转换回去
print(struct.unpack(">I", b'\x00\x00\x04\x00')); # (1024,)
print(struct.unpack(">H", b'\x04\x00')); # (1024,)
# 指令两个，共6字节，那么后面参数需要提供6字节
print(struct.unpack(">IH", b'\x00\x00\x04\x00\x04\x00')); # (1024, 1024)

import hashlib;
md5 = hashlib.md5();
md5.update("Hello World!".encode("utf-8"));
# 结果32位的16进制字符串
print(md5.hexdigest()); # ed076287532e86365e841e92bfc50d8c
sha1 = hashlib.sha1();
sha1.update("Hello World!".encode("utf-8"));
# 结果40位的16进制字符串
print(sha1.hexdigest()); # 2ef7bde608ce5404e97d5f042f95f89f1c232871
# 根据用户输入用户名和密码模拟登陆
import hashlib, random;

def getMd5(s):
    return hashlib.md5(s.encode("utf-8")).hexdigest();
class User(object):
    def __init__(self, userName, password):
        self.userName = userName;
        self.salt = userName + "acj/cdsa_cdsa"
        self.password = getMd5(password + self.salt);
db = {
    'michael': User('michael', '123456'),
    'bob': User('bob', 'abc999'),
    'alice': User('alice', 'alice2008')
};
def login(userName, password):
    user = db[userName];
    return user.password == User(userName, password).password;

import hmac;
message = "HymanHu".encode("utf-8");
key = "hujiang@111".encode("utf-8");
h = hmac.new(key, message, digestmod="md5");
print(h.hexdigest());

import itertools;

natuals = itertools.count(1);
ns = itertools.takewhile(lambda x : x <= 10, natuals);
print(list(ns));
print(list(itertools.chain("asd", "cda")));
for key, group in itertools.groupby("aaaabbbbccccdddd"):
    print(key, list(group));

import itertools;

def pi(n):
    # step 1: 创建一个奇数序列: 1, 3, 5, 7, 9, ...
    odd = itertools.count(start=1, step=2);
    # step 2: 取该序列的前N项: 1, 3, 5, 7, 9, ..., 2*N-1.
    oddList = list(itertools.takewhile(lambda x : x <= 2 * n - 1, odd));
    # step 3: 添加正负符号并用4除: 4/1, -4/3, 4/5, -4/7, 4/9, ...
    # oddList = [4 / (((-1) ** (x // 2)) * x) for x in oddList];
    # step 4: 求和，使用reduce、map函数，整合三四步
    return reduce(lambda x, y : x + y, map(lambda x : 4 / (((-1) ** (x // 2)) * x), oddList));
print(pi(10));
print(pi(100));
print(pi(1000));
print(pi(10000));

from contextlib import contextmanager;

class Query(object):
    def __init__(self, name):
        self.name = name;
    def query(self):
        print("Query %s" % self.name);
# 该装饰器类似一个构造器,
'''
执行结果可见，yield把Query对象嵌入进来执行，
但是方法本身的打印语句也会执行
除了可用with语句外，还有Test中before、after的功能
'''
@contextmanager
def creatQuery(name):
    print("start")
    yield Query(name);
    print("end")

with creatQuery("HymanHu") as q:
    q.query();

# from contextlib import closing;
# from urllib.request import urlopen;
#
# with closing(urlopen("http://www.baidu.com")) as page:
#     for line in page:
#         print(line);

# from urllib import request;
#
# with request.urlopen("http://www.baidu.com") as f:
#     # 打印页面状态
#     print("Status:", f.status, f.reason);
#     data = f.read();
#     # 获取页面响应头信息
#     for key, value in f.getheaders():
#         print("%s - %s" % (key, value));
#     # 获取页面信息
#     # print("data:", data.decode("utf-8"));

# from urllib import request;

# 模拟iPhone 6去请求百度主页
# req = request.Request("http://www.baidu.com");
# req.add_header('User-Agent', 'Mozilla/6.0 (iPhone; CPU iPhone OS 8_0 like Mac OS X) '
#     'AppleWebKit/536.26 (KHTML, like Gecko) Version/8.0 Mobile/10A5376e Safari/8536.25')
# with request.urlopen(req) as f:
#     print("Status:", f.status, f.reason);
#     data = f.read();
#     for key, value in f.getheaders():
#         print("%s - %s" % (key, value));

# from urllib import request, parse;
#
# print("Login weibo.cn");
# email_package = input("Email:");
# password = input("Password:");
# loginData = parse.urlencode([
#     ("username", email_package),
#     ("password", password),
#     ('entry', 'mweibo'),
#     ('client_id', ''),
#     ('savestate', '1'),
#     ('ec', ''),
#     ('pagerefer', 'https://passport.weibo.cn/signin/welcome?entry=mweibo&r=http%3A%2F%2Fm.weibo.cn%2F')
# ]);
# req = request.Request("https://passport.weibo.cn/sso/login");
# req.add_header('Origin', 'https://passport.weibo.cn');
# req.add_header('User-Agent', 'Mozilla/6.0 (iPhone; CPU iPhone OS 8_0 like Mac OS X) '
#     'AppleWebKit/536.26 (KHTML, like Gecko) Version/8.0 Mobile/10A5376e Safari/8536.25');
# req.add_header('Referer', 'https://passport.weibo.cn/signin/login?'
#     'entry=mweibo&res=wel&wm=3349&r=http%3A%2F%2Fm.weibo.cn%2F');
#
# with request.urlopen(req, data=loginData.encode("utf-8")) as f:
#     print('Status:', f.status, f.reason);
#     for k, v in f.getheaders():
#         print('%s: %s' % (k, v));
#     print('Data:', f.read().decode('utf-8'));

# from urllib import request;
# import urllib;
#
# proxyHandle = urllib.request.ProxyHandler({'http': 'http://www.example.com:3128/'});
# proxyAuthHandler = urllib.request.ProxyBasicAuthHandler();
# proxyAuthHandler.add_password('realm', 'host', 'username', 'password');
# opener = urllib.request.build_opener(proxyHandle, proxyAuthHandler);
# with opener.open('http://www.example.com/login.html') as f:
#     pass

# https://yesno.wtf/api

# from urllib import request;
# import json;
#
# def fetchJsonData(url):
#     with request.urlopen(str(url)) as f:
#         data = f.read().decode("utf-8");
#         return json.loads(data);
#
# print(fetchJsonData("https://yesno.wtf/api"));

xml = r'''<?xml version="1.0"?>
<ol>
    <li><a href="/python">Python</a></li>
    <li><a href="/ruby">Ruby</a></li>
</ol>
''';
from xml.parsers.expat import ParserCreate;

class DefaultSaxHandler(object):
    def startElement(self, name, attrs):
        print("sax:start element: %s, attrs: %s" % (name, attrs));
    def endElements(self, name):
        print("sax:end element: %s" % name);
    def charData(self, text):
        print("sax:char data: %s" % text);

# ---- 解析xml ----
handler = DefaultSaxHandler();
parser = ParserCreate();
parser.StartElementHandler = handler.startElement;
parser.EndElementHandler = handler.endElements;
parser.CharacterDataHandler = handler.charData;
print(parser.Parse(xml));

# ---- 生成xml ----
l = [];
l.append(r'<?xml version="1.0"?>');
l.append(r'<root>');
l.append(r'some & data');
l.append(r'</root>');
print(''.join(l));

# 解析XML格式的天气预报
# http://flash.weather.com.cn/wmaps/xml/beijing.xml
from xml.parsers.expat import ParserCreate;
from urllib import request;

class WeatherSaxHandler(object):
    def __init__(self, cityNmae):
        self.cityName = cityNmae;
    # 初始化天气变量，city城市名，regions该城市下地区，forecast，该城市下地区预报
    weather = {"city": "", "regions" : [], "forecast" : []};
    def startElement(self, name, attrs):
        if name == self.cityName:
            self.weather["city"] = self.cityName;
        else:
            # 包装regions信息
            self.weather["regions"].append(attrs["cityname"]);
            # 包装forecast信息
            self.weather["forecast"].append({
                "state" : attrs["stateDetailed"],
                "low": attrs["tem2"],
                "high" : attrs["tem1"]

            });
# 转化xml结果，并返回weather
def parseXml(cityNmae, xmlStr):
    handler = WeatherSaxHandler(cityNmae);
    parser = ParserCreate();
    parser.StartElementHandler = handler.startElement;
    parser.Parse(xmlStr);
    print("City", handler.weather["city"]);
    for x, y in zip(handler.weather["regions"], handler.weather["forecast"]):
        print("Region: ", x);
        print(y);
    return handler.weather;
# 获取天气api数据
with request.urlopen("http://flash.weather.com.cn/wmaps/xml/chengdu.xml", timeout=4) as f:
    parseXml("chengdu", f.read());

from html.parser import HTMLParser;
from html.entities import name2codepoint;

class MyHtmlParser(HTMLParser):
    def handle_starttag(self, tag, attrs):
        print('<%s>' % tag);
    def handle_endtag(self, tag):
        print('</%s>' % tag);
    def handle_startendtag(self, tag, attrs):
        print('<%s/>' % tag);
    def handle_data(self, data):
        print(data);
    def handle_comment(self, data):
        print('<!--', data, '-->');
    def handle_entityref(self, name):
        print('&%s;' % name);
    def handle_charref(self, name):
        print('&#%s;' % name);
parser = MyHtmlParser();
print(parser.feed('''<html>
<head></head>
<body>
<!-- test html parser -->
    <p>Some <a href=\"#\">html</a> HTML&nbsp;tutorial...<br>END</p>
</body></html>'''));

from html.parser import HTMLParser;
from urllib import request;
from datetime import datetime;
import re;

class MyHtmlParser(HTMLParser):
    # 定义meeting相关的标签dict，设置标记好接收数据
    meetingTags = {'h3':0, 'time':0, 'span':0};
    # 定义接收变量{'名称':[],'时间':[],'地点':[]}
    meeting = {"name":[], "time":[], "address":[]};
    # 解析标签，设置meeting相关的tags标记，如果数据在标签属性中，则直接装数据
    def handle_starttag(self, tag, attrs):
        if tag == "h3" and "class" in attrs and attrs["class"] == "event-title":
            self.meeting["name"] = 1;
        if tag == "time" and "datetime" in attrs:
            self.meeting["time"].append(datetime.strptime(attrs['datetime'][:-6], '%Y-%m-%dT%H:%M:%S'));
        if tag == "span" and "class" in attrs and attrs["class"] == "event-location":
            self.meetingTags["span"] = 1;
    # 解析数据，根据已经设置好的meeting tags来装数据
    def handle_data(self, data):
        if self.meetingTags["h3"] == 1:
            self.meeting["name"].append(data);
            self.meetingTags["h3"] == 0;
        if self.meetingTags["span"] == 1:
            self.meeting["address"].append(data);
            self.meetingTags["spqn"] == 0;
    # 打印meeting信息
    def printMeeting(self):
        for name, time, address in zip(self.meeting["name"], self.meeting["time"], self.meeting["address"]):
            print(name, time, address);

def parseHtml(htmlStr):
    parser = MyHtmlParser();
    parser.feed(htmlStr);
    parser.printMeeting();

with request.urlopen("https://www.python.org/events/python-events/", timeout=4) as f:
    print(f.read().decode("utf-8"));
    # parseHtml(f.read().decode("utf-8"));

from html.parser import HTMLParser;
from urllib import request;
from datetime import datetime;


class MyHtmlParser(HTMLParser):
    # 定义meeting相关的标签dict，设置标记好接收数据
    meetingTag = "";
    # 定义接收变量{'名称':[],'时间':[],'地点':[]}
    meeting = {"name": [], "time": [], "address": []};

    # 解析标签，设置meeting相关的tags标记，如果数据在标签属性中，则直接装数据
    def handle_starttag(self, tag, attrs):
        attrs = dict(attrs);
        if tag == 'h3' and 'class' in attrs and attrs["class"] == "event-title":
            self.meetingTag = "h3";
        if tag == "time" and "datetime" in attrs:
            self.meetingTag = "time";
            self.meeting["time"].append(datetime.strptime(attrs['datetime'][:-6], '%Y-%m-%dT%H:%M:%S'));
        if tag == "span" and "class" in attrs and attrs["class"] == "event-location":
            self.meetingTag = "address";

    # 标签结束，将标签置空
    def handle_endtag(self, tag):
        meetingTag = "";

    # 解析数据，根据已经设置好的meeting tags来装数据
    def handle_data(self, data):
        if self.meetingTag == "h3":
            if len(data.strip()) > 0:
                self.meeting["name"].append(data);
        if self.meetingTag == "address":
            if len(data.strip()) > 0:
                self.meeting["address"].append(data);

    # 打印meeting信息
    def printMeeting(self):
        for name, time, address in zip(self.meeting["name"], self.meeting["time"], self.meeting["address"]):
            print(name, "----", time, "----", address);


def parseHtml(htmlStr):
    parser = MyHtmlParser();
    parser.feed(htmlStr);
    parser.printMeeting();


# with request.urlopen("https://www.python.org/events/python-events/", timeout=40) as f:
# print(f.read().decode("utf-8"));
# parseHtml(f.read().decode("utf-8"));

htmlStr = r'''
<div class="most-recent-events">
	<div class="shrubbery">
		<h2 class="widget-title"><span aria-hidden="true" class="icon-calendar"></span>Upcoming Events</h2>
		<p class="give-me-more"><a href="?page=2" title="More Events">More</a></p>
		<ul class="list-recent-events menu">
			<li>
				<h3 class="event-title"><a href="/events/python-events/896/">HackBVICAM National Student’s Convention 2k20</a></h3>
				<p>
					<time datetime="2020-03-13T00:00:00+00:00">13 March<span class="say-no-more"> 2020</span></time>
					<span class="event-location">New Delhi, India</span>
				</p>
			</li>
			<li>
				<h3 class="event-title"><a href="/events/python-events/902/">MoscowPythonConf++</a></h3>
				<p>
					<time datetime="2020-03-27T00:00:00+00:00">27 March<span class="say-no-more"> 2020</span></time>
					<span class="event-location">Moscow, Russia</span>
				</p>
			</li>
			<li>
				<h3 class="event-title"><a href="/events/python-events/879/">PyCon SK 2020</a></h3>
				<p>
					<time datetime="2020-03-27T00:00:00+00:00">27 March – 29 March <span class="say-no-more"> 2020</span></time>
					<span class="event-location">Bratislava, Slovakia</span>
				</p>
			</li>

			<li>
				<h3 class="event-title"><a href="/events/python-events/884/">PyCon Italia 2020</a></h3>
				<p>
					<time datetime="2020-04-02T00:00:00+00:00">02 April – 05 April <span class="say-no-more"> 2020</span></time>
					<span class="event-location">Florence, Italy</span>
				</p>
			</li>
		</ul>
	</div>	
</div>
'''
parseHtml(htmlStr);

a = int(3.14); # int函数在内建作用域
__name = "HymanHu"; #全局作用域
def fun():
    name = "JiangHu"; # 闭包函数外的函数域
    def fun2():
        name = "Hawkist"; # 局部作用域
fun();