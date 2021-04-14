package com.sfac.scAccount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.sfac.common.entity.account.Resource;
import com.sfac.common.entity.common.ResultEntity;
import com.sfac.common.entity.common.SearchBean;
import com.sfac.scAccount.service.ResourceService;

/**
 * @Description: Resource Controller
 * @author: HymanHu
 * @date: 2021年2月21日
 */
@RestController
@RequestMapping("/api")
public class ResourceController {

	@Autowired
	private ResourceService resourceService;
	
	/**
	 * 127.0.0.1/api/resource ---- post
	 * {"permission":"deleteUser"}
	 */
	@PostMapping(value = "/resource", consumes = "application/json")
	public ResultEntity<Resource> insertResource(@RequestBody Resource resource) {
		return resourceService.insertResource(resource);
	}
	
	/**
	 * 127.0.0.1/api/resource ---- put
	 * {"id":"1","permission":"deleteUser"}
	 */
	@PutMapping(value = "/resource", consumes = "application/json")
	public ResultEntity<Resource> updateResource(@RequestBody Resource resource) {
		return resourceService.updateResource(resource);
	}
	
	/**
	 * 127.0.0.1/api/resource/2 ---- delete
	 */
	@DeleteMapping("/resource/{id}")
	public ResultEntity<Object> deleteResourceById(@PathVariable int id) {
		return resourceService.deleteResourceById(id);
	}
	
	/**
	 * 127.0.0.1/api/resource/1 ---- get
	 */
	@GetMapping("/resource/{id}")
	public Resource getResourceById(@PathVariable int id) {
		return resourceService.getResourceById(id);
	}
	
	/**
	 * 127.0.0.1/api/resources ---- post
	 * {"currentPage":"1","pageSize":"5","orderBy":"id","direction":"desc","keyWord":""}
	 */
	@PostMapping(value = "/resources", consumes = "application/json")
	public PageInfo<Resource> getResourcesBySearchBean(@RequestBody SearchBean searchBean) {
		return resourceService.getResourcesBySearchBean(searchBean);
	}
}
