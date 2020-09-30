package com.sfac.spring;

import com.sfac.spring.service.UserService;
import com.sfac.spring.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description JavaSpringApplication
 * @Author HymanHu
 * @Date 2020/9/30 14:04
 */
public class JavaSpringApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("application.xml");
        UserService userService = applicationContext.getBean(UserServiceImpl.class);
        userService.register("hujiang", "111111");
    }
}
