package com.sfac.springBoot.modules.account.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sfac.springBoot.modules.account.entity.Role;
import com.sfac.springBoot.modules.common.entity.ResultEntity;
import com.sfac.springBoot.modules.common.entity.SearchBean;

/**
 * @Description: Role Service
 * @author: HymanHu
 * @date: 2021年2月21日
 */
public interface RoleService {
	
	ResultEntity<Role> insertRole(Role role);
	
	ResultEntity<Role> updateRole(Role role);
	
	ResultEntity<Object> deleteRoelById(int id);
	
	Role getRoleById(int id);
	
	List<Role> getRolesByUserId(int userId);
	
	List<Role> getRoles();
	
	PageInfo<Role> getRolesBySearchBean(SearchBean searchBean);
}
