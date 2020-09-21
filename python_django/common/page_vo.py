#!/usr/bin/env python3
# -*- coding: utf-8 -*-
'''
Common page vo object
'''
import datetime

__author__ = "HymanHu"

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

class Search_Vo(object):
    def __init__(self, data):
        self.current_page = data.get("currentPage", None)
        self.page_size = data.get("pageSize", None)
        self.order_by = data.get("orderBy", None)
        self.sort = data.get("sort", "asc")
        if self.sort.lower() == "desc":
            self.order_by = "-" + self.order_by
        self.keyword = data.get("keyword", None)

class Page_Info(object):
    def __init__(self, count=0, total_page=0, current_page=1, page_size=5, data=[]):
        self.count = count
        self.total_page = total_page
        self.current_page = current_page
        self.page_size = page_size
        self.data = data

    def result(self):
        page_info_dict = {}
        page_info_dict["count"] = self.count
        page_info_dict["totalPage"] = self.total_page
        page_info_dict["currentPage"] = self.current_page
        page_info_dict["pageSize"] = self.page_size
        page_info_dict["data"] = self.data
        return page_info_dict