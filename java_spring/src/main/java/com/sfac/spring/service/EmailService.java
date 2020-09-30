package com.sfac.spring.service;

import com.sfac.spring.entity.User;

/**
 * @Description EmailService
 * @Author HymanHu
 * @Date 2020/9/30 10:17
 */
public interface EmailService {
    void sendEmail(User user);
}
