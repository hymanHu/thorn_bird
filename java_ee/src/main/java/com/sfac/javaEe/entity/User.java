package com.sfac.javaEe.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Description: User
 * @author HymanHu
 * @date 2020-10-19 13:08:24
 */
public class User {
	private int id;
	private String userName;
	private String password;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
