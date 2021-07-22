#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
lstm test
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
from keras.models import Sequential
from keras.layers import Dense
from keras.layers import LSTM
from sklearn.preprocessing import MinMaxScaler
from sklearn.metrics import mean_squared_error

# 定义随机种子，以便重现结果
np.random.seed(7);
scaler = MinMaxScaler(feature_range=(0, 1));

'''
初始化 lstm 数据
data：numpy 一维数组 [ 5.  1.  4. ...  1.  4. 10.]
'''
def init_train_test_data(data):
    # 将值转化为 float 类型
    data = data.astype(float);
    # 使用 MinMaxScaler 进行数据归一化，参数需要二维结构 [[5][1][4]...[4][1][4]]
    data = scaler.fit_transform(data.reshape(-1, 1));
    # 数据 2/3 作为训练数据，1/3 作为测试数据
    train_length = int(len(data) * 0.67);
    test_length = len(data) - train_length;
    train_data, test_data = data[0:train_length, :], data[test_length:len(data), :];
    # 返回一维数组结构
    return train_data.flatten(), test_data.flatten();

'''
构造训练数据
data：numpy 一维数组 [ 5.  1.  4. ...  1.  4. 10.]
step_length：步长，用步长数据预测下一个数据
1 -> 1：[[5][1][4]...[4][1][4]] ---- [ 1  4  8 ...  1  4 10]
2 -> 1：[[5 1][1 4][4 8]...[4 4][4 1][1 4]] ---- [ 4  8  3 ...  1  4 10]
3 -> 1：[[5 1 4][1 4 8][4 8 3]...[1 4 4][4 4 1][4 1 4]] ---- [ 8  3 12 ...  1  4 10]
'''
def get_train_data(data, step_length=1):
    data_x, data_y = [], [];
    for i in range(len(data) - step_length):
        data_x.append(data[i : i + step_length]);
        data_y.append(data[i + step_length]);
    return np.asarray(data_x), np.asarray(data_y);

def time_model(data_x, data_y):
    # 重构输入数据格式 [samples, time steps, features] = [93,1,1]
    # data_x = np.reshape(data_x, (data_x.shape[0], 1, data_x.shape[1]));
    print(data_x.shape);
    print(data_x, data_y);
    #使用时间步长的LSTM回归模型
    model=Sequential();
    '''
    units：LSTM 单元内的隐藏层尺寸，理论上这个 units 的值越大, 网络越复杂, 精度更高,计算量更大；
    input_shape：三维尺寸，模型需要知道它所期望的输入的尺寸，顺序模型中的第一层且只有第一层
            需要接收关于其输入尺寸的信息，下面的层可以自动地推断尺寸；
        (batch_dim, time_dim, feat_dim) input_shape=(time_dim, feat_dim)
        Batch_size：比较好的方法是将 Batch_size 设置为 None
        Time_step：时间序列的长度
        Input_Sizes：每个时间点输入 x 的维度
    '''
    model.add(LSTM(units=4, input_shape=(1, data_x.shape[1])));
    model.add(Dense(units=1));
    model.compile(loss='mean_squared_error',optimizer='adam');
    model.fit(data_x, data_y, epochs=10, batch_size=1, verbose=2);
    # 对训练数据进行预测
    train_predict = model.predict(data_x);
    # 对数据进行逆缩放
    train_predict = scaler.inverse_transform(train_predict);
    data_y = scaler.inverse_transform([data_y]);

    # 计算RMSE误差
    score = math.sqrt(mean_squared_error(data_y[0], train_predict[:, 0]));
    print('Score: %.2f RMSE' % (score));

if __name__ == '__main__':
    step_length = 1;
    df = pd.read_csv(filepath_or_buffer="/temp/twocolorball.csv", encoding="gbk");
    train,test = init_train_test_data(np.asarray(df["红球1"]));
    train_x, train_y = get_train_data(train, step_length=step_length);
    test_x, test_y = get_train_data(test, step_length=step_length);
    # print(train_x.reshape(-1, 1, 1))
    # time_model(train_x, train_y);
    time_model(test_x.reshape(-1, 1, 1), test_y);

    # data_x,data_y = get_train_data(data=np.asarray(df["红球1"]), step_length=3);
    # print(data_x);
    # print(data_y);

