<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="login_title" /></title>
	<link rel=stylesheet type="text/css" href="jsp/style.css">
</head>
<body>
	<spring:message code="page.cl" /><br>

	<form:form id="loginForm" modelAttribute="login" action="loginProcess"
		method="post">
		<table align="center">
			<tr>
				<td><form:label path="username"><spring:message code="login_account" /></form:label></td>
				<td><input class="input" type='text' name="username" id="username" /></td>
			</tr>
			<tr>
				<td><form:label path="password"><spring:message code="login_password" /></form:label></td>
				<td><form:password class="input" path="password" name="password"
						id="password" /></td>
			</tr>
			<tr>
				<td></td>
				<td align="left"><form:button id="login" name="login"  class="button button1"><spring:message code="login_enter" /></form:button>
				<input type="button" id="return" value="返回" name="return"  class="button button1" onclick="location.href='home.html'"></td>
			</tr>
		</table>
	</form:form>
	<table align="center">
		<tr>
			<td style="font-style: italic; color: red;">${message}</td>
		</tr>
	</table>

</body>
</html>