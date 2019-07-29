<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jbr.springmvc.dao.UserDaoImpl" %>
<%@ page import="jbr.springmvc.model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel=stylesheet type="text/css" href="jsp/style.css">
<title>Welcome</title>
</head>
<body>
<%   
	ApplicationContext context = new ClassPathXmlApplicationContext("classpath:jbr/config/user-beans.xml");
	UserDaoImpl userDao = (UserDaoImpl) context.getBean("userDao");
    List<User> users = userDao.getUserList();
 %>

	<h1>Welcome!${name}</h1>
	<table style="border:3px #FFD382 dashed;" cellpadding="10" border='1'>
	<thead>
	<tr>
	<th>
	ID
	</th>
	<th>
	姓名
	</th>	
	<th>
	帳戶
	</th>
	<th>
	訊息
	</th>
	<th>
	電子郵件
	</th>
	<th>
	性別
	</th>
	<th>
	年齡
	</th>
	<th>
	</th>				
	</tr>
	</thead>
	<tbody>
	<% 
    for (User record : users) {
		out.println("<tr>");
		out.println("<td>"+record.getId()+"</td>");
		out.println("<td>"+record.getName()+"</td>");
		out.println("<td>"+record.getAcc()+"</td>");
		out.println("<td>"+record.getMsg()+"</td>");
		out.println("<td>"+record.getEmail()+"</td>");
		out.println("<td>"+record.getSex()+"</td>");
		out.println("<td>"+record.getAge()+"</td>");
		String mystr=new String("<a href='edit?acc="+record.getAcc()+"'>編輯</a>");
		out.println("<td>"+mystr+"</td>");		
		out.println("</tr>");
    	}
	%>
	</tbody>
	</table><br>
	<input type="button" id="return" value="登出" name="return"  class="button button1" onclick="location.href='home.html'">
		

</body>
</html>