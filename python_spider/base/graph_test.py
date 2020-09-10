#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
graph test
'''

import plotly;

def draw_line_graph():
    # 准备图轨数据
    trace_1 = plotly.graph_objs.Scatter(
        x=[1, 2, 3, 4],
        y=[32, 44, 11, 66],
        name="散点图",
        mode="markers"
    );
    trace_2 = plotly.graph_objs.Scatter(
        x=[1, 2, 3, 4],
        y=[13, 45, 21, 74],
        name="折线图"
    );
    line_data = [trace_1, trace_2];
    # 设置画布布局
    layout = plotly.graph_objs.Layout(title="折线图测试", xaxis={"title": "x"}, yaxis={"title": "y"});
    # 融合图轨数据和布局
    figure = plotly.graph_objs.Figure(data=line_data, layout=layout);
    #输出
    plotly.offline.plot(figure, filename="/temp/line_graph.html", image="png");

def draw_bar_graph():
    # 准备图轨数据
    trace_1 = plotly.graph_objs.Bar(
        x=[1, 2, 3, 4],
        y=[32, 44, 11, 66],
        name="第一产业"
    );
    trace_2 = plotly.graph_objs.Bar(
        x=[1, 2, 3, 4],
        y=[36, 23, 18, 54],
        name="第二产业"
    );
    trace_3 = plotly.graph_objs.Bar(
        x=[1, 2, 3, 4],
        y=[54, 34, 26, 17],
        name="第三产业"
    );
    bar_data = [trace_1, trace_2, trace_3];

    # 设置画布布局
    layout = plotly.graph_objs.Layout(title="柱状图测试", xaxis={"title": "季度"}, yaxis={"title": "产值"});
    # 融合图轨数据和布局
    figure = plotly.graph_objs.Figure(data=bar_data, layout=layout);
    # 输出
    plotly.offline.plot(figure, filename="/temp/bar_graph.html", image="png");

def draw_pie_graph():
    # 准备图轨数据
    trace_1 = plotly.graph_objs.Pie(
        labels=["产品一","产品二","产品三","产品四","产品五"],
        values=[13.4, 24.6, 33.2, 76.2, 65.5]
    );
    pie_data = [trace_1];

    # 设置画布布局
    layout = plotly.graph_objs.Layout(title="饼图测试");
    # 融合图轨数据和布局
    figure = plotly.graph_objs.Figure(data=pie_data, layout=layout);
    # 输出
    plotly.offline.plot(figure, filename="/temp/pie_graph.html", image="png");

if __name__ == "__main__":
    # draw_line_graph();
    # draw_bar_graph();
    draw_pie_graph();