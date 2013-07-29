package com.hcm.servlet.online;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Servlet监听器，在线人数测试
 *
 * @author huangcongmin
 * @version , 2013-7-29
 * @since
 */
public class OnlineTest implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

	/**
	 * 声明一个ServletContext对象
	 */
	private ServletContext application = null;

	public void contextInitialized(ServletContextEvent sce) {
		// 容器初始化时，向application中存放一个空的容器
		// 因为用户名是多个，所以无法确认个数，使用List
		this.application = sce.getServletContext();
		this.application.setAttribute("userList", new ArrayList<String>());
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}

	public void sessionCreated(HttpSessionEvent se) {
	}

	@SuppressWarnings("unchecked")
	public void sessionDestroyed(HttpSessionEvent se) {
		// 将用户名称从列表中删除
		List<String> list = (List<String>) this.application.getAttribute("userList");
		String value = (String) se.getSession().getAttribute("username");
		list.remove(value);
		this.application.setAttribute("userList", list);
	}

	@SuppressWarnings("unchecked")
	public void attributeAdded(HttpSessionBindingEvent se) {
		// 如果登陆成功，则将用户名保存在列表之中
		List<String> list = (List<String>) this.application.getAttribute("userList");
		list.add((String) se.getValue());
		// 把修改后的值(List<String> list)重新放回去
		this.application.setAttribute("userList", list);
	}

	public void attributeRemoved(HttpSessionBindingEvent se) {
	}

	public void attributeReplaced(HttpSessionBindingEvent se) {
	}

}
