package com.sfac.springMvc.module.account.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sfac.springMvc.module.account.dao.RoleDao;
import com.sfac.springMvc.module.account.entity.Role;
import com.sfac.springMvc.module.account.service.RoleService;

/**
 * Description: 
 * @author HymanHu
 * @date 2021-01-28 09:25:12
 */
@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDao roleDao;

	@Override
	public List<Role> getRolesByUserId(int userId) {
		return Optional.ofNullable(roleDao.getRolesByUserId(userId)).orElse(Collections.emptyList());
	}

}
