<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="online.jsp" method="post">
		用户名：<input type="text" name="name"> <input type="submit" value="登陆">
		<a href="logout.jsp">注销</a>
	</form>
	<!-- 向session中接收输入的用户名 -->
	<%
		if (request.getParameter("name") != null) {
			session.setAttribute("username", request.getParameter("name"));
		}
	%>
	<h2>在线人员</h2>
	<hr>
	<%
		List l = (List) application.getAttribute("userList");
		Iterator iter = l.iterator();
		while (iter.hasNext()) {
	%>
	<li><%=iter.next()%>
		<%
			}
		%>
	
</body>
</html>