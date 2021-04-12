package com.sfac.springBoot.modules.pay.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sfac.springBoot.config.pay.AlipayConfigBean;
import com.sfac.springBoot.modules.common.entity.ResultEntity;
import com.sfac.springBoot.modules.pay.entity.Alipay;
import com.sfac.springBoot.modules.pay.service.AlipayService;

/**
 * Description: Alipay Controller
 * @author HymanHu
 * @date 2021-03-30 10:07:19
 */
@Controller
@RequestMapping("/api/alipay")
public class AlipayController {
	
	@Autowired
	private AlipayConfigBean alipayConfigBean;
	@Autowired
	private AlipayService alipayService;
	
	/**
	 * 127.0.0.1/api/alipay/tradePayPage ---- post
	 */
	@PostMapping(value = "/tradePayPage", consumes = "application/x-www-form-urlencoded")
	public void tradePayPage(HttpServletResponse response, @ModelAttribute Alipay alipay) {
		response.setContentType("text/html;charset=" + alipayConfigBean.getCharset());
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			pw.write(alipayService.tradePayPage(alipay));
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}
	
	/**
	 * 127.0.0.1/api/alipay/tradePayQr ---- post
	 * {"outTradeNo":"ORDER_1617684756223", "totalAmount":4.44, "subject":"川A44444 停车缴费", "body":"停车无忧"}
	 */
	@PostMapping(value = "/tradePayQr", consumes = "application/json")
	@ResponseBody
	public String tradePayQr(@RequestBody Alipay alipay) {
		return alipayService.tradePayQr(alipay);
	}
	
	/**
	 * http://k2kkxw.natappfree.cc/api/alipay/tradePayNotify ---- get
	 * - 该地址为公网地址，测试时使用 NotApp 内网穿刺模拟
	 */
	@PostMapping("/tradePayNotify")
	@ResponseBody
	public void tradePayNotify(HttpServletRequest request) {
		alipayService.tradePayNotify(request);
	}
	
	/**
	 * http://k2kkxw.natappfree.cc/api/alipay/tradePayReturn ---- post
	 * - 该地址为公网地址，测试时使用 NotApp 内网穿刺模拟
	 */
	@GetMapping("/tradePayReturn")
	@ResponseBody
	public ResultEntity<Object> tradePayReturn(HttpServletRequest request) {
		return alipayService.tradePayReturn(request);
	}

}
