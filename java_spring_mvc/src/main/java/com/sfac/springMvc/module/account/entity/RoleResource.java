package com.sfac.springMvc.module.account.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Description: Role Resource
 * @author HymanHu
 * @date 2021-01-27 09:38:56
 */
@Entity
@Table(name = "account_role_resource")
public class RoleResource {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Integer id;
	private Integer roleId;
	private Integer resourceId;

	public RoleResource() {
	}

	public RoleResource(Integer roleId, Integer resourceId) {
		this.roleId = roleId;
		this.resourceId = resourceId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

}
