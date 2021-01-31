package com.sfac.springMvc.module.account.service;

import com.github.pagehelper.PageInfo;
import com.sfac.springMvc.module.account.entity.User;
import com.sfac.springMvc.module.common.entity.ResultEntity;
import com.sfac.springMvc.module.common.entity.SearchBean;

/**
 * Description: User Service
 * @author HymanHu
 * @date 2021-01-27 09:49:32
 */
public interface UserService {
	
	User getUserByUserNameAndPassword(String userName, String password);
	
	ResultEntity<User> login(User user);
	
	ResultEntity<User> insertUser(User user);
	
	ResultEntity<User> updateUser(User user);
	
	User getUserById(int id);
	
	ResultEntity<Object> deleteUserById(int id);
	
	PageInfo<User> getUsersBySearchBean(SearchBean searchBean);
}
