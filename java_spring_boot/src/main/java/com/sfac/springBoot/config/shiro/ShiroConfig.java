package com.sfac.springBoot.config.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description Shiro Config
 * @Author HymanHu
 * @Date 2021/2/23 15:44
 */
@Configuration
public class ShiroConfig {

    @Autowired
    private MyRealm myRealm;

    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm);
        return securityManager;
    }

    /**
     * -配置 shiro 过滤器工厂
     * -----------------
     * -拦截权限
     * anon：匿名访问，无需登录
     * authc：登录后才能访问 ---- FormAuthenticationFilter
     * user：登录过能访问 ---- UserFilter
     * logout：登出 ---- LogoutFilter
     * roles：角色过滤器
     * ------------------
     * URL匹配风格
     * ?：匹配一个字符，如 /admin? 将匹配 /admin1，但不匹配 /admin 或 /admin/
     * *：匹配零个或多个字符串，如 /admin* 将匹配 /admin 或/admin123，但不匹配 /admin/1
     * **：匹配路径中的零个或多个路径，如 /admin/** 将匹配 /admin/a 或 /admin/a/b
     * -----------------------
     * -方法名不能乱写，如果我们定义为别的名称，又没有添加注册过滤器的配置，
     * -那么 shiro 会加载 ShiroWebFilterConfiguration 过滤器，
     * -该过滤器会寻找 shiroFilterFactoryBean，找不到会抛出异常
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        shiroFilterFactoryBean.setLoginUrl("/manager/login");
        shiroFilterFactoryBean.setSuccessUrl("/common/dashboard");

        // 设置访问规则
        Map<String, String> map = new LinkedHashMap<String, String>();
        // 匿名访问规则
        // ---- 静态资源文件 ----
        map.put("/css/**", "anon");
        map.put("/images/**", "anon");
        map.put("/js/**", "anon");
        map.put("/vendors/**", "anon");
        map.put("/upload/**", "anon");
        // ---- 登录、注册、测试、api ----
        map.put("/login", "anon");
        map.put("/register", "anon");
        map.put("/logout", "anon");
        map.put("/test/**", "anon");
        map.put("/api/**", "anon");

        // 登录访问规则
        map.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        return shiroFilterFactoryBean;
    }

    /**
     * - 注册shiro方言，让 thymeleaf 支持 shiro 标签
     */
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }

    /**
     * DefaultAdvisorAutoProxyCreator, Advisor 代理类生成器
     */
    @Bean
    @DependsOn({"lifecycleBeanPostProcessor"})
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    /**
     * - 创建 AuthorizationAttributeSourceAdvisor，扫描 Shiro 注解
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
        return authorizationAttributeSourceAdvisor;
    }
}
