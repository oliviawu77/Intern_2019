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
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel=stylesheet type="text/css" href="jsp/style.css">
<title>Welcome</title>
</head>
<body>
	<h1>Welcome!${sex_msg}${name}</h1>
	<table>
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
	   <c:forEach var="list" items="${userlist}">   
	   <tr>  
	   <td>${list.id}</td>  
	   <td>${list.name}</td>  
	   <td>${list.acc}</td>  
	   <td>${list.msg}</td>
	   <td>${list.email}</td>
	   <td>${list.sex}</td>
	   <td>${list.age}</td>
	   <td><a href="edit?acc=${list.acc}">編輯</a></td>
	   </tr>
	   </c:forEach>    	
	</tbody>
	</table><br>
	<input type="button" id="return" value="登出" name="return"  class="button button1" onclick="location.href='home.html'">
</body>
</html>