#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
LSTM model 代码搜集
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
from keras.models import Sequential;
from keras.layers import LSTM, Dense, Activation;
from sklearn.preprocessing import MinMaxScaler;
from sklearn.metrics import mean_squared_error;

hidden_layer_num = 50;
look_back = 1;
batch_size = 10;

def perceptron_model():
    # 多层感知器模型，hidden_layer_num隐藏层层数
    """这里导入的数据不需要进行reshpe改变，直接用datax.append(x)，datay.append(y)的数据就行"""
    model = Sequential()
    model.add(Dense(units=hidden_layer_num, input_dim=look_back, activation='relu'))
    model.add(Dense(units=hidden_layer_num, activation='relu'))
    model.add(Dense(units=1))
    model.compile(loss='mean_squared_error', optimizer='adam')
    return model

def time_model():
    # LSTM搭建的LSTM回归模型
    model = Sequential()
    model.add(LSTM(units=hidden_layer_num, input_shape=(1, look_back)))  # 四个隐藏层或者更多
    model.add(Dense(units=1))
    model.compile(loss='mean_squared_error', optimizer='adam')
    return model

def time_step_model():
    # 使用时间步长的LSTM回归模型
    model = Sequential()
    model.add(LSTM(units=hidden_layer_num, input_shape=(look_back, 1)))
    model.add(Dense(units=1))
    model.compile(loss='mean_squared_error', optimizer='adam')
    return model

def memory_batches_model():
    # LSTM的批次时间记忆模型
    model = Sequential()
    # 通过设置stateful为True来保证LSTM层内部的状态，从而获得更好的控制
    model.add(LSTM(units=hidden_layer_num, batch_input_shape=(batch_size, look_back, 1), stateful=True))
    model.add(Dense(units=1))
    model.compile(loss='mean_squared_error', optimizer='adam')
    return model

def stack_memory_batches_model():
    # 两个叠加的LSTM的批次时间记忆模型
    model = Sequential()
    # 通过设施return_sequences等于True来完成每个LSTM层之前的LSTM层必须返回序列，将LSTM扩展位两层
    model.add(LSTM(units=hidden_layer_num, batch_input_shape=(batch_size, look_back, 1), stateful=True,
                   return_sequences=True))
    # 通过设置stateful为True来保证LSTM层内部的状态，从而获得更好的控制
    model.add(LSTM(units=hidden_layer_num, input_shape=(batch_size, look_back, 1), stateful=True))
    model.add(Dense(units=1))
    model.compile(loss='mean_squared_error', optimizer='adam')
    return model

def model_example_1():
    X = np.random.rand(1000)
    y = 2 * X
    print(X)
    print(y)

    poi = int(len(X) * .8)
    X_train = X[:poi]
    y_train = y[:poi]

    X_test = X[poi:]
    y_test = y[poi:]

    print(X_train)
    print(y_train)

    # you have to change your input shape (nb_samples, timesteps, input_dim)
    X_train = X_train.reshape(len(X_train), 1, 1)
    # and also the output shape (note that the output *shape* is 2 dimensional)
    y_train = y_train.reshape(len(y_train), 1)

    print(X_train)
    print(y_train)
    print(X_train.shape)
    print(y_train.shape)

    # Change test data's dimension also.
    X_test = X_test.reshape(len(X_test), 1, 1)
    y_test = y_test.reshape(len(y_test), 1)

    # in_out_neurons = 2
    in_out_neurons = 1

    hidden_neurons = 300
    model = Sequential()
    # model.add(Masking(mask_value=0, input_shape=(input_dim,)))
    # Remove batch_input_shape and add input_shape = (1,1) - Imp change for Keras 2.0.0
    model.add(LSTM(hidden_neurons, return_sequences=False, input_shape=(X_train.shape[1], X_train.shape[2])))
    # only specify the output dimension
    model.add(Dense(in_out_neurons))
    model.add(Activation("linear"))
    model.compile(loss="mean_squared_error", optimizer="rmsprop")
    model.summary()
    model.fit(X_train, y_train, epochs=10, validation_split=0.05)

    # calculate test set MSE
    preds = model.predict(X_test).reshape(len(y_test))
    print(preds)
    MSE = np.mean((preds - y_test) ** 2)
    print('MSE ', MSE)