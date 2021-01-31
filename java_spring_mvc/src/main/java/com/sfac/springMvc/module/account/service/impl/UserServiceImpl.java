package com.sfac.springMvc.module.account.service.impl;

import java.util.Collections;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Optionals;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.sqlsource.PageStaticSqlSource;
import com.sfac.springMvc.module.account.dao.UserDao;
import com.sfac.springMvc.module.account.entity.User;
import com.sfac.springMvc.module.account.service.UserService;
import com.sfac.springMvc.module.common.entity.ResultEntity;
import com.sfac.springMvc.module.common.entity.SearchBean;
import com.sfac.springMvc.util.MD5Util;

/**
 * Description: User Service Impl
 * @author HymanHu
 * @date 2021-01-27 09:50:50
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public User getUserByUserNameAndPassword(String userName, String password) {
		return userDao.getUserByUserNameAndPassword(userName, MD5Util.getMD5(userName, password));
	}

	@Override
	public ResultEntity<User> login(User user) {
		User userTemp = userDao.getUserByUserNameAndPassword(user.getUserName(), 
				MD5Util.getMD5(user.getUserName(), user.getPassword()));
		if (userTemp != null) {
			return new ResultEntity<User>(ResultEntity.ResultStatus.SUCCESS.status, "Login success", userTemp);
		} else {
			return new ResultEntity<User>(ResultEntity.ResultStatus.FAILED.status, "Login fail");
		}
	}

	@Override
	@Transactional
	public ResultEntity<User> insertUser(User user) {
		User userTemp = userDao.getUserByUserName(user.getUserName());
		if (userTemp != null) {
			return new ResultEntity<User>(ResultEntity.ResultStatus.FAILED.status, "User Name is repeat.");
		}
		
		user.setPassword(MD5Util.getMD5(user.getUserName(), user.getPassword()));
		userDao.insertUser(user);
		return new ResultEntity<User>(ResultEntity.ResultStatus.SUCCESS.status, "Insert success", user);
	}

	@Override
	@Transactional
	public ResultEntity<User> updateUser(User user) {
		User userTemp = userDao.getUserByUserName(user.getUserName());
		if (userTemp != null && userTemp.getId() != user.getId()) {
			return new ResultEntity<User>(ResultEntity.ResultStatus.FAILED.status, "User Name is repeat.");
		}
		
		user.setPassword(MD5Util.getMD5(user.getUserName(), user.getPassword()));
		userDao.updateUser(user);
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
