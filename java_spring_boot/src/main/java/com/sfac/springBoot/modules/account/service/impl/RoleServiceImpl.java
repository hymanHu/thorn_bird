package com.sfac.springBoot.modules.account.service.impl;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sfac.springBoot.modules.account.dao.RoleDao;
import com.sfac.springBoot.modules.account.dao.RoleResourceDao;
import com.sfac.springBoot.modules.account.dao.UserRoleDao;
import com.sfac.springBoot.modules.account.entity.Role;
import com.sfac.springBoot.modules.account.service.RoleService;
import com.sfac.springBoot.modules.common.entity.ResultEntity;
import com.sfac.springBoot.modules.common.entity.SearchBean;

/**
 * @Description: Role Service Impl
 * @author: HymanHu
 * @date: 2021年2月21日
 */
@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private UserRoleDao userRoleDao;
	@Autowired
	private RoleResourceDao roleResourceDao;

	@Override
	@Transactional
	public ResultEntity<Role> insertRole(Role role) {
		role.setCreateDate(LocalDateTime.now());
		roleDao.insertRole(role);
		return new ResultEntity<Role>(ResultEntity.ResultStatus.SUCCESS.status, "Insert success", role);
	}

	@Override
	@Transactional
	public ResultEntity<Role> updateRole(Role role) {
		roleDao.updateRole(role);
		return new ResultEntity<Role>(ResultEntity.ResultStatus.SUCCESS.status, "Update success", role);
	}

	@Override
	@Transactional
	public ResultEntity<Object> deleteRoelById(int id) {
		roleDao.deleteRoelById(id);
		userRoleDao.deleteUserRoleByRoleId(id);
		roleResourceDao.deleteRoleResourceByRoleId(id);
		return new ResultEntity<Object>(ResultEntity.ResultStatus.SUCCESS.status, "Delete success");
	}

	@Override
	public Role getRoleById(int id) {
		return roleDao.getRoleById(id);
	}

	@Override
	public List<Role> getRolesByUserId(int userId) {
		return Optional.ofNullable(roleDao.getRolesByUserId(userId)).orElse(Collections.emptyList());
	}

	@Override
	public List<Role> getRoles() {
		return Optional.ofNullable(roleDao.getRoles()).orElse(Collections.emptyList());
	}

	@Override
	public PageInfo<Role> getRolesBySearchBean(SearchBean searchBean) {
		searchBean.initSearchBean();
		PageHelper.startPage(searchBean.getCurrentPage(), searchBean.getPageSize());
		return new PageInfo<Role>(Optional
				.ofNullable(roleDao.getRolesBySearchBean(searchBean))
				.orElse(Collections.emptyList()));
	}

}
