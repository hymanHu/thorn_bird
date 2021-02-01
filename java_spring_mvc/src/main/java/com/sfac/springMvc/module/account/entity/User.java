package com.sfac.springMvc.module.account.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sfac.springMvc.module.common.entity.AbstractEntity;

/**
 * Description: User
 * @author HymanHu
 * @date 2021-01-27 09:30:35
 */
@Entity
@Table(name = "account_user")
public class User extends AbstractEntity {
	@Column(unique = true)
	private String email;
	@Column(unique = true)
	private String userName;
	private String password;
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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
