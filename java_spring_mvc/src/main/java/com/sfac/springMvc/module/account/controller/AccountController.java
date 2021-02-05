package com.sfac.springMvc.module.account.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Description: Account Controller
 * @author HymanHu
 * @date 2021-02-01 10:44:59
 */
@Controller
public class AccountController {

	/**
	 * 127.0.0.1/register
	 */
	@GetMapping("/register")
	public String registerPage() {
		return "account/register";
	}
	
	/**
	 * 127.0.0.1/login
	 */
	@GetMapping("/login")
	public String loginPage() {
		return "account/login";
	}
	
	/**
	 * 127.0.0.1/logout
	 */
	@GetMapping("/logout")
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		
		return "redirect:/login";
	}
	
	/**
	 * 127.0.0.1/forgot
	 */
	@GetMapping("/forgot")
	public String forgotPage() {
		return "account/forgot";
	}
	
	/**
	 * 127.0.0.1/account/users
	 */
	@GetMapping("/account/users")
	public String usersPage() {
		return "account/users";
	}
	
	/**
	 * 127.0.0.1/account/roles
	 */
	@GetMapping("/account/roles")
	public String rolesPage() {
		return "account/roles";
	}
	
	/**
	 * 127.0.0.1/account/resources
	 */
	@GetMapping("/account/resources")
	public String resourcesPage() {
		return "account/resources";
	}
	
	/**
	 * 127.0.0.1/account/profile
	 */
	@GetMapping("/account/profile")
	public String profilePage() {
		return "account/profile";
	}
}
