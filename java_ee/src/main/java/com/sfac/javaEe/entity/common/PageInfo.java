package com.sfac.javaEe.entity.common;

import java.util.List;

/**
 * Description: Page Info
 * @author HymanHu
 * @date 2020-11-03 21:03:21
 */
public class PageInfo<T> {

	private int total;
	private List<T> list;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
