package com.hcm.servlet.listener.session;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 对Session的监听测试
 *
 * @author huangcongmin
 * @version , 2013-7-29
 * @since
 */
public class ServletSessionListenerTest implements HttpSessionListener, HttpSessionAttributeListener {
	
	private HttpSession session = null;
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http.HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent sessionEvent) {
		this.session = sessionEvent.getSession();
		System.out.println("==> Session Create ... ...");
		System.out.println("==> Session ID: " + this.session.getId());
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet.http.HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		System.out.println("==> Session Destroyed ... ...");
	}


	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionAttributeListener#attributeAdded(javax.servlet.http.HttpSessionBindingEvent)
	 */
	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("==> Session 增加属性：" + se.getName() + " --> " + se.getValue());
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionAttributeListener#attributeRemoved(javax.servlet.http.HttpSessionBindingEvent)
	 */
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("==> Session 增加移出：" + se.getName() + " --> " + se.getValue());
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionAttributeListener#attributeReplaced(javax.servlet.http.HttpSessionBindingEvent)
	 */
	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("==> Session 增加替换：" + se.getName() + " --> " + se.getValue());
	}

}
