package com.sfac.springBoot.modules.account.controller;

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
	
	/**
	 * 127.0.0.1/login ---- get
	 */
	@GetMapping("/login")
	public String loginPage(ModelMap modelMap) {
		modelMap.addAttribute("template", "account/login");
		return "indexSimple";
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
}
