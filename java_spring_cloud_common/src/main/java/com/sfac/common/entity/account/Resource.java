package com.sfac.common.entity.account;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sfac.common.entity.common.AbstractEntity;

/**
 * @Description: Resource
 * @author: HymanHu
 * @date: 2021年2月21日
 */
@Entity
@Table(name = "account_resource")
public class Resource extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	private String permission;
	@Transient
	private List<Role> roles;

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
