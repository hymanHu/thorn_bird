package com.sfac.scAccount.service;

import com.github.pagehelper.PageInfo;
import com.sfac.common.entity.account.User;
import com.sfac.common.entity.common.ResultEntity;
import com.sfac.common.entity.common.SearchBean;
import com.sfac.scAccount.entity.UserVo;

/**
 * @Description: User Service
 * @author: HymanHu
 * @date: 2021年2月21日
 */
public interface UserService {
	
	User getUserByUserNameAndPassword(String userName, String password);
	
	ResultEntity<User> insertUser(User user);
	
	ResultEntity<User> updateUser(User user);
	
	User getUserById(int id);
	
	ResultEntity<Object> deleteUserById(int id);
	
	PageInfo<User> getUsersBySearchBean(SearchBean searchBean);
	
	UserVo getUserVoById(int id);
	
}
