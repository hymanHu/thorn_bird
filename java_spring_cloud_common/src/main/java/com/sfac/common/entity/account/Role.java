package com.sfac.common.entity.account;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.sfac.common.entity.common.AbstractEntity;

/**
 * @Description: Role
 * @author: HymanHu
 * @date: 2021年2月21日
 */
@Entity
@Table(name = "account_role")
public class Role extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
