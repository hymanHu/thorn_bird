package com.sfac.springBoot.modules.common.controller;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * @Description: Web Socket Controller
 * - 每一个 webSocket 连接维持一个 Session 对象，用于服务器向客户端发送信息
 * - 我们可以将 User-Session 装到 ConcurrentHashMap 中，给某一个客户端发送信息或群发消息，此案列使用群发信息
 * @author: HymanHu
 * @date: 2021年4月10日
 */
@ServerEndpoint("/api/webSocket")
@Component
public class WebSocketController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(WebSocketController.class);
	private Session session;
	private static CopyOnWriteArraySet<WebSocketController> webSockets = 
			new CopyOnWriteArraySet<WebSocketController>();
	
	// 创建连接
	@OnOpen
	public void onOpen(Session session) {
		this.session = session;
		webSockets.add(this);
		LOGGER.debug(String.format("新建连接，连接总数 %d。", webSockets.size()));
	}
	
	// 关闭连接
	@OnClose
	public void onClose() {
		webSockets.remove(this);
		LOGGER.debug(String.format("断开连接，连接总数 %d。", webSockets.size()));
	}
	
	// 发生错误
	@OnError
	public void onError(Throwable throwable){
		LOGGER.debug("发生错误");
		throwable.printStackTrace();
	}
	
	// 接受客户端消息
	@OnMessage
	public void onMessage(String message) {
		LOGGER.debug(String.format("收到消息，%s，连接总数 %d。", message, webSockets.size()));
	}
	
	// 向客户端群发信息
	public void sendMessage(String message) {
		LOGGER.debug(String.format("广播消息，%s，连接总数 %d。", message, webSockets.size()));
		for (WebSocketController webSocketController : webSockets) {
			try {
				webSocketController.session.getBasicRemote().sendText(message);
			} catch (IOException e) {
				e.printStackTrace();
				LOGGER.debug(e.getMessage());
			}
		}
	}

}
