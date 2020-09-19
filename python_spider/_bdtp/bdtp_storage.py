#!/usr/bin/env python3
# -*- coding: utf-8 -*-
from datetime import datetime
import os

import requests

'''
保存百度图片
'''
__author__ = "HymanHu";

base_folder = "/download/"
def bdtu_storage(folderName, images):

    dict_folder = "%s%s"%(base_folder, folderName)
    if not os.path.exists(dict_folder):
        os.makedirs(dict_folder)

    for image in images:
        if image:
            image_path = "%s/%s_%s.%s"%(dict_folder, folderName, images.index(image), image.split(".")[-1])
            r = requests.get(image)
            with open(image_path, 'wb') as f:
                f.write(r.content)

if __name__ == "__main__":
    pass