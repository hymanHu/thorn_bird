package com.sfac.springBoot.config.pay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

/**
 * Description: Alipay Config
 * @author HymanHu
 * @date 2021-04-06 10:23:16
 */
@Configuration
public class AlipayConfig {
	
	@Autowired
	private AlipayConfigBean alipayConfigBean;
	
	@Bean
	public AlipayClient alipayClient () {
		return new DefaultAlipayClient(
				alipayConfigBean.getAlipayGateway(), 
				alipayConfigBean.getAppId(), 
				alipayConfigBean.getPrivateKey(), 
				alipayConfigBean.getFormat(), 
				alipayConfigBean.getCharset(), 
				alipayConfigBean.getAlipayPublicKey(), 
				alipayConfigBean.getSignType());
	}
	
}
