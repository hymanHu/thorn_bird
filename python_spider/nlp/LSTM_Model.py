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
from keras.layers import LSTM, Dense, Activation;
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
        # 设置 numpy 数组打印格式化
        np.set_printoptions(linewidth=400, threshold=6);

    # 初始化训练数据和测试数据
    def init_train_test_data(self):
        print("==== 初始化训练数据和测试数据 ====");
        print("原始数据：%s" % self.data);

        # 将值转化为 float 类型
        self.data = self.data.astype(float);

        # 使用 MinMaxScaler 进行数据归一化，参数需要二维结构 [[5][1][4]...[4][1][4]]
        # 归一化完成后，将二维结构变回一维结构
        self.data = self.scaler.fit_transform(self.data.reshape(-1, 1)).flatten();
        print("归一化数据：%s" % self.data);

        # 数据 4/5 作为训练数据，1/5 作为测试数据
        print("---- 数据拆分 ----");
        train_length = int(len(self.data) * 0.8);
        # 二维结构拆分，并返回一维结构
        # train_data, test_data = self.data[0:train_length, :].flatten(), \
        #                         self.data[train_length:len(data), :].flatten();
        # 一维结构拆分
        train_data, test_data = self.data[0:train_length], self.data[train_length:len(self.data)];
        print("训练数据: %s" % train_data);
        print("测试数据: %s" % test_data);

        return train_data, test_data;

    '''
    构造模型适应数据
    data：numpy 一维数组 [ 5.  1.  4. ...  1.  4. 10.]
    step_length：步长，用步长数据预测下一个数据
        1 -> 1：[[5][1][4]...[4][1][4]] ---- [ 1  4  8 ...  1  4 10]
        2 -> 1：[[5 1][1 4][4 8]...[4 4][4 1][1 4]] ---- [ 4  8  3 ...  1  4 10]
        3 -> 1：[[5 1 4][1 4 8][4 8 3]...[1 4 4][4 4 1][4 1 4]] ---- [ 8  3 12 ...  1  4 10]
    '''
    def build_fit_data(self, data, data_name=""):
        print("==== 构造%s模型适应数据 ====" % data_name);
        data_x, data_y = [], [];
        for i in range(len(data) - self.step_length):
            data_x.append(data[i: i + self.step_length]);
            data_y.append(data[i + self.step_length]);
        x, y = np.asarray(data_x), np.asarray(data_y);
        # x 重构 shape (nb_samples, timesteps, input_dim)
        x = x.reshape(len(x), self.step_length, 1);
        # y 重构 shape
        y = y.reshape(len(y), 1);
        print("%s_x 数据：%s" % (data_name, x));
        print("%s_y 数据：%s" % (data_name, y));
        return x, y;

    '''
    时间步长 LSTM 回归模型
    '''
    def time_step_model(self, train_x, train_y, test_x, test_y):
        # 隐藏神经元
        hidden_neurons = 50;
        # 输入输出神经元
        in_out_neurons = 1;

        print("==== 构造 Sequential 模型 ====");
        model = Sequential();
        '''
        units：LSTM 单元内的隐藏层尺寸，理论上这个 units 的值越大, 网络越复杂, 精度更高，计算量更大；
        input_shape：三维尺寸，模型需要知道它所期望的输入的尺寸，顺序模型中的第一层且只有第一层
                需要接收关于其输入尺寸的信息，下面的层可以自动地推断尺寸；
                input_shape=(batch_dim, time_dim, feat_dim) 
                input_shape=(time_dim, feat_dim)
            Batch_size：比较好的方法是将 Batch_size 设置为 None
            Time_step：时间序列的长度
            Input_Sizes：每个时间点输入 x 的维度
        activation：激活函数 relu、linear 等，也可以单独添加激活层实现 model.add(Activation("linear"));
        '''
        print("---- 添加 LSTM 层，该层有 %d 个隐藏神经元，relu 激活函数， 输入样本形状为 %s ----" %
              (hidden_neurons, train_x.shape));
        # model.add(LSTM(hidden_neurons, return_sequences=False, input_shape=(train_x.shape[1], train_x.shape[2])));
        model.add(LSTM(hidden_neurons, activation='relu', input_shape=(train_x.shape[1], train_x.shape[2])));
        print("---- 添加 Dense 层，该层有 %d 个输入输出神经元 ----" % (in_out_neurons,));
        # 全连接层
        model.add(Dense(in_out_neurons));
        print("---- 编译模型 ----");
        model.compile(loss="mean_squared_error", optimizer="rmsprop");
        print("---- 输出摘要 ----");
        model.summary();

        print("---- 使用训练数据训练模型 ----");
        model.fit(train_x, train_y, epochs=10, validation_split=0.05);
        print("---- 用模型对测试数据进行预测 ----");
        predict = model.predict(test_x).reshape(len(test_y));
        print("预测数据：%s" % (predict,));

        print("---- 数据反归一化 ----");
        # 使用 MinMaxScaler 进行数据反归一化，参数需要二维结构 [[5][1][4]...[4][1][4]]
        # 归一化完成后，将二维结构变回一维结构
        predict = self.scaler.inverse_transform(predict.reshape(-1, 1)).flatten();
        test_y = self.scaler.inverse_transform(test_y).flatten();
        print("test_y 反归一化：%s" % (test_y, ));
        print("预测数据反归一化：%s" % (predict, ));

        print("---- 计算测试数据与预测数据 RMSE 误差 ----");
        # 计算均方误差回归损失
        MSE = np.mean((predict - test_y) ** 2);
        MSE = mean_squared_error(test_y, predict);
        print('MSE：%.2f' % MSE);
        score = math.sqrt(MSE);
        print('Score：%.2f' % score);

    def application(self):
        train_data, test_data = self.init_train_test_data();
        train_x, train_y = self.build_fit_data(train_data, "训练");
        test_x, test_y = self.build_fit_data(train_data, "测试");
        self.time_step_model(train_x, train_y, test_x, test_y);

if __name__ == '__main__':
    data = np.array(list(range(1, 101)));
    lstm = LSTM_Model(data=data, step_length=2);
    lstm.application();