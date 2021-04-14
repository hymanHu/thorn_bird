package com.sfac.scAccount.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sfac.common.entity.account.Role;
import com.sfac.common.entity.common.ResultEntity;
import com.sfac.common.entity.common.SearchBean;

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
