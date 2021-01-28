package com.sfac.springMvc.module.account.service;

import java.util.List;

import com.sfac.springMvc.module.account.entity.Role;

/**
 * Description: Role Service
 * @author HymanHu
 * @date 2021-01-28 09:24:05
 */
public interface RoleService {
	
	List<Role> getRolesByUserId(int userId);
}
