package com.sfac.springMvc.module.humanNature.entity;

/**
 * @Description: Track Type Vo
 * @author: HymanHu
 * @date: 2021年2月12日
 */
public class TrackTypeVo {

	private String type;
	private int count;
	private double percent;
	private double assessment;
	private String label;
	private String yearMounth;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}

	public double getAssessment() {
		return assessment;
	}

	public void setAssessment(double assessment) {
		this.assessment = assessment;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getYearMounth() {
		return yearMounth;
	}

	public void setYearMounth(String yearMounth) {
		this.yearMounth = yearMounth;
	}

}
