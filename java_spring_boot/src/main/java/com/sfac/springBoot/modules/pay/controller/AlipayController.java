package com.sfac.springBoot.modules.pay.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sfac.springBoot.modules.common.entity.ResultEntity;
import com.sfac.springBoot.modules.pay.entity.Alipay;
import com.sfac.springBoot.modules.pay.entity.AlipayConfigBean;
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
	 * {"subject":"无忧停车"}
	 */
	@PostMapping(value = "/tradePayPage", consumes = "application/x-www-form-urlencoded")
	public void tradePayPage(HttpServletResponse response, @ModelAttribute Alipay alipay) throws Exception {
		response.setContentType("text/html;charset=" + alipayConfigBean.getCharset());
		PrintWriter pw = response.getWriter();
		pw.write(alipayService.tradePayPage(alipay));
		pw.flush();
		pw.close();
	}
	
	/**
	 * http://k2kkxw.natappfree.cc/api/alipay/tradePayNotify ---- get
	 * - 该地址为公网地址，测试时使用 NotApp 内网穿刺模拟
	 */
	@PostMapping("/tradePayNotify")
	@ResponseBody
	public void tradePayNotify(HttpServletRequest request) throws Exception {
		alipayService.tradePayNotify(request);
	}
	
	/**
	 * http://k2kkxw.natappfree.cc/api/alipay/tradePayReturn ---- post
	 * - 该地址为公网地址，测试时使用 NotApp 内网穿刺模拟
	 */
	@GetMapping("/tradePayReturn")
	@ResponseBody
	public ResultEntity<Object> tradePayReturn(HttpServletRequest request) throws Exception {
		return alipayService.tradePayReturn(request);
	}

}
