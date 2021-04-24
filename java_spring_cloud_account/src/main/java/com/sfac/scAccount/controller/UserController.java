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
import com.sfac.common.entity.account.User;
import com.sfac.common.entity.common.ResultEntity;
import com.sfac.common.entity.common.SearchBean;
import com.sfac.scAccount.entity.UserVo;
import com.sfac.scAccount.service.UserService;

/**
 * @Description: User Controller
 * @author: HymanHu
 * @date: 2021年2月21日
 */
@RestController
@RequestMapping("/api/account")
public class UserController {
	
	@Autowired
	private UserService userService;

	/**
	 * 127.0.0.1/api/account/user ---- post
	 * {"userName":"admin", "password":"111111"}
	 */
	@PostMapping(value = "/user", consumes = "application/json")
	public ResultEntity<User> insertUser(@RequestBody User user) {
		return userService.insertUser(user);
	}
	
	/**
	 * 127.0.0.1/api/account/user ---- put
	 * {"id":"1", "userName":"admin", "password":"111111"}
	 */
	@PutMapping(value = "/user", consumes = "application/json")
	public ResultEntity<User> updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	/**
	 * 127.0.0.1/api/account/user/1 ---- get
	 */
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}
	
	/**
	 * 127.0.0.1/api/account/userVo/1 ---- get
	 */
	@GetMapping("/userVo/{id}")
	public UserVo getUserVoById(@PathVariable int id) {
		return userService.getUserVoById(id);
	}
	
	/**
	 * 127.0.0.1/api/account/user/1 ---- delete
	 */
	@DeleteMapping("/user/{id}")
	public ResultEntity<Object> deleteUserById(@PathVariable int id) {
		return userService.deleteUserById(id);
	}
	
	/**
	 * 127.0.0.1/api/account/users ---- post
	 * {"currentPage":"1","pageSize":"5","orderBy":"id","direction":"desc","keyWord":""}
	 */
	@PostMapping(value = "/users", consumes = "application/json")
	public PageInfo<User> getUsersBySearchBean(@RequestBody SearchBean searchBean) {
		return userService.getUsersBySearchBean(searchBean);
	}
}
