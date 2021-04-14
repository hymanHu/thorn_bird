package com.sfac.scAccount.config;

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
import org.springframework.stereotype.Component;

import com.sfac.common.entity.account.Resource;
import com.sfac.common.entity.account.Role;
import com.sfac.common.entity.account.User;
import com.sfac.scAccount.service.ResourceService;
import com.sfac.scAccount.service.RoleService;
import com.sfac.scAccount.service.UserService;

/**
 * Description: My Realm
 * @author HymanHu
 * @date 2021-02-05 09:47:36
 */
@Component
public class MyRealm extends AuthorizingRealm {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private ResourceService resourceService;

	/**
	 * - 资源授权器
	 * - 将当前用户对应的角色信息，以及角色所拥有的资源信息放入验证器
	 * - 通过前端页面 shiro 标签、控制器方法 shiro 注解与验证器比对，实现用户资源授权功能
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
		
		/**
		 * principal: 当前用户信息，可以是user对象，也可以是用户名
		 * credentials: 当前用户凭证
		 * realmName: 当前 realm 对象的唯一名字
		 */
        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
	}
}
