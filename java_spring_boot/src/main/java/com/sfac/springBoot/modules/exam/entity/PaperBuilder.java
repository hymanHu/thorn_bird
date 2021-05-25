package com.sfac.springBoot.modules.exam.entity;

import java.util.List;

/**
 * Description: Paper Builder
 * @author HymanHu
 * @date 2020-12-21 14:58:08
 */
public class PaperBuilder {
	private String paperTitle;
	private String paperFlage;
	private List<String> paperTypes;
	private int paperTime;

	public String getPaperTitle() {
		return paperTitle;
	}

	public void setPaperTitle(String paperTitle) {
		this.paperTitle = paperTitle;
	}

	public String getPaperFlage() {
		return paperFlage;
	}

	public void setPaperFlage(String paperFlage) {
		this.paperFlage = paperFlage;
	}

	public List<String> getPaperTypes() {
		return paperTypes;
	}

	public void setPaperTypes(List<String> paperTypes) {
		this.paperTypes = paperTypes;
	}

	public int getPaperTime() {
		return paperTime;
	}

	public void setPaperTime(int paperTime) {
		this.paperTime = paperTime;
	}
}
