package com.sfac.springBoot.modules.pay.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sfac.springBoot.modules.common.entity.ResultEntity;
import com.sfac.springBoot.modules.common.entity.ResultEntity.ResultStatus;
import com.sfac.springBoot.modules.pay.entity.Alipay;
import com.sfac.springBoot.modules.pay.entity.AlipayConfigBean;
import com.sfac.springBoot.modules.pay.service.AlipayService;

/**
 * Description: Alipay Service Impl
 * @author HymanHu
 * @date 2021-03-30 09:06:34
 */
@Service
public class AlipayServiceImpl implements AlipayService {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(AlipayServiceImpl.class);
	@Autowired
	private AlipayConfigBean alipayConfigBean;

	@Override
	public String tradePayPage(Alipay alipay) throws Exception {
		LOGGER.debug("==== 请求支付宝扫码界面 ====");
		
		// 初始化 alipayClient、alipayRequest
		AlipayClient alipayClient = new DefaultAlipayClient(
				alipayConfigBean.getAlipayGateway(), 
				alipayConfigBean.getAppId(), 
				alipayConfigBean.getPrivateKey(), 
				alipayConfigBean.getFormat(), 
				alipayConfigBean.getCharset(), 
				alipayConfigBean.getAlipayPublicKey(), 
				alipayConfigBean.getSignType());
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(alipayConfigBean.getReturnUrl());
		alipayRequest.setNotifyUrl(alipayConfigBean.getNotifyUrl());
		
		// 构造请求参数 Json 格式
		Map<String, Object> map = new HashMap<>();
        map.put("out_trade_no", alipay.getOutTradeNo());
        map.put("product_code", "FAST_INSTANT_TRADE_PAY");
        map.put("total_amount", alipay.getTotalAmount());
        map.put("subject", alipay.getSubject());
        map.put("body", alipay.getBody());
		ObjectMapper objectMapper = new ObjectMapper();
		String alipayJson = objectMapper.writeValueAsString(map);
		LOGGER.debug(alipayJson);
		
		// 设置支付内容，发送请求，返回结果
		alipayRequest.setBizContent(alipayJson);
		return alipayClient.pageExecute(alipayRequest).getBody();
	}

	@Override
	public void tradePayNotify(HttpServletRequest request) throws Exception {
		LOGGER.debug("==== 支付异步回调，验签 ====");
		verifySignature(request);
	}

	@Override
	public ResultEntity<Object> tradePayReturn(HttpServletRequest request) throws Exception {
		LOGGER.debug("==== 支付同步回调，验签 ====");
		boolean signVerified = verifySignature(request);
		if (signVerified) {
			return new ResultEntity<Object>(ResultStatus.SUCCESS.status, "Pay success.");
		}
		return new ResultEntity<Object>(ResultStatus.FAILED.status, "Pay Failed.");
	}
	
	/**
	 * - 验签 && 业务处理
	 */
	@SuppressWarnings("unused")
	private boolean verifySignature (HttpServletRequest request) throws Exception {
		// 获取支付宝反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map<String,String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		LOGGER.debug("params: " + params);
		
		// SDK 验签
		boolean signVerified = AlipaySignature.rsaCheckV1(
				params, 
				alipayConfigBean.getAlipayPublicKey(), 
				alipayConfigBean.getCharset(), 
				alipayConfigBean.getSignType());
		
		/**
		 * - 实际验证过程建议商户务必添加以下校验
		 * - app_id 是否为该商户本身
		 * - out_trade_no 是否为商户系统中创建的订单号
		 * - total_amount 是否确实为该订单的实际金额
		 * - seller_id 或者 seller_email 是否为 out_trade_no 这笔单据的对应的操作方
		 */
		if (signVerified) {
			LOGGER.debug("==== 验签成功 ====");
			// 商户订单号
			String outTradeNo = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
			// 支付宝交易号
			String tradeNo = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
            
            // 处理业务逻辑
		} else {
			LOGGER.debug("==== 验签失败 ====");
		}
		
		return signVerified;
	}
}
