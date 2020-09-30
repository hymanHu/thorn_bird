package com.sfac.spring.service.impl;

import com.sfac.spring.entity.User;
import com.sfac.spring.service.EmailService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Description EmailServiceImpl
 * @Author HymanHu
 * @Date 2020/9/30 10:32
 */
public class EmailServiceImpl implements EmailService {
    public void sendEmail(User user) {
        System.out.println(String.format("Hi %s, you are register on %s", user.getEmail(),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss"))));
    }
}
