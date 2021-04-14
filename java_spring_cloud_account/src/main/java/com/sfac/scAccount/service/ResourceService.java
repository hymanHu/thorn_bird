package com.sfac.scAccount.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sfac.common.entity.account.Resource;
import com.sfac.common.entity.common.ResultEntity;
import com.sfac.common.entity.common.SearchBean;

/**
 * @Description: Resource Service
 * @author: HymanHu
 * @date: 2021年2月21日
 */
public interface ResourceService {

	ResultEntity<Resource> insertResource(Resource resource);
	
	ResultEntity<Resource> updateResource(Resource resource);
	
	ResultEntity<Object> deleteResourceById(int id);
	
	Resource getResourceById(int id);
	
	List<Resource> getResourcesByRoleId(int roleId);
	
	PageInfo<Resource> getResourcesBySearchBean(SearchBean searchBean);
}
