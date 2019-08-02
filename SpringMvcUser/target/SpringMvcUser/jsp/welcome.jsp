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
<title><spring:message code="welcome_title" /></title>
</head>
<body>
	<h1>Welcome!${sex_msg}${name}</h1>
	<table>
	<thead>
	<tr>
	<th>
	<spring:message code="welcome_id" />
	</th>
	<th>
	<spring:message code="welcome_name" />
	</th>	
	<th>
	<spring:message code="welcome_account" />
	</th>
	<th>
	<spring:message code="welcome_message" />
	</th>
	<th>
	<spring:message code="welcome_email" />
	</th>
	<th>
	<spring:message code="welcome_sex" />
	</th>
	<th>
	<spring:message code="welcome_age" />
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
	   <td>
	   		<c:choose>
			  <c:when test="${list.sex=='male'}">
			  		<img src="jsp\masculine.png" height=30px width=30px/>
			   </c:when>
			   <c:when test="${list.sex=='female'}">
			   		<img src="jsp\femenine.png" height=30px width=30px/>
			   </c:when>	   		
	   		</c:choose>
	   </td>
	   <td>${list.age}</td>
	   <td><a href="edit?acc=${list.acc}"><spring:message code="welcome_edit" /></a></td>
	   </tr>
	   </c:forEach>    	
	</tbody>
	</table><br>
	<input type="button" id="return" value="登出" name="return"  class="button button1" onclick="location.href='home.html'">
</body>
</html>