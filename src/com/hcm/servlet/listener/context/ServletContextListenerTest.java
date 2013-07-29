package com.hcm.servlet.listener.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 对ServletContext上下文属性的监听测试
 *
 * @author huangcongmin
 * @version , 2013-7-29
 * @since
 */
public class ServletContextListenerTest implements ServletContextListener, ServletContextAttributeListener {

	/**
	 * 接口ServletContext：定义了一整套方法，使用一个servlet沟通其的servlet容器
	 */
	private ServletContext servletContext = null;

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		this.servletContext = sce.getServletContext();
		System.out.println("==> Context Init ... ...");
		System.out.println("==> 当前虚拟目录的绝对路径：" + this.servletContext.getRealPath("/"));
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("==> Context Destroy ... ...");
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextAttributeListener#attributeAdded(javax.servlet.ServletContextAttributeEvent)
	 */
	public void attributeAdded(ServletContextAttributeEvent scae) {
		System.out.println("==> 属性增加：" + scae.getName() + " --> " + scae.getValue());
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextAttributeListener#attributeRemoved(javax.servlet.ServletContextAttributeEvent)
	 */
	public void attributeRemoved(ServletContextAttributeEvent scae) {
		System.out.println("==> 属性移出：" + scae.getName() + " --> " + scae.getValue());
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextAttributeListener#attributeReplaced(javax.servlet.ServletContextAttributeEvent)
	 */
	public void attributeReplaced(ServletContextAttributeEvent scae) {
		System.out.println("==> 属性替换：" + scae.getName() + " --> " + scae.getValue());
	}

}
