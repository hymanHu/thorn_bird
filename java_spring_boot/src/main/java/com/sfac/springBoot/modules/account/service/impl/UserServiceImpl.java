package com.sfac.springBoot.modules.account.service.impl;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sfac.springBoot.modules.account.dao.UserDao;
import com.sfac.springBoot.modules.account.dao.UserRoleDao;
import com.sfac.springBoot.modules.account.entity.User;
import com.sfac.springBoot.modules.account.entity.UserRole;
import com.sfac.springBoot.modules.account.service.UserService;
import com.sfac.springBoot.modules.common.entity.ResultEntity;
import com.sfac.springBoot.modules.common.entity.SearchBean;
import com.sfac.springBoot.util.MD5Util;

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

	@Override
	public User getUserByUserNameAndPassword(String userName, String password) {
		return userDao.getUserByUserNameAndPassword(userName, MD5Util.getMD5(userName, password));
	}

	@Override
	public User getUserByUserName(String userName) {
		List<User> users = Optional
				.ofNullable(userDao.getUserByUserName(userName))
				.orElse(Collections.emptyList());
		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	public ResultEntity<User> login(User user) {
		User userTemp = getUserByUserNameAndPassword(user.getUserName(), user.getPassword());
		if (userTemp == null) {
			return new ResultEntity<User>(ResultEntity.ResultStatus.FAILED.status, 
					"User name or password error", user);
		}
		return new ResultEntity<User>(ResultEntity.ResultStatus.SUCCESS.status, "Login success", user);
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
		user.setPassword(MD5Util.getMD5(user.getUserName(), user.getPassword()));
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
		
		user.setPassword(MD5Util.getMD5(user.getUserName(), user.getPassword()));
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