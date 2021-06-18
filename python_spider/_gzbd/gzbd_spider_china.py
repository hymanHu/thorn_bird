#!/usr/bin/env python3
# -*- coding: utf-8 -*-
__author__ = "HymanHu";

'''
爬取国家卫健委疫情数据
http://www.nhc.gov.cn/xcs/yqtb/list_gzbd.shtml
'''

import requests;

headers = {"Cookie":"sVoELocvxVW0S=5iHXPWniyS09wosC1SeezJZaulXWJ4oxx6qvFFvaYps2L0Zs0VYvk7oKm454m9GK2UxJQOkbw8AT4C_p_bc6Jyq; insert_cookie=96816998; sVoELocvxVW0T=53WB7vbkh4sAqqqm_ox8dlGaVJo1kdY70zF1BEnSc.3MnT.qkpoR9dYCNsJVu0bdhXWqNvdDSTcA2Kw2fcEZnR.Rv0HIQt8vqFVy9TL7dFKxJ.DPKBB8MKGMpyverMSz9jtIzbUfel5XDyMGJM3ExUEGEaMQAvNzqwPmkVrEBfUhEFcd_ks_LDJzZyqEdnF7dQCOgRykzP9aafWslEuH7vKYiSTrLy89B24ziHfPCjDz3vyWQoO7pcHx6kzeIxHE1wC0U8bpdSxE_IgcFAMh8MHNOCK6dWGaOcnvGmV8OkLGCjFvL.Cah7USeaA0fTeQwj2HyrauvdNp27dBBaxOTcr; security_session_verify=752880dc4997c72b6cf921e6f2dc7c07; yfx_c_g_u_id_10006654=_ck21061808471810833931083333857; yfx_f_l_v_t_10006654=f_t_1623977238082__r_t_1623977238082__v_t_1623977238082__r_c_0",
           "User-Agent":"Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:89.0) Gecko/20100101 Firefox/89.0"};

# 获取新闻页数据
def get_news_page_data(url):
    r = requests.get(url=url, headers=headers);
    print(r.text);

if __name__ == "__main__":
    url = "http://www.nhc.gov.cn/xcs/yqtb/202106/6bd3c0c8f1734ed8b74d941dd2c4d582.shtml";
    get_news_page_data(url);
