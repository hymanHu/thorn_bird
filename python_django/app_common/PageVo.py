#!/usr/bin/env python3
# -*- coding: utf-8 -*-
'''
Common page vo object
'''

__author__ = "HymanHu"

class Result(object):
    def __init__(self, status, message, data=None):
        self.status = status
        self.message = message
        self.data = data

    def result(self):
        if self.data:
            return {"status": self.status, "message": self.message, "data": self.data}
        else:
            return {"status": self.status, "message": self.message}

class Search_Vo(object):
    def __init__(self, data):
        self.current_page = data.get("currentPage", 1)
        self.page_size = data.get("pageSize", 5)
        self.order_by = data.get("orderBy", "")
        self.direction = data.get("direction", "asc")
        if self.direction.lower() == "desc":
            self.order_by = "-" + self.order_by
        self.keyWord = data.get("keyWord", "")

class Page_Info(object):
    def __init__(self, total=0, pages=0, current_page=1, page_size=5, list=[]):
        self.total = total
        self.pages = pages
        self.current_page = current_page
        self.page_size = page_size
        self.list = list

    def result(self):
        page_info_dict = {}
        page_info_dict["total"] = self.total
        page_info_dict["pages"] = self.pages
        page_info_dict["currentPage"] = self.current_page
        page_info_dict["pageSize"] = self.page_size
        page_info_dict["list"] = self.list
        return page_info_dict