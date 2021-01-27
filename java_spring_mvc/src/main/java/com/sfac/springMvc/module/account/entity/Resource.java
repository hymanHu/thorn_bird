package com.sfac.springMvc.module.account.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sfac.springMvc.module.common.entity.AbstractEntity;

/**
 * Description: Resource
 * @author HymanHu
 * @date 2021-01-27 09:31:45
 */
@Entity
@Table(name = "account_resource")
public class Resource extends AbstractEntity {
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
