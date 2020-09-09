#!/usr/bin/env python3
# -*- coding: utf-8 -*-

__author__ = "HymanHu"

'''
Result
'''
class Result(object):
    def __init__(self, status, messgae, data=None):
        self.status = status
        self.message = messgae
        self.data = data

    def result(self):
        if self.data == None:
            return {"status":self.status, "message":self.message}
        else:
            return {"status":self.status, "message":self.message, "data": self.data}

if __name__ == "__main__":
    print(Result(200, "success").result())
    print(Result(200, "success",{"user_name":"HymanHu", "age":22}).result())


