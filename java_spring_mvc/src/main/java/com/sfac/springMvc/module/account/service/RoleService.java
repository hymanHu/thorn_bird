package com.sfac.springMvc.module.account.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sfac.springMvc.module.account.entity.Role;
import com.sfac.springMvc.module.common.entity.ResultEntity;
import com.sfac.springMvc.module.common.entity.SearchBean;

/**
 * Description: Role Service
 * @author HymanHu
 * @date 2021-01-28 09:24:05
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
