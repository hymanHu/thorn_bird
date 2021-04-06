package com.sfac.springBoot.modules.pay.service;

import javax.servlet.http.HttpServletRequest;

import com.sfac.springBoot.modules.common.entity.ResultEntity;
import com.sfac.springBoot.modules.pay.entity.Alipay;

/**
 * Description: Alipay Service
 * @author HymanHu
 * @date 2021-03-30 08:41:47
 */
public interface AlipayService {
	
	// 用户点击付款后跳转到支付宝付款页面
	String tradePayPage(Alipay alipay);
	
	// 用户点击支付后获得支付二维码
	String tradePayQr(Alipay alipay);
	
	// 支付成功后的异步回调，用于处理服务端业务
	void tradePayNotify(HttpServletRequest request);
	
	// 支付成功后同步回调，用于展示给用户查看
	ResultEntity<Object> tradePayReturn(HttpServletRequest request);
}
