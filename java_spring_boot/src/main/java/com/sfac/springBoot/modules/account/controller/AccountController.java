package com.sfac.springBoot.modules.account.controller;

import com.sfac.springBoot.modules.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Description: Account Controller
 * @author HymanHu
 * @date 2021-02-22 08:40:24
 */
@Controller
public class AccountController {

	@Autowired
	private UserService userService;
	
	/**
	 * 127.0.0.1/login ---- get
	 */
	@GetMapping("/login")
	public String loginPage(ModelMap modelMap) {
		modelMap.addAttribute("template", "account/login");
		return "indexSimple";
	}

	/**
	 * 127.0.0.1/logout ---- get
	 */
	@GetMapping("/logout")
	public String logout() {
		userService.logout();
		return "redirect:/login";
	}
	
	/**
	 * 127.0.0.1/register ---- get
	 */
	@GetMapping("/register")
	public String registerPage(ModelMap modelMap) {
		modelMap.addAttribute("template", "account/register");
		return "indexSimple";
	}
	
	/**
	 * 127.0.0.1/account/users ---- get
	 */
	@GetMapping("/account/users")
	public String usersPage() {
		return "index";
	}

	/**
	 * 127.0.0.1/account/roles ---- get
	 */
	@GetMapping("/account/roles")
	public String rolesPage() {
		return "index";
	}

	/**
	 * 127.0.0.1/account/resources ---- get
	 */
	@GetMapping("/account/resources")
	public String resourcesPage() {
		return "index";
	}

	/**
	 * 127.0.0.1/account/profile ---- get
	 */
	@GetMapping("/account/profile")
	public String profilePage() {
		return "index";
	}
}
