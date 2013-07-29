package com.hcm.utils;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class EncodingFilter extends HttpServlet implements Filter {
	
	@SuppressWarnings("unused")
	private FilterConfig config = null;
	private String encoding = "";

	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		this.encoding = config.getInitParameter("encoding");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		response.setCharacterEncoding(this.encoding);
		// java.io.PrintWriter out = res.getWriter();
		// out.print("过滤器设置编码为：" + this.encoding + "<br><br>");
		chain.doFilter(req, res);
	}
}