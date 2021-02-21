package com.sfac.springBoot.modules.account.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.sfac.springBoot.modules.common.entity.AbstractEntity;

/**
 * @Description: Role
 * @author: HymanHu
 * @date: 2021年2月21日
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
