package com.sfac.springBoot.modules.parking.entity;

import java.time.LocalDateTime;

import com.sfac.springBoot.modules.common.entity.AbstractEntity;

public class Charge extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	private String carLicense;
	private String type;
	private int stationmentId;
	private LocalDateTime start;
	private LocalDateTime end;
	private int sum;
	private double fee;

	public String getCarLicense() {
		return carLicense;
	}

	public void setCarLicense(String carLicense) {
		this.carLicense = carLicense;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getStationmentId() {
		return stationmentId;
	}

	public void setStationmentId(int stationmentId) {
		this.stationmentId = stationmentId;
	}

	public LocalDateTime getStart() {
		return start;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}

	public LocalDateTime getEnd() {
		return end;
	}

	public void setEnd(LocalDateTime end) {
		this.end = end;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

}
