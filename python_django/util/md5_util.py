#!/usr/bin/env python3
# -*- coding: utf-8 -*-
'''
md5 utils
'''
import hashlib;

def get_md5(s, salt="&%5123***&&%%$$#@"):
    s += "/" + salt;
    md5 = hashlib.md5(str(s).encode("utf-8"));
    return md5.hexdigest();

if __name__ == "__main__":
    print(get_md5("111111"));