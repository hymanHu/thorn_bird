import numpy as np;
import pandas as pd;
from pandas import Series, DataFrame;


def ssss():
    data = np.arange(20).reshape(5, 4);
    column_list = ["第一季度", "第二季度", "第三季度", "第四季度"];
    index_list = ["公司1", "公司2", "公司3", "公司4", "公司5"];

    df = DataFrame(data=data, index=index_list, columns=column_list);
    print(df);

    xx = df["第四季度"].quantile(0.25);
    print(xx);
    print(df[(df["第四季度"] <= xx) & (df["第三季度"] >= 6)]);

    print(df.count(axis=0))


if __name__ == "__main__":
    # ssss();
    print("2016-05-14"[0:7]);