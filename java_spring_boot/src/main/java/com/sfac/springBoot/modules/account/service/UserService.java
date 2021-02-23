package com.sfac.springBoot.modules.account.service;

import com.github.pagehelper.PageInfo;
import com.sfac.springBoot.modules.account.entity.User;
import com.sfac.springBoot.modules.common.entity.ResultEntity;
import com.sfac.springBoot.modules.common.entity.SearchBean;

/**
 * @Description: User Service
 * @author: HymanHu
 * @date: 2021年2月21日
 */
public interface UserService {
	
	User getUserByUserNameAndPassword(String userName, String password);
	
	ResultEntity<User> login(User user);

	void logout();
	
	ResultEntity<User> insertUser(User user);
	
	ResultEntity<User> updateUser(User user);
	
	User getUserById(int id);
	
	ResultEntity<Object> deleteUserById(int id);
	
	PageInfo<User> getUsersBySearchBean(SearchBean searchBean);
	
	User getUserByUserName(String userName);
}
