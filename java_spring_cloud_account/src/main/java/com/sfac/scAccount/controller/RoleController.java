package com.sfac.scAccount.controller;

import java.util.List;

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
import com.sfac.common.entity.account.Role;
import com.sfac.common.entity.common.ResultEntity;
import com.sfac.common.entity.common.SearchBean;
import com.sfac.scAccount.service.RoleService;

/**
 * @Description: Role Controller
 * @author: HymanHu
 * @date: 2021年2月21日
 */
@RestController
@RequestMapping("/api/account")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	/**
	 * 127.0.0.1/api/account/role ---- post
	 * {"roleName":"admin"}
	 */
	@PostMapping(value = "/role", consumes = "application/json")
	public ResultEntity<Role> insertRole(@RequestBody Role role) {
		return roleService.insertRole(role);
	}
	
	/**
	 * 127.0.0.1/api/account/role ---- put
	 * {"id":"1", "roleName":"admin"}
	 */
	@PutMapping(value = "/role", consumes = "application/json")
	public ResultEntity<Role> updateRole(@RequestBody Role role) {
		return roleService.updateRole(role);
	}
	
	/**
	 * 127.0.0.1/api/account/role/3 ---- delete
	 */
	@DeleteMapping("/role/{id}")
	public ResultEntity<Object> deleteRoelById(@PathVariable int id) {
		return roleService.deleteRoelById(id);
	}
	
	/**
	 * 127.0.0.1/api/account/role/1 ---- get
	 */
	@GetMapping("/role/{id}")
	public Role getRoleById(@PathVariable int id) {
		return roleService.getRoleById(id);
	}
	
	/**
	 * 127.0.0.1/api/account/roles ---- get
	 */
	@GetMapping("/roles")
	public List<Role> getRoles() {
		return roleService.getRoles();
	}
	
	/**
	 * 127.0.0.1/api/account/roles ---- post
	 * {"currentPage":"1","pageSize":"5","orderBy":"id","direction":"desc","keyWord":""}
	 */
	@PostMapping(value = "/roles", consumes = "application/json")
	public PageInfo<Role> getRolesBySearchBean(@RequestBody SearchBean searchBean) {
		return roleService.getRolesBySearchBean(searchBean);
	}
}
