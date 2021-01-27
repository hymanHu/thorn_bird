package com.sfac.springMvc.listener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sfac.springMvc.module.account.entity.User;

/**
 * Description: Online User Counter Listener
 * @author HymanHu
 * @date 2021-01-27 16:48:44
 */
@WebListener
public class OnlineUserCounterListener implements HttpSessionListener, 
	HttpSessionAttributeListener, ServletRequestListener {
	
	private final static Logger LOGGER = LogManager.getLogger(OnlineUserCounterListener.class);
	 private static ThreadLocal<HttpServletRequest> httpServletRequestHolder = new ThreadLocal<HttpServletRequest>();

	// Session 创建时，输出 Session id
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		LOGGER.debug(String.format("New session id: %s", se.getSession().getId()));
	}

	// Session 销毁时候，计数器减一
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
	}

	// Session 添加 user，计数器加一，并将用户名添加到 List 中
	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		ServletContext servletContext = se.getSession().getServletContext();
		int count = (int) servletContext.getAttribute("onlineUserCounter");
		if ("user".equals(se.getName())) {
			count ++;
			servletContext.setAttribute("onlineUserCounter", count);
			User user = (User) se.getSession().getAttribute("user");
			HttpServletRequest httpServletRequest = httpServletRequestHolder.get();
			LOGGER.debug(String.format("Online user count: %s", count));
			LOGGER.debug(String.format("Login user name: %s", user.getUserName()));
			LOGGER.debug(String.format("Login user id: %s", httpServletRequest.getRemoteAddr()));
			LOGGER.debug(String.format("Login date time: %s", 
					DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now())));
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		httpServletRequestHolder.remove();
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		httpServletRequestHolder.set((HttpServletRequest)sre.getServletRequest());
	}

}
