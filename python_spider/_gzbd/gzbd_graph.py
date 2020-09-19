#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
_gzbd graph
'''

import plotly;
import mysql_util;

def build_graph_data():
    result = mysql_util.execute_("select * from gzbd_epidemic order by date desc limit 7");
    x_date = [];
    y_diagnosis = [];
    y_cure = [];
    y_death = [];
    for item in result:
        x_date.append(item[2]);
        y_diagnosis.append(item[3]);
        y_cure.append(item[5]);
        y_death.append(item[6]);
    graph_data = {
        "x_date": x_date,
        "y_diagnosis": y_diagnosis,
        "y_cure": y_cure,
        "y_death": y_death
    };
    return graph_data;


def draw_line_graph(graph_data):
    # 准备图轨数据
    trace_1 = plotly.graph_objs.Scatter(
        x = graph_data.get("x_date"),
        y = graph_data.get("y_cure"),
        name="治愈数",
    );
    trace_2 = plotly.graph_objs.Scatter(
        x = graph_data.get("x_date"),
        y = graph_data.get("y_diagnosis"),
        name="确诊数"
    );
    trace_3 = plotly.graph_objs.Scatter(
        x = graph_data.get("x_date"),
        y = graph_data.get("y_death"),
        name="死亡数"
    );
    line_data = [trace_1, trace_2, trace_3];
    # 设置画布布局
    layout = plotly.graph_objs.Layout(title="gzbd折线图", xaxis={"title": "时间"}, yaxis={"title": "数量"});
    # 融合图轨数据和布局
    figure = plotly.graph_objs.Figure(data=line_data, layout=layout);
    #输出
    plotly.offline.plot(figure, filename="/temp/gzbd_line_graph.html", image="png");

def draw_bar_graph(graph_data):
    # 准备图轨数据
    trace_1 = plotly.graph_objs.Bar(
        x = graph_data.get("x_date"),
        y = graph_data.get("y_cure"),
        name="治愈数"
    );
    trace_2 = plotly.graph_objs.Bar(
        x = graph_data.get("x_date"),
        y = graph_data.get("y_diagnosis"),
        name="确诊数"
    );
    trace_3 = plotly.graph_objs.Bar(
        x=graph_data.get("x_date"),
        y=graph_data.get("y_death"),
        name="死亡数"
    );
    bar_data = [trace_1, trace_2, trace_3];

    # 设置画布布局
    layout = plotly.graph_objs.Layout(title="_gzbd data", xaxis={"title": "时间"}, yaxis={"title": "数值"});
    # 融合图轨数据和布局
    figure = plotly.graph_objs.Figure(data=bar_data, layout=layout);
    # 输出
    plotly.offline.plot(figure, filename="/temp/gzbd_bar_graph.html", image="png");

if __name__ == "__main__":
    graph_data = build_graph_data();
    draw_line_graph(graph_data);
    draw_bar_graph(graph_data);