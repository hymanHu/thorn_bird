package com.sfac.springBoot.modules.account.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sfac.springBoot.modules.common.entity.AbstractEntity;

/**
 * @Description: User
 * @author: HymanHu
 * @date: 2021年2月21日
 */
@Entity
@Table(name = "account_user")
public class User extends AbstractEntity {
	@Column(unique = true)
	private String email;
	@Column(unique = true)
	private String userName;
	private String password;
	private String userImage;
	@Transient
	private boolean rememberMe;
	@Transient
	private List<Role> roles;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public boolean getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
