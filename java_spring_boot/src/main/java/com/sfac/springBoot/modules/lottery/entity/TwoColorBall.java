package com.sfac.springBoot.modules.lottery.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.sfac.springBoot.modules.common.entity.AbstractEntity;

/**
 * @Description: Two Color Ball ---- 双色球
 * @author: HymanHu
 * @date: 2021年7月17日
 */
@Entity
@Table(name = "lottery_twocolorball")
public class TwoColorBall extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	private String issue; // 期号
	private String openTime; // 开奖时间
	private String frontWinningNum; // 红球数字，空格间隔，大小排序
	private String seqFrontWinningNum; // 红球数字，空格间隔，出球排序
	private String backWinningNum; // 篮球数字
	private String seqBackWinningNum; // 篮球数字
	private double saleMoney; // 销售金额
	private double prizePoolMoney; // 奖金池金额
	private int firstAwardNum; // 一等奖数量
	private double firstAwardMoney; // 一等奖数量金额
	private int secondAwardNum; // 二等奖数量
	private double secondAwardMoney; // 二等奖数量金额
	private int thirdAwardNum; // 三等奖数量
	private double thirdAwardMoney; // 三等奖数量金额
	private int fourthAwardNum; // 四等奖数量
	private double fourthAwardMoney; // 四等奖数量金额
	private int fifthAwardNum; // 五等奖数量
	private double fifthAwardMoney; // 五等奖数量金额
	private int sixthAwardNum; // 六等奖数量
	private double sixthAwardMoney; // 六等奖数量金额

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getFrontWinningNum() {
		return frontWinningNum;
	}

	public void setFrontWinningNum(String frontWinningNum) {
		this.frontWinningNum = frontWinningNum;
	}

	public String getSeqFrontWinningNum() {
		return seqFrontWinningNum;
	}

	public void setSeqFrontWinningNum(String seqFrontWinningNum) {
		this.seqFrontWinningNum = seqFrontWinningNum;
	}

	public String getBackWinningNum() {
		return backWinningNum;
	}

	public void setBackWinningNum(String backWinningNum) {
		this.backWinningNum = backWinningNum;
	}

	public String getSeqBackWinningNum() {
		return seqBackWinningNum;
	}

	public void setSeqBackWinningNum(String seqBackWinningNum) {
		this.seqBackWinningNum = seqBackWinningNum;
	}

	public double getSaleMoney() {
		return saleMoney;
	}

	public void setSaleMoney(double saleMoney) {
		this.saleMoney = saleMoney;
	}

	public double getPrizePoolMoney() {
		return prizePoolMoney;
	}

	public void setPrizePoolMoney(double prizePoolMoney) {
		this.prizePoolMoney = prizePoolMoney;
	}

	public int getFirstAwardNum() {
		return firstAwardNum;
	}

	public void setFirstAwardNum(int firstAwardNum) {
		this.firstAwardNum = firstAwardNum;
	}

	public double getFirstAwardMoney() {
		return firstAwardMoney;
	}

	public void setFirstAwardMoney(double firstAwardMoney) {
		this.firstAwardMoney = firstAwardMoney;
	}

	public int getSecondAwardNum() {
		return secondAwardNum;
	}

	public void setSecondAwardNum(int secondAwardNum) {
		this.secondAwardNum = secondAwardNum;
	}

	public double getSecondAwardMoney() {
		return secondAwardMoney;
	}

	public void setSecondAwardMoney(double secondAwardMoney) {
		this.secondAwardMoney = secondAwardMoney;
	}

	public int getThirdAwardNum() {
		return thirdAwardNum;
	}

	public void setThirdAwardNum(int thirdAwardNum) {
		this.thirdAwardNum = thirdAwardNum;
	}

	public double getThirdAwardMoney() {
		return thirdAwardMoney;
	}

	public void setThirdAwardMoney(double thirdAwardMoney) {
		this.thirdAwardMoney = thirdAwardMoney;
	}

	public int getFourthAwardNum() {
		return fourthAwardNum;
	}

	public void setFourthAwardNum(int fourthAwardNum) {
		this.fourthAwardNum = fourthAwardNum;
	}

	public double getFourthAwardMoney() {
		return fourthAwardMoney;
	}

	public void setFourthAwardMoney(double fourthAwardMoney) {
		this.fourthAwardMoney = fourthAwardMoney;
	}

	public int getFifthAwardNum() {
		return fifthAwardNum;
	}

	public void setFifthAwardNum(int fifthAwardNum) {
		this.fifthAwardNum = fifthAwardNum;
	}

	public double getFifthAwardMoney() {
		return fifthAwardMoney;
	}

	public void setFifthAwardMoney(double fifthAwardMoney) {
		this.fifthAwardMoney = fifthAwardMoney;
	}

	public int getSixthAwardNum() {
		return sixthAwardNum;
	}

	public void setSixthAwardNum(int sixthAwardNum) {
		this.sixthAwardNum = sixthAwardNum;
	}

	public double getSixthAwardMoney() {
		return sixthAwardMoney;
	}

	public void setSixthAwardMoney(double sixthAwardMoney) {
		this.sixthAwardMoney = sixthAwardMoney;
	}
}
