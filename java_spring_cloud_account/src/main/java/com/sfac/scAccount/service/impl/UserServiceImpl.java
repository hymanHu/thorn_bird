package com.sfac.scAccount.service.impl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sfac.common.entity.account.User;
import com.sfac.common.entity.account.UserRole;
import com.sfac.common.entity.common.ResultEntity;
import com.sfac.common.entity.common.SearchBean;
import com.sfac.common.entity.test.City;
import com.sfac.scAccount.dao.UserDao;
import com.sfac.scAccount.dao.UserRoleDao;
import com.sfac.scAccount.entity.UserVo;
import com.sfac.scAccount.service.UserService;
import com.sfac.scAccount.util.MD5Util;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.vavr.control.Try;

/**
 * @Description: User Service Impl
 * @author: HymanHu
 * @date: 2021年2月21日
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserRoleDao userRoleDao;
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public UserVo getUserVoById(int id) {
		UserVo userVo = userDao.getUserVoById(id);
		
		/*
		 * getForEntity：返回 ResponseEntity<T>，Spring 对 HTTP 请求响应的封装，
		 * - 包括了几个重要的元素，如响应码、contentType、contentLength、响应消息体等
		 * getForObject：只注返回的消息体的内容
		 */
//		City city = restTemplate.getForObject("http://client-test/api/city/{countryId}", City.class, 1890);
//		userVo.setCity(city);
		
		/*
		 * - 重试策略
		 * - 在生产者接口里书写 1/0 运行时异常，调用该接口可查看生产者控制台，调用了三次
		 */
//		RetryConfig retryConfig = RetryConfig
//				.custom()
//				.maxAttempts(3)
//				.waitDuration(Duration.ofMillis(3000))
//				.build();
//		Retry retry = Retry.of("retryPloy", retryConfig);
//		Try<City> retrySupplier = Try.ofSupplier(Retry.decorateSupplier(
//					retry, 
//					() -> restTemplate.getForObject("http://client-test/api/city/{countryId}", City.class, 1890)
//				));
//		userVo.setCity(retrySupplier.get());
		
		/*
		 * - 限流策略配置
		 */
//		RateLimiterConfig rateLimiterConfig = RateLimiterConfig.custom()
//				.limitRefreshPeriod(Duration.ofMillis(5000))
//				.limitForPeriod(1)
//				.timeoutDuration(Duration.ofMillis(6000))
//				.build();
//		RateLimiter rateLimiter = RateLimiter.of("rateLimiterPloy", rateLimiterConfig);
//		Try<City> rateLimiterSupplier = Try.ofSupplier(RateLimiter.decorateSupplier(
//					rateLimiter, 
//					() -> restTemplate.getForObject("http://client-test/api/city/{countryId}", City.class, 1890)
//				));
//		userVo.setCity(rateLimiterSupplier.get());
		
		/*
		 * - 熔断器策略配置
		 * - 生产者抛出异常或停掉的情况，都会返回默认值
		 */
		CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
				.failureRateThreshold(50)
				.waitDurationInOpenState(Duration.ofMillis(1000))
				.build();
		CircuitBreaker circuitBreaker = CircuitBreaker.of("circuitBreakerPloy", circuitBreakerConfig);
		Try<City> circuitBreakerSupplier = Try.ofSupplier(CircuitBreaker.decorateSupplier(
					circuitBreaker, 
					() -> restTemplate.getForObject("http://client-test/api/city/{countryId}", City.class, 1890)
				)).recover(Exception.class, new City());
		userVo.setCity(circuitBreakerSupplier.get());
		
		return userVo;
	}

	@Override
	public User getUserByUserNameAndPassword(String userName, String password) {
		return userDao.getUserByUserNameAndPassword(userName, MD5Util.getMD5(password));
	}

	@Override
	@Transactional
	public ResultEntity<User> insertUser(User user) {
		List<User> users = Optional
				.ofNullable(userDao.getUserByUserNameOrEmail(user.getEmail(), user.getUserName()))
				.orElse(Collections.emptyList());
		if (users.size() > 0) {
			return new ResultEntity<User>(ResultEntity.ResultStatus.FAILED.status, "User Name or email is repeat.");
		}
		
		user.setCreateDate(LocalDateTime.now());
		user.setPassword(MD5Util.getMD5(user.getPassword()));
		userDao.insertUser(user);
		if (user.getRoles() != null) {
			user.getRoles().stream()
				.forEach(item -> {userRoleDao.insertUserRole(new UserRole(user.getId(), item.getId()));});
		}
		return new ResultEntity<User>(ResultEntity.ResultStatus.SUCCESS.status, "Insert success", user);
	}

	@Override
	@Transactional
	public ResultEntity<User> updateUser(User user) {
		List<User> users = Optional
				.ofNullable(userDao.getUserByUserNameOrEmail(user.getEmail(), user.getUserName()))
				.orElse(Collections.emptyList());
		if (users.stream().filter(item -> item.getId() != user.getId()).count() > 0) {
			return new ResultEntity<User>(ResultEntity.ResultStatus.FAILED.status, "User Name or email is repeat.");
		}
		
		userDao.updateUser(user);
		if (user.getRoles() != null && !user.getRoles().isEmpty()) {
			userRoleDao.deleteUserRoleByUserId(user.getId());
			user.getRoles().stream()
				.forEach(item -> {userRoleDao.insertUserRole(new UserRole(user.getId(), item.getId()));});
		}
		
		return new ResultEntity<User>(ResultEntity.ResultStatus.SUCCESS.status, "Update success", user);
	}

	@Override
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	@Override
	@Transactional
	public ResultEntity<Object> deleteUserById(int id) {
		userDao.deleteUserById(id);
		userRoleDao.deleteUserRoleByUserId(id);
		return new ResultEntity<Object>(ResultEntity.ResultStatus.SUCCESS.status, "Delete success");
	}

	@Override
	public PageInfo<User> getUsersBySearchBean(SearchBean searchBean) {
		searchBean.initSearchBean();
		PageHelper.startPage(searchBean.getCurrentPage(), searchBean.getPageSize());
		return new PageInfo<User>(Optional
				.ofNullable(userDao.getUsersBySearchVo(searchBean))
				.orElse(Collections.emptyList()));
	}

}
