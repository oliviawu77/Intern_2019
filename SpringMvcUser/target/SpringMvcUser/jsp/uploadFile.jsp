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
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel=stylesheet type="text/css" href="jsp/style.css">
<title><spring:message code="welcome_title" /></title>
</head>
<body>
	<h1>上傳檔案</h1>
	<form:form action="uploadfileProcessing" method="POST" enctype="multipart/form-data" >
        <input type="file" name="file"/>
        <button type="submit" id="upload">上傳</button>
	</form:form>
</body>
</html>