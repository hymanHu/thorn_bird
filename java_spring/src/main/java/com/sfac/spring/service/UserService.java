package com.sfac.spring.service;

import com.sfac.spring.entity.User;

/**
 * @Description UserService
 * @Author HymanHu
 * @Date 2020/9/30 10:16
 */
public interface UserService {
    User register(String email, String password);
}
