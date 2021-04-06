package com.sfac.springBoot.config.pay;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Description: Alipay Config Bean
 * @author HymanHu
 * @date 2021-03-29 14:16:30
 */
@Component
@PropertySource("classpath:config/alipayConfig.properties")
public class AlipayConfigBean {

	@Value("${alipayGateway}")
	private String alipayGateway;
	@Value("${mcloudApi}")
	private String mcloudApi;
	@Value("${pid}")
	private String pid;
	@Value("${appId}")
	private String appId;
	@Value("${privateKey}")
	private String privateKey;
	@Value("${publicKey}")
	private String publicKey;
	@Value("${alipayPublicKey}")
	private String alipayPublicKey;
	@Value("${notifyUrl}")
	private String notifyUrl;
	@Value("${returnUrl}")
	private String returnUrl;
	@Value("${signType}")
	private String signType;
	@Value("${maxQueryRetry}")
	private int maxQueryRetry;
	@Value("${queryDuration}")
	private int queryDuration;
	@Value("${maxCancelRetry}")
	private int maxCancelRetry;
	@Value("${cancelDuration}")
	private int cancelDuration;
	@Value("${heartbeatDelay}")
	private int heartbeatDelay;
	@Value("${heartbeatDuration}")
	private int heartbeatDuration;
	@Value("${charset}")
	private String charset;
	@Value("${format}")
	private String format;

	public String getAlipayGateway() {
		return alipayGateway;
	}

	public void setAlipayGateway(String alipayGateway) {
		this.alipayGateway = alipayGateway;
	}

	public String getMcloudApi() {
		return mcloudApi;
	}

	public void setMcloudApi(String mcloudApi) {
		this.mcloudApi = mcloudApi;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getAlipayPublicKey() {
		return alipayPublicKey;
	}

	public void setAlipayPublicKey(String alipayPublicKey) {
		this.alipayPublicKey = alipayPublicKey;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public int getMaxQueryRetry() {
		return maxQueryRetry;
	}

	public void setMaxQueryRetry(int maxQueryRetry) {
		this.maxQueryRetry = maxQueryRetry;
	}

	public int getQueryDuration() {
		return queryDuration;
	}

	public void setQueryDuration(int queryDuration) {
		this.queryDuration = queryDuration;
	}

	public int getMaxCancelRetry() {
		return maxCancelRetry;
	}

	public void setMaxCancelRetry(int maxCancelRetry) {
		this.maxCancelRetry = maxCancelRetry;
	}

	public int getCancelDuration() {
		return cancelDuration;
	}

	public void setCancelDuration(int cancelDuration) {
		this.cancelDuration = cancelDuration;
	}

	public int getHeartbeatDelay() {
		return heartbeatDelay;
	}

	public void setHeartbeatDelay(int heartbeatDelay) {
		this.heartbeatDelay = heartbeatDelay;
	}

	public int getHeartbeatDuration() {
		return heartbeatDuration;
	}

	public void setHeartbeatDuration(int heartbeatDuration) {
		this.heartbeatDuration = heartbeatDuration;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

}
