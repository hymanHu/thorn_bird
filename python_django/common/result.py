#!/usr/bin/env python3
# -*- coding: utf-8 -*-

'''
Common result
'''

__author__ = "HymanHu";

class Result(object):
    def __init__(self, status, message, data=None):
        self.status = status
        self.message = message
        self.data = data

    def result(self):
        if self.data == None:
            return {"status": self.status, "message": self.message}
        else:
            return {"status": self.status, "message": self.message, "data": self.data}


if __name__ == "__main__":
    print(Result(200, "success").result())
    print(Result(200, "success", {"user_name": "HymanHu", "age": 22}).result())