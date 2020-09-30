package com.sfac.spring.service.impl;

import com.sfac.spring.entity.User;
import com.sfac.spring.service.EmailService;
import com.sfac.spring.service.UserService;
import com.sun.javafx.binding.StringFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @Description UserServiceImpl
 * @Author HymanHu
 * @Date 2020/9/30 10:30
 */
public class UserServiceImpl implements UserService {

    private EmailService emailService;

    // 通过 set 方法注入 emailService
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    private static List<User> users = new ArrayList<>();
    static {
        IntStream.range(1, 5).forEach(item -> {
            User user = new User();
            user.setId(item);
            user.setEmail(String.format("hujiang%d@163.com", item));
            user.setPassword("111111");
            users.add(user);
        });
    }

    public User register(String email, String password) {
        users.forEach(item -> {
            if (item.getEmail().equalsIgnoreCase(email)) {
                throw new RuntimeException("Email is exist.");
            }
        });

        int maxId = users.stream().mapToInt(item -> {return item.getId();}).max().getAsInt();
        User user = new User(maxId + 1,
                String.format("%s%d@163.com", email, maxId + 1), password);
        users.add(user);

        emailService.sendEmail(user);

        return user;
    }
}
