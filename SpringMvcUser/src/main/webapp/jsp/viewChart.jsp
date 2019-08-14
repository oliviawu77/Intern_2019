<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
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
	<h1>請選擇使用者</h1>
	<table>
	<tbody>
	   <c:forEach var="list" items="${employeelist}">   
	   <tr>  
	   <td>${list.id}</td>  
	   <td><a href="viewUser?id=${list.id}">閱讀圖表</a></td>
	   </tr>
	   </c:forEach>    	
	</tbody>
	</table>
</body>
</html>