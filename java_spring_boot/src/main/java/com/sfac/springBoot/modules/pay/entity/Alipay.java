package com.sfac.springBoot.modules.pay.entity;

/**
 * Description: Alipay
 * - 参照 F2FPay_Demo_Java ---- TradePaySDK ---- AlipayTradePayRequestBuilder
 * @author HymanHu
 * @date 2021-03-29 14:36:18
 */
public class Alipay {
	// 支付场景，条码支付场景为 bar_code
	private String scene;
	// 付款条码，用户支付宝钱包手机 app 点击“付款”产生的付款条码
	private String authCode;
	// 商户网站订单系统中唯一订单号，64个字符以内，只能包含字母、数字、下划线
	private String outTradeNo;
	// 卖家支付宝账号ID，用于支持一个签约账号下支持打款到不同的收款账号
	private String sellerId;
	// 订单金额
	private String totalAmount;
	// 订单可打折金额，此处单位为元，精确到小数点后2位
	private String discountableAmount;
	// 订单不可打折金额，此处单位为元，精确到小数点后2位
	private String undiscountableAmount;
	// 订单标题
	private String subject;
	// 订单描述
	private String body;
	// 商户操作员编号，添加此参数可以为商户操作员做销售统计
	private String operatorId;
	// 商户门店编号
	private String storeId;
	// 支付宝商家平台中配置的商户门店号，详询支付宝技术支持
	private String alipayStoreId;
	// 商户机具终端编号，当以机具方式接入支付宝时必传，详询支付宝技术支持
	private String terminalId;
	// (推荐使用，相对时间) 支付超时时间，5m 5分钟
	private String timeoutExpress;

	public String getScene() {
		return scene;
	}

	public void setScene(String scene) {
		this.scene = scene;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getDiscountableAmount() {
		return discountableAmount;
	}

	public void setDiscountableAmount(String discountableAmount) {
		this.discountableAmount = discountableAmount;
	}

	public String getUndiscountableAmount() {
		return undiscountableAmount;
	}

	public void setUndiscountableAmount(String undiscountableAmount) {
		this.undiscountableAmount = undiscountableAmount;
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

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getAlipayStoreId() {
		return alipayStoreId;
	}

	public void setAlipayStoreId(String alipayStoreId) {
		this.alipayStoreId = alipayStoreId;
	}

	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public String getTimeoutExpress() {
		return timeoutExpress;
	}

	public void setTimeoutExpress(String timeoutExpress) {
		this.timeoutExpress = timeoutExpress;
	}
}
