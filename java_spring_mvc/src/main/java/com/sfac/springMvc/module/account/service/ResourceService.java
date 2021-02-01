package com.sfac.springMvc.module.account.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sfac.springMvc.module.account.entity.Resource;
import com.sfac.springMvc.module.common.entity.ResultEntity;
import com.sfac.springMvc.module.common.entity.SearchBean;

/**
 * Description: Resource Service
 * @author HymanHu
 * @date 2021-02-01 10:06:06
 */
public interface ResourceService {

	ResultEntity<Resource> insertResource(Resource resource);
	
	ResultEntity<Resource> updateResource(Resource resource);
	
	ResultEntity<Object> deleteResourceById(int id);
	
	Resource getResourceById(int id);
	
	List<Resource> getResourcesByRoleId(int roleId);
	
	PageInfo<Resource> getResourcesBySearchBean(SearchBean searchBean);
}
