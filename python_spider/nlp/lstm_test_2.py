import numpy as np;

# 模型训练数据集，通过几次数据来预测下一次，x1、x2、x3 为三次训练数据，y 为验证数据
def init_lstm_train_data(data, train_length=3):
    data_x, data_y = [], [];
    for i in range(len(data) - train_length):
        data_x.append(data[i : i + train_length]);
        data_y.append(data[i + train_length]);
    return np.asarray(data_x), np.asarray(data_y);

# from tensorflow.keras.layers import Dense;
# from keras import Sequential
# from tensorflow import keras
from keras.models import Sequential
from keras.layers import Dense
from keras.layers import LSTM
def lstm_forecast(df):
    data_x, data_y = init_lstm_train_data(data=np.asarray(df["红球1"]));
    print(data_x);
    print(data_x.shape);
    print(data_y);
    # 实例化一个次序模型
    model = Sequential();
    # 使用add方法添加隐层
    # 创建了一个 LSTM 模型，该模型具有 50 个神经元和 relu 激活函数，输入形状为样本形状
    model.add(LSTM(50, activation='relu', input_shape=(data_x.shape[0], data_x.shape[1])));
    model.add(Dense(1));
    # 编译模型
    model.compile(optimizer='adam', loss='mse');
    # 训练模型, 将训练数据的特征和标签导入
    # model.fit(data_x, data_y);
    model.fit(data_x, data_y, epochs=2000, validation_split=0.2, batch_size=5)
    # # 输出摘要
    model.summary();

def lstm_forecast_2(df):
    all_data = np.asarray(df["红球1"]);
    train_data = all_data[: -100];
    test_data = all_data[-100:];
    print(len(all_data));
    print(len(train_data));
    print(len(test_data));
    pass