package com.sfac.springMvc.module.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sfac.springMvc.module.account.dao.UserDao;
import com.sfac.springMvc.module.account.entity.User;
import com.sfac.springMvc.module.account.service.UserService;

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
		return userDao.getUserByUserNameAndPassword(userName, password);
	}

}
