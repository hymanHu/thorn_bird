package com.sfac.scAccount.entity;

import com.sfac.common.entity.account.User;
import com.sfac.common.entity.test.City;

/**
 * Description: Account
 * @author HymanHu
 * @date 2021-04-15 08:51:43
 */
public class UserVo extends User {
	private static final long serialVersionUID = 1L;

	private City city;

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}
