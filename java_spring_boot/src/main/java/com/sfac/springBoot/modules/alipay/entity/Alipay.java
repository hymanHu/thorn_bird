package com.sfac.springBoot.modules.alipay.entity;

/**
 * Description: Alipay
 * @author HymanHu
 * @date 2021-03-29 14:36:18
 */
public class Alipay {
	// 商户订单号，需要保证不重复
	private String outTradeNo;
	// 订单金额
	private String totalAmount;
	// 订单标题
	private String subject;
	// 订单描述
	private String body;

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
