<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="controller.DBController" %>
<%@ page import="controller.Data" %>    
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登入</title>
</head>
<body>
	<form action="ChangeMessage" method="post">
		<p>新歡迎訊息:</p>
		<input name="msg_new" id="msg_new" type="text"><br>
		<input type="submit" value="送出"/>
	</form>
</body>
</html>