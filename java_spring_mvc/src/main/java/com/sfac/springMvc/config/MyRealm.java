package com.sfac.springMvc.config;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.sfac.springMvc.module.account.entity.Resource;
import com.sfac.springMvc.module.account.entity.Role;
import com.sfac.springMvc.module.account.entity.User;
import com.sfac.springMvc.module.account.service.ResourceService;
import com.sfac.springMvc.module.account.service.RoleService;
import com.sfac.springMvc.module.account.service.UserService;

/**
 * Description: My Realm
 * @author HymanHu
 * @date 2021-02-05 09:47:36
 */
public class MyRealm extends AuthorizingRealm {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private ResourceService resourceService;

	/**
	 * -资源授权器
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 授权类
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        
		User user = (User) principals.getPrimaryPrincipal();
		if (user == null) {
			return null;
		}
		
		List<Role> roles = Optional
				.ofNullable(roleService.getRolesByUserId(user.getId()))
				.orElse(Collections.emptyList());
		roles.stream().forEach(role -> {
			authorizationInfo.addRole(role.getRoleName());
			List<Resource> resources = Optional
					.ofNullable(resourceService.getResourcesByRoleId(role.getId()))
					.orElse(Collections.emptyList());
			resources.stream().forEach(resource -> {
				authorizationInfo.addStringPermission(resource.getPermission());
			});
		});
		
		return authorizationInfo;
	}

	/**
	 * -身份验证器
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName = (String) token.getPrincipal();
		User user = userService.getUserByUserName(userName);
		if (user == null) {
			throw new UnknownAccountException("The account do not exist.");
		}
		
		// realmName: 当前 realm 对象的唯一名字. 调用父类的 getName() 方法
        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
	}

}
