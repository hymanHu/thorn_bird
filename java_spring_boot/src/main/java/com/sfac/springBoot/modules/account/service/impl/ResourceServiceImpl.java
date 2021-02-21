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
import com.sfac.springBoot.modules.account.dao.ResourceDao;
import com.sfac.springBoot.modules.account.dao.RoleResourceDao;
import com.sfac.springBoot.modules.account.entity.Resource;
import com.sfac.springBoot.modules.account.entity.RoleResource;
import com.sfac.springBoot.modules.account.service.ResourceService;
import com.sfac.springBoot.modules.common.entity.ResultEntity;
import com.sfac.springBoot.modules.common.entity.SearchBean;

/**
 * @Description: Resource Service Impl
 * @author: HymanHu
 * @date: 2021年2月21日
 */
@Service
public class ResourceServiceImpl implements ResourceService {
	
	@Autowired
	private ResourceDao resourceDao;
	@Autowired
	private RoleResourceDao roleResourceDao;

	@Override
	@Transactional
	public ResultEntity<Resource> insertResource(Resource resource) {
		resource.setCreateDate(LocalDateTime.now());
		resourceDao.insertResource(resource);
		if (resource.getRoles() != null) {
			resource.getRoles().stream()
				.forEach(item -> {
					roleResourceDao.insertRoleResource(new RoleResource(item.getId(), resource.getId()));
				});
		}
		return new ResultEntity<Resource>(ResultEntity.ResultStatus.SUCCESS.status, "Insert success", resource);
	}

	@Override
	@Transactional
	public ResultEntity<Resource> updateResource(Resource resource) {
		resourceDao.updateResource(resource);
		roleResourceDao.deleteRoleResourceByResourceId(resource.getId());
		if (resource.getRoles() != null) {
			resource.getRoles().stream()
				.forEach(item -> {roleResourceDao.insertRoleResource(new RoleResource(item.getId(), resource.getId()));});
		}
		return new ResultEntity<Resource>(ResultEntity.ResultStatus.SUCCESS.status, "Update success", resource);
	}
	
	@Override
	@Transactional
	public ResultEntity<Object> deleteResourceById(int id) {
		resourceDao.deleteResourceById(id);
		roleResourceDao.deleteRoleResourceByResourceId(id);
		return new ResultEntity<Object>(ResultEntity.ResultStatus.SUCCESS.status, "Delete success");
	}

	@Override
	public Resource getResourceById(int id) {
		return resourceDao.getResourceById(id);
	}

	@Override
	public List<Resource> getResourcesByRoleId(int roleId) {
		return resourceDao.getResourcesByRoleId(roleId);
	}

	@Override
	public PageInfo<Resource> getResourcesBySearchBean(SearchBean searchBean) {
		searchBean.initSearchBean();
		PageHelper.startPage(searchBean.getCurrentPage(), searchBean.getPageSize());
		return new PageInfo<Resource>(Optional
				.ofNullable(resourceDao.getResourcesBySearchBean(searchBean))
				.orElse(Collections.emptyList()));
	}

}
