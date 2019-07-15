<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="controller.DBController" %>
<%@ page import="controller.Data" %>    
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>登入</title>
</head>
<body>
	<form action="ChangePassword" method="post">
		<label for="pwd_new">新密碼:</label><br>
		<input name="pwd_new" id="pwd_new" type="text"><br>
		<input type="submit" value="送出">
	</form>
</body>
</html>