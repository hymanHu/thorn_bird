#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
LSTM Model
'''

# 将项目根目录添加到 sys.path，解决 cmd 下执行该模块找不到包的问题
import sys, os;
current_path = os.path.abspath(os.path.dirname(__file__));
separator = "\\" if os.name == "nt" else "/";
project_name = "python_spider" + separator;
root_path = current_path[:current_path.find(project_name) + len(project_name)];  # 获取项目根目录
sys.path.append(root_path);

import math;
import numpy as np;
import pandas as pd;
from keras.models import Sequential;
from keras.layers import LSTM, Dense;
from sklearn.preprocessing import MinMaxScaler;
from sklearn.metrics import mean_squared_error;

class LSTM_Model(object):

    '''
    data：numpy 一维数组，[1 2 3...]
    step_length：步长，用步长数据预测下一个数据
    '''
    def __init__(self, data, step_length=1):
        print("构造 LSTM_Model，data 类型 %s，data 形状 %s, 步长 %s" % (type(data), data.shape, step_length));
        self.data = data;
        self.step_length = step_length;
        self.scaler = MinMaxScaler(feature_range=(0, 1));

    # 初始化训练数据和测试数据
    def init_train_test_data(self):
        print("==== 初始化训练数据和测试数据 ====");
        # 将值转化为 float 类型
        data = self.data.astype(float);
        # 使用 MinMaxScaler 进行数据归一化，参数需要二维结构 [[5][1][4]...[4][1][4]]
        data = self.scaler.fit_transform(data.reshape(-1, 1));
        # 数据 4/5 作为训练数据，1/5 作为测试数据
        train_length = int(len(data) * 0.8);
        train_data, test_data = data[0:train_length, :], data[train_length:len(data), :];
        print("train_data: %s" % train_data);
        print("test_data: %s" % test_data);
        # 返回一维数组结构
        return train_data.flatten(), test_data.flatten();

    '''
    构造模型适应数据
    data：numpy 一维数组 [ 5.  1.  4. ...  1.  4. 10.]
    step_length：步长，用步长数据预测下一个数据
        1 -> 1：[[5][1][4]...[4][1][4]] ---- [ 1  4  8 ...  1  4 10]
        2 -> 1：[[5 1][1 4][4 8]...[4 4][4 1][1 4]] ---- [ 4  8  3 ...  1  4 10]
        3 -> 1：[[5 1 4][1 4 8][4 8 3]...[1 4 4][4 4 1][4 1 4]] ---- [ 8  3 12 ...  1  4 10]
    '''
    def build_fit_data(self, data):
        print("==== 构造模型适应数据 ====");
        data_x, data_y = [], [];
        for i in range(len(data) - self.step_length):
            data_x.append(data[i: i + self.step_length]);
            data_y.append(data[i + self.step_length]);
        x, y = np.asarray(data_x), np.asarray(data_y);
        print(x);
        print(y);
        return x, y;

    def application(self):
        train_data, test_data = self.init_train_test_data();
        train_x, train_y = self.build_fit_data(train_data);
        test_x, test_y = self.build_fit_data(train_data);

if __name__ == '__main__':
    data = np.array(list(range(1, 101)));
    lstm = LSTM_Model(data=data);
    lstm.application();