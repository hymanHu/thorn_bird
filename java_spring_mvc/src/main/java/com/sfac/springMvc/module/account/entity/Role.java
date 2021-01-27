package com.sfac.springMvc.module.account.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.sfac.springMvc.module.common.entity.AbstractEntity;

/**
 * Description: Role
 * @author HymanHu
 * @date 2021-01-27 09:30:18
 */
@Entity
@Table(name = "account_role")
public class Role extends AbstractEntity {
	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
