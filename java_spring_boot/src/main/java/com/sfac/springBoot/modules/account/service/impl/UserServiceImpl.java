package com.sfac.springBoot.modules.account.service.impl;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.sfac.springBoot.util.RedisUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sfac.springBoot.modules.account.dao.UserDao;
import com.sfac.springBoot.modules.account.dao.UserRoleDao;
import com.sfac.springBoot.modules.account.entity.User;
import com.sfac.springBoot.modules.account.entity.UserRole;
import com.sfac.springBoot.modules.account.service.UserService;
import com.sfac.springBoot.modules.common.entity.ResultEntity;
import com.sfac.springBoot.modules.common.entity.SearchBean;
import com.sfac.springBoot.util.MD5Util;

/**
 * @Description: User Service Impl
 * @author: HymanHu
 * @date: 2021年2月21日
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserRoleDao userRoleDao;
	@Autowired
	private RedisUtils redisUtils;

	@Override
	public User getUserByUserNameAndPassword(String userName, String password) {
		return userDao.getUserByUserNameAndPassword(userName, MD5Util.getMD5(password));
	}

	@Override
	public User getUserByUserName(String userName) {
		List<User> users = Optional
				.ofNullable(userDao.getUserByUserName(userName))
				.orElse(Collections.emptyList());
		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	public ResultEntity<User> login(User user) {
		String key = String.format("login_failed_count_%s", user.getUserName());
		Object temp = redisUtils.get(key);
		int count = temp == null ? 0 : (int)temp;
		if (count >= 5) {
			return new ResultEntity<User>(ResultEntity.ResultStatus.FAILED.status,
					"登录失败 5 次，锁住账户 30 秒.");
		}

		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
				user.getUserName(), MD5Util.getMD5(user.getPassword()));
		usernamePasswordToken.setRememberMe(user.getRememberMe());

		try {
			subject.login(usernamePasswordToken);
			subject.checkRoles();
			
			Session session = subject.getSession();
			session.setAttribute("user", subject.getPrincipal());
		} catch (Exception e) {
			e.printStackTrace();
//			return new ResultEntity<User>(ResultEntity.ResultStatus.FAILED.status, "Credentials faild");
			
			// 登录失败，累计登录失败次数
			if (count < 4) {
				redisUtils.increment(key, 1);
				return new ResultEntity<User>(ResultEntity.ResultStatus.FAILED.status,
						String.format("用户或密码错误，登录失败，还剩余%s次机会。", (4 - count)));
			} else {
				redisUtils.increment(key, 1);
				redisUtils.expire(key, 30);
				return new ResultEntity<User>(ResultEntity.ResultStatus.FAILED.status,
						"用户或密码错误，登录失败 5 次，账户锁定 30 秒");
			}
		}

		return new ResultEntity<User>(ResultEntity.ResultStatus.SUCCESS.status, "Success", user);
	}

	@Override
	public void logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
	}

	@Override
	@Transactional
	public ResultEntity<User> insertUser(User user) {
		List<User> users = Optional
				.ofNullable(userDao.getUserByUserNameOrEmail(user.getEmail(), user.getUserName()))
				.orElse(Collections.emptyList());
		if (users.size() > 0) {
			return new ResultEntity<User>(ResultEntity.ResultStatus.FAILED.status, "User Name or email is repeat.");
		}
		
		user.setCreateDate(LocalDateTime.now());
		user.setPassword(MD5Util.getMD5(user.getPassword()));
		userDao.insertUser(user);
		if (user.getRoles() != null) {
			user.getRoles().stream()
				.forEach(item -> {userRoleDao.insertUserRole(new UserRole(user.getId(), item.getId()));});
		}
		return new ResultEntity<User>(ResultEntity.ResultStatus.SUCCESS.status, "Insert success", user);
	}

	@Override
	@Transactional
	public ResultEntity<User> updateUser(User user) {
		List<User> users = Optional
				.ofNullable(userDao.getUserByUserNameOrEmail(user.getEmail(), user.getUserName()))
				.orElse(Collections.emptyList());
		if (users.stream().filter(item -> item.getId() != user.getId()).count() > 0) {
			return new ResultEntity<User>(ResultEntity.ResultStatus.FAILED.status, "User Name or email is repeat.");
		}
		
		userDao.updateUser(user);
		if (user.getRoles() != null && !user.getRoles().isEmpty()) {
			userRoleDao.deleteUserRoleByUserId(user.getId());
			user.getRoles().stream()
				.forEach(item -> {userRoleDao.insertUserRole(new UserRole(user.getId(), item.getId()));});
		}
		
		// 修改 Session 与 Principal
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		session.setAttribute("user", user);
		PrincipalCollection oldPrincipal = subject.getPrincipals();
		String realmName = oldPrincipal.getRealmNames().iterator().next();
		SimplePrincipalCollection newPrincipal =
				new SimplePrincipalCollection(user, realmName);
		subject.runAs(newPrincipal);
		
		return new ResultEntity<User>(ResultEntity.ResultStatus.SUCCESS.status, "Update success", user);
	}

	@Override
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	@Override
	@Transactional
	public ResultEntity<Object> deleteUserById(int id) {
		userDao.deleteUserById(id);
		userRoleDao.deleteUserRoleByUserId(id);
		return new ResultEntity<Object>(ResultEntity.ResultStatus.SUCCESS.status, "Delete success");
	}

	@Override
	public PageInfo<User> getUsersBySearchBean(SearchBean searchBean) {
		searchBean.initSearchBean();
		PageHelper.startPage(searchBean.getCurrentPage(), searchBean.getPageSize());
		return new PageInfo<User>(Optional
				.ofNullable(userDao.getUsersBySearchVo(searchBean))
				.orElse(Collections.emptyList()));
	}
}
