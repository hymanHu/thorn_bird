import numpy as np;
from keras.models import Sequential
from keras.layers import Dense, Activation
from keras.layers import LSTM
from sklearn.preprocessing import MinMaxScaler
from sklearn.metrics import mean_squared_error

if __name__ == '__main__':
    X = np.random.rand(1000)
    y = 2 * X
    print(X)
    print(y)

    poi = int(len(X) * .8)
    X_train = X[:poi]
    y_train = y[:poi]

    X_test = X[poi:]
    y_test = y[poi:]

    # you have to change your input shape (nb_samples, timesteps, input_dim)
    X_train = X_train.reshape(len(X_train), 1, 1)
    # and also the output shape (note that the output *shape* is 2 dimensional)
    y_train = y_train.reshape(len(y_train), 1)

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


