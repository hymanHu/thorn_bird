#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
pyecharts test
'''

import random;
from pyecharts.faker import Faker;
from pyecharts import options as opts;
from pyecharts.charts import Bar, Bar3D, Line, Line3D, Pie, Map, Geo, Funnel, Grid, Tab, Page;

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
    # 构造一个二维数组，[(key, value),...]
    print(list(z for z in zip(Faker.choose(), Faker.values(1, 20))));
    print([list(z) for z in zip(Faker.choose(), Faker.values())]);
    # 构造三维数组，[(x, y, z),...]
    print(list((x, y, random.randint(1, 100)) for x in range(1, 10) for y in range(1, 20)));

# 柱状图
def bar_fun():
    Bar().add_xaxis(
        # 添加 x 轴数据
        Faker.choose()
    ).add_yaxis(
        # 添加 y 轴数据，并设置属性
        series_name="柱1", y_axis=Faker.values(1, 100), itemstyle_opts=opts.ItemStyleOpts(color=Faker.rand_color())
    ).add_yaxis(
        # 添加 y 轴数据，并设置属性
        series_name="柱2", y_axis=Faker.values(1, 100), itemstyle_opts=opts.ItemStyleOpts(color=Faker.rand_color())
    ).set_global_opts(
        # 设置图表属性
        title_opts = opts.TitleOpts(title="主标题", subtitle="副标题", pos_left="10%"),
         # 设置 series_name 位置
         legend_opts = opts.LegendOpts(pos_left="40%"),
    ).render(
        # 设置输出路径
        path="D:/temp/pyecharts_bar.html"
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
        path="D:/temp/pyecharts_bar3d.html"
    );

# 折线图
def line_fun():
    Line().add_xaxis(
        # 添加 x 轴数据
        Faker.choose()
    ).add_yaxis(
        # 添加 y 轴数据，并设置属性
        series_name="xx1", y_axis=Faker.values(1, 100), itemstyle_opts=opts.ItemStyleOpts(color=Faker.rand_color())
    ).add_yaxis(
        # 添加 y 轴数据，并设置属性
        series_name="xx2", y_axis=Faker.values(1, 100), itemstyle_opts=opts.ItemStyleOpts(color=Faker.rand_color())
    ).set_global_opts(
        title_opts=opts.TitleOpts(title="主标题", subtitle="副标题", pos_left="10%"),
        # 设置 series_name 位置
        legend_opts=opts.LegendOpts(pos_left="40%"),
    ).render(
        # 设置输出路径
        path="D:/temp/pyecharts_line.html"
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
        path="D:/temp/pyecharts_line3d.html"
    );

# 饼图
def pie_fun():
    Pie().add(
        series_name="饼图名称",
        # 数据格式[[key, value], [key, value], ...], 用 zip 函数将两个 list 进行组合
        data_pair=[list(z) for z in zip(Faker.choose(), Faker.values())],
        # 饼图半径，一个值表示圆半径，两个值表示内外圆半径
        # radius="40%",
        # radius=["40%", "55%"],
        # 中心点的 x、y 位置
        center=["50%", "50%"],
        # 是否展示成南丁格尔图（玫瑰图），通过半径区分数据大小，有 radius 和 area 两种模式
        # radius：扇区圆心角展现数据的百分比，半径展现数据的大小
        # area：所有扇区圆心角相同，仅通过半径展现数据大小
        rosetype="area",
    ).set_series_opts(
        label_opts=opts.LabelOpts(
            formatter="{b}: {c}",
            color=Faker.rand_color(),
        )
    ).set_global_opts(
        title_opts=opts.TitleOpts(title="主标题", subtitle="副标题", pos_left="10%", pos_top="10%"),
        # 设置 series_name 位置
        legend_opts=opts.LegendOpts(pos_left="30%", pos_top="10%"),
    ).render(
        # 设置输出路径
        path="D:/temp/pyecharts_pie.html"
    );

# 地图
def map_fun():
    Map().add(
        series_name="全国疫情数据",
        data_pair=[list(z) for z in zip(Faker.provinces, Faker.values())],
        maptype="china"
    ).set_series_opts(
        label_opts=opts.LabelOpts(
            #formatter="{b}: {c}",
            color=Faker.rand_color(),
        )
    ).set_global_opts(
        title_opts=opts.TitleOpts(title="主标题", subtitle="副标题", pos_left="10%", pos_top="10%"),
        # 设置 series_name 位置
        legend_opts=opts.LegendOpts(pos_left="30%", pos_top="10%"),
        # Map 视觉效果
        visualmap_opts=opts.VisualMapOpts(),
    ).render(
        # 设置输出路径
        path="D:/temp/pyecharts_map.html"
    );
    Geo().add_schema(maptype="china").add(
        series_name="全国疫情数据",
        data_pair=[list(z) for z in zip(Faker.provinces, Faker.values())],
    ).set_series_opts(
        label_opts=opts.LabelOpts(
            formatter="{b}: {c}",
            color=Faker.rand_color(),
        )
    ).set_global_opts(
        title_opts=opts.TitleOpts(title="主标题", subtitle="副标题", pos_left="10%", pos_top="10%"),
        # 设置 series_name 位置
        # legend_opts=opts.LegendOpts(pos_left="30%", pos_top="10%"),
        # Geo 视觉效果
        visualmap_opts=opts.VisualMapOpts(),
    ).render(
        # 设置输出路径
        path="D:/temp/pyecharts_geo.html"
    );

# 漏斗图
def funnel_fun():
    Funnel().add(
        series_name="漏斗图",
        data_pair=[list(z) for z in zip(Faker.choose(), Faker.values())],
        # 数据排序，可以取 'ascending'，'descending'，'none'（表示按 data 顺序）
        sort_="ascending",
        label_opts=opts.LabelOpts(position="inside"),
    ).set_global_opts(
        title_opts=opts.TitleOpts(title="主标题", subtitle="副标题", pos_left="10%", pos_top="10%"),
        # 设置 series_name 位置
        # legend_opts=opts.LegendOpts(pos_left="30%", pos_top="10%"),
        # 工具栏
        toolbox_opts=opts.ToolboxOpts(),
    ).render(
        # 设置输出路径
        path="D:/temp/pyecharts_funnel.html"
    );

# 选项卡
def tab_fun():
    line = Line().add_xaxis(
        Faker.choose()
    ).add_yaxis(
        series_name="xx1", y_axis=Faker.values(1, 100), itemstyle_opts=opts.ItemStyleOpts(color=Faker.rand_color())
    ).add_yaxis(
        series_name="xx2", y_axis=Faker.values(1, 100), itemstyle_opts=opts.ItemStyleOpts(color=Faker.rand_color())
    ).set_global_opts(
        title_opts=opts.TitleOpts(title="主标题", subtitle="副标题", pos_left="10%"),
        legend_opts=opts.LegendOpts(pos_left="40%"),
    );
    bar = Bar().add_xaxis(
        Faker.choose()
    ).add_yaxis(
        series_name="柱1", y_axis=Faker.values(1, 100), itemstyle_opts=opts.ItemStyleOpts(color=Faker.rand_color())
    ).add_yaxis(
        series_name="柱2", y_axis=Faker.values(1, 100), itemstyle_opts=opts.ItemStyleOpts(color=Faker.rand_color())
    ).set_global_opts(
        title_opts=opts.TitleOpts(title="主标题", subtitle="副标题", pos_left="10%"),
        legend_opts=opts.LegendOpts(pos_left="40%"),
    );

    Tab().add(
        chart=line, tab_name="选项卡一"
    ).add(
        chart=bar, tab_name="选项卡二"
    ).render(path="D:/temp/pyecharts_tab.html");

# 组合图表
def grid_fun():
    line1 = Line().add_xaxis(
        Faker.choose()
    ).add_yaxis(
        series_name="xx1", y_axis=Faker.values(1, 100), itemstyle_opts=opts.ItemStyleOpts(color=Faker.rand_color())
    ).add_yaxis(
        series_name="xx2", y_axis=Faker.values(1, 100), itemstyle_opts=opts.ItemStyleOpts(color=Faker.rand_color())
    ).set_global_opts(
        title_opts=opts.TitleOpts(title="主标题_1", subtitle="副标题_1", pos_left="5%"),
        legend_opts=opts.LegendOpts(pos_left="20%"),
    );

    line2 = Line().add_xaxis(
        Faker.choose()
    ).add_yaxis(
        series_name="oo1", y_axis=Faker.values(1, 100), itemstyle_opts=opts.ItemStyleOpts(color=Faker.rand_color())
    ).add_yaxis(
        series_name="oo2", y_axis=Faker.values(1, 100), itemstyle_opts=opts.ItemStyleOpts(color=Faker.rand_color())
    ).set_global_opts(
        title_opts=opts.TitleOpts(title="主标题_2", subtitle="副标题_2", pos_left="55%"),
        legend_opts=opts.LegendOpts(pos_left="65%"),
    );

    bar = Bar().add_xaxis(
        Faker.choose()
    ).add_yaxis(
        series_name="柱1", y_axis=Faker.values(1, 100), itemstyle_opts=opts.ItemStyleOpts(color=Faker.rand_color())
    ).add_yaxis(
        series_name="柱2", y_axis=Faker.values(1, 100), itemstyle_opts=opts.ItemStyleOpts(color=Faker.rand_color())
    ).set_global_opts(
        title_opts=opts.TitleOpts(title="主标题", subtitle="副标题", pos_left="5%", pos_top="40%"),
        legend_opts=opts.LegendOpts(pos_left="20%", pos_top="40%"),
    );

    pie = Pie().add(
        series_name="饼图名称",
        data_pair=[list(z) for z in zip(Faker.choose(), Faker.values())],
        radius="40%",
        center = ["75%", "75%"],
    ).set_series_opts(
        label_opts=opts.LabelOpts(
            formatter="{b}: {c}",
            color=Faker.rand_color(),
        )
    ).set_global_opts(
        title_opts=opts.TitleOpts(title="主标题", subtitle="副标题", pos_left="55%", pos_top="40%"),
        legend_opts=opts.LegendOpts(pos_left="60%", pos_top="45%"),
    );

    Grid(init_opts=opts.InitOpts(width="1200px", height="500px")).add(
        line1,
        grid_opts=opts.GridOpts(width="40%", height="20%",pos_left="5%"),
    ).add(
        line2,
        grid_opts=opts.GridOpts(width="40%", height="20%", pos_left="55%"),
    ).add(
        bar,
        grid_opts=opts.GridOpts(width="40%", height="20%", pos_left="5%", pos_top="65%"),
    ).add(
        pie,
        grid_opts=opts.GridOpts(),
    ).render(path="D:/temp/pyecharts_grid.html");

# 组合图表（可拖动）
def page_fun():
    line = Line().add_xaxis(
        Faker.choose()
    ).add_yaxis(
        series_name="xx1", y_axis=Faker.values(1, 100), itemstyle_opts=opts.ItemStyleOpts(color=Faker.rand_color())
    ).add_yaxis(
        series_name="xx2", y_axis=Faker.values(1, 100), itemstyle_opts=opts.ItemStyleOpts(color=Faker.rand_color())
    ).set_global_opts(
        title_opts=opts.TitleOpts(title="主标题", subtitle="副标题", pos_left="10%"),
        legend_opts=opts.LegendOpts(pos_left="40%"),
    );
    bar = Bar().add_xaxis(
        Faker.choose()
    ).add_yaxis(
        series_name="柱1", y_axis=Faker.values(1, 100), itemstyle_opts=opts.ItemStyleOpts(color=Faker.rand_color())
    ).add_yaxis(
        series_name="柱2", y_axis=Faker.values(1, 100), itemstyle_opts=opts.ItemStyleOpts(color=Faker.rand_color())
    ).set_global_opts(
        title_opts=opts.TitleOpts(title="主标题", subtitle="副标题", pos_left="10%"),
        legend_opts=opts.LegendOpts(pos_left="40%"),
    );
    pie = Pie().add(
        series_name="饼图名称",
        data_pair=[list(z) for z in zip(Faker.choose(), Faker.values())],
    ).set_series_opts(
        label_opts=opts.LabelOpts(
            formatter="{b}: {c}",
            color=Faker.rand_color(),
        )
    ).set_global_opts(
        title_opts=opts.TitleOpts(title="主标题", subtitle="副标题", pos_left="10%", pos_top="10%"),
        legend_opts=opts.LegendOpts(pos_left="30%", pos_top="10%"),
    );
    map = Map().add(
        series_name="全国疫情数据",
        data_pair=[list(z) for z in zip(Faker.provinces, Faker.values())],
        maptype="china"
    ).set_series_opts(
        label_opts=opts.LabelOpts(
            color=Faker.rand_color(),
        )
    ).set_global_opts(
        title_opts=opts.TitleOpts(title="主标题", subtitle="副标题", pos_left="10%", pos_top="10%"),
        legend_opts=opts.LegendOpts(pos_left="30%", pos_top="10%"),
        visualmap_opts=opts.VisualMapOpts(),
    );

    # 首先用 Page 生成可拖动的多图表页面
    # Page(layout=Page.DraggablePageLayout).add(
    #     line, bar, pie, map
    # ).render(path="D:/temp/pyecharts_page.html");
    # 打开多图表页面，拖动图表到合适的位置，保存设置为 json 文件
    # 指定原始文件、配置文件和输出文件，生成拖动后的多图表文件
    Page.save_resize_html(
        source="D:/temp/pyecharts_page.html",
        cfg_file="D:/temp/chart_config.json",
        dest="D:/temp/pyecharts_page_resize.html"
    );

if __name__ == "__main__":
    line_fun();
    bar_fun();
    pie_fun();
    map_fun();
    funnel_fun();
    tab_fun();
    grid_fun();
    page_fun();
