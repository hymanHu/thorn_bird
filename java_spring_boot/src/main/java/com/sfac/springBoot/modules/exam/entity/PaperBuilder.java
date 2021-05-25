package com.sfac.springBoot.modules.exam.entity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Description: Paper Builder
 * @author HymanHu
 * @date 2020-12-21 14:58:08
 */
public class PaperBuilder {
	private String paperTitle;
	private String paperFlage;
	private List<String> paperTypes;
	private String paperTypesString;
	private int paperTime;
	
	public void initPaperTypesString() {
		if (this.getPaperTypes() != null) {
			this.setPaperTypesString(String.join(",", 
					this.getPaperTypes().stream()
						.map(item -> String.format("'%s'", item))
						.collect(Collectors.toList())));
		}
	}

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

	public String getPaperTypesString() {
		return paperTypesString;
	}

	public void setPaperTypesString(String paperTypesString) {
		this.paperTypesString = paperTypesString;
	}

	public int getPaperTime() {
		return paperTime;
	}

	public void setPaperTime(int paperTime) {
		this.paperTime = paperTime;
	}
}
