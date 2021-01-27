package com.sfac.springMvc.module.account.service;

import com.sfac.springMvc.module.account.entity.User;

/**
 * Description: User Service
 * @author HymanHu
 * @date 2021-01-27 09:49:32
 */
public interface UserService {
	
	User getUserByUserNameAndPassword(String userName, String password);
}
