package com.sfac.javaEe.entity.common;

import org.apache.commons.lang3.StringUtils;

/**
 * @Description: Search Bean
 * @author: HymanHu
 * @date: 2020年12月11日
 */
public class SearchBean {

	public final static int DEFAULT_CURRENT_PAGE = 1;
	public final static int DEFAULT_PAGE_SIZE = 5;

	private int currentPage;
	private int pageSize;
	private String keyWord;
	private String orderBy;
	private String direction;

	public void initSearchBean() {
		if (this != null) {
			this.setCurrentPage(this.getCurrentPage() == 0 ? DEFAULT_CURRENT_PAGE : this.getCurrentPage());
			this.setPageSize(this.getPageSize() == 0 ? DEFAULT_PAGE_SIZE : this.getPageSize());
			this.setDirection(StringUtils.isBlank(this.getDirection()) ? "asc" : this.getDirection());
		}
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
}
