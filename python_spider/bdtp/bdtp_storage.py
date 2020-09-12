#!/usr/bin/env python3
# -*- coding: utf-8 -*-
from datetime import datetime
import os

import requests

__author__ = "HymanHu";

'''
保存百度图片
'''
base_folder = "/download/"
def bdtu_storage(folderName, images):

    dict_folder = "%s%s"%(base_folder, folderName)
    if not os.path.exists(dict_folder):
        os.makedirs(dict_folder)

    for image in images:
        if image:
            image_path = "%s/%s_%s.%s"%(dict_folder, folderName,
                                        datetime.now().strftime("%Y%m%d%H%M%S"), image.split(".")[-1])
            r = requests.get(image)
            with open(image_path, 'wb') as f:
                f.write(r.content)

if __name__ == "__main__":
    print(datetime.now().strftime("%Y%m%d%H%M%S"))
    temp = "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=196546764,2351605330&fm=26&gp=0.jpg";
    print(temp.split(".")[-1])