#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
pyecharts test
'''

import random;
from pyecharts.faker import Faker;
from pyecharts import options as opts;
from pyecharts.charts import Bar, Bar3D, Line, Line3D, Pie;

# 测试数据接口
def faker_fun():
    # 随机一个字符串列表，星期 or 动物 or 饮料 等
    print(Faker.choose());
    # 随机一个数值列表
    print(Faker.values(1, 100));
    # 随机一个国家列表
    print(Faker.country);
    # 随机汽车列表
    print(Faker.cars);
    # 随机颜色列表
    print(Faker.visual_color);

# 柱状图
def bar_fun():
    Bar().add_xaxis(
        # 添加 x 轴数据
        Faker.choose()
    ).add_yaxis(
        # 添加 y 轴数据，并设置属性
        "柱1", Faker.values(1, 100), itemstyle_opts=opts.ItemStyleOpts(color=Faker.rand_color())
    ).add_yaxis(
        # 添加 y 轴数据，并设置属性
        "柱2", Faker.values(1, 100), itemstyle_opts=opts.ItemStyleOpts(color=Faker.rand_color())
    ).set_global_opts(
        # 设置图表属性
        title_opts=opts.TitleOpts(title="主标题", subtitle="副标题")
    ).render(
        # 设置输出路径
        path="D:/temp/bar.html"
    );

# 柱状 3D 图
def bar_3d_fun():
    # 三维数据，定义 x、y 长度，z 数值随机
    data = [(i, j, random.randint(1, 20)) for i in range(7) for j in range(10)];
    print(len(data), data);
    Bar3D().add(
        # 添加 x、y、z 轴数据，并设置属性
        series_name="",
        data=data,
        xaxis3d_opts=opts.Axis3DOpts(Faker.choose(), type_="category"),
        yaxis3d_opts=opts.Axis3DOpts(Faker.choose(), type_="category"),
        zaxis3d_opts=opts.Axis3DOpts(Faker.values(), type_="value"),
        # 添加旋转效果
        grid3d_opts=opts.Grid3DOpts(
            width=100, depth=100, rotate_speed=150, is_rotate=True
        ),
    ).set_global_opts(
        # 设置图表属性
        # 视觉配置
        visualmap_opts=opts.VisualMapOpts(max_=20),
        title_opts=opts.TitleOpts(title="主标题", subtitle="副标题")
    ).render(
        # 设置输出路径
        path="D:/temp/bar3d.html"
    );

# 折线图
def line_fun():
    Line().add_xaxis(
        # 添加 x 轴数据
        Faker.choose()
    ).add_yaxis(
        # 添加 y 轴数据，并设置属性
        "线1", Faker.values(1, 100), itemstyle_opts=opts.ItemStyleOpts(color=Faker.rand_color())
    ).add_yaxis(
        # 添加 y 轴数据，并设置属性
        "线2", Faker.values(1, 100), itemstyle_opts=opts.ItemStyleOpts(color=Faker.rand_color())
    ).set_global_opts(
        # 设置图表属性
        title_opts=opts.TitleOpts(title="主标题", subtitle="副标题")
    ).render(
        # 设置输出路径
        path="D:/temp/line.html"
    );

# 折线 3D 图
def line_3d_fun():
    # 三维数据，定义 x、y 长度，z 数值随机
    data = [(i, j, random.randint(1, 20)) for i in range(7) for j in range(10)];
    print(len(data), data);
    Line3D().add(
        # 添加 x、y、z 轴数据，并设置属性
        series_name="",
        data=data,
        xaxis3d_opts=opts.Axis3DOpts(Faker.choose(), type_="value"),
        yaxis3d_opts=opts.Axis3DOpts(Faker.choose(), type_="value"),
        zaxis3d_opts=opts.Axis3DOpts(Faker.values(), type_="value"),
        # 添加旋转效果
        grid3d_opts=opts.Grid3DOpts(
            width=100, depth=100, rotate_speed=150, is_rotate=True
        ),
    ).set_global_opts(
        # 设置图表属性
        # 视觉配置
        visualmap_opts=opts.VisualMapOpts(max_=20),
        title_opts=opts.TitleOpts(title="主标题", subtitle="副标题")
    ).render(
        # 设置输出路径
        path="D:/temp/line3d.html"
    );

# 饼图
def pie_fun():
    # 数据格式[(key, value), (key, value), ...], 用 zip 函数将两个 list 进行组合
    data =  [list(z) for z in zip(Faker.choose(), Faker.values())];
    print(data);
    Pie().add(
        series_name="",
        data_pair=data,
    ).set_global_opts(
        # 设置图表属性
        title_opts=opts.TitleOpts(title="主标题", subtitle="副标题")
    ).set_series_opts(
        # 设置 label 显示样式
        label_opts=opts.LabelOpts(
            formatter="{b}: {c}",
            color=Faker.rand_color(),
        )
    ).render(
        # 设置输出路径
        path="D:/temp/pie.html"
    );

if __name__ == "__main__":
    # faker_fun();
    # bar_fun();
    # bar_3d_fun();
    # line_fun();
    # line_3d_fun();
    pie_fun();
