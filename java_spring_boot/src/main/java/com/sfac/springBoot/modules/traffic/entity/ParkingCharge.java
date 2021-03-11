package com.sfac.springBoot.modules.traffic.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.sfac.springBoot.modules.common.entity.AbstractEntity;

/**
 * Description: Parking Charge
 * @author HymanHu
 * @date 2021-03-11 16:00:29
 */
@Entity
@Table(name = "traffic_parking_charge")
public class ParkingCharge extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	private String carLicense;
	private int chargeType; // 0：临停；1：包月用户
	private int parkingId;
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

	public int getChargeType() {
		return chargeType;
	}

	public void setChargeType(int chargeType) {
		this.chargeType = chargeType;
	}

	public int getParkingId() {
		return parkingId;
	}

	public void setParkingId(int parkingId) {
		this.parkingId = parkingId;
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
