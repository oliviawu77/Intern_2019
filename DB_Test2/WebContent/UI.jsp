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
	<form action="MyFirstServlet" method="post">
		<label for="acc">帳號:</label><br>
		<input name="acc" id="acc" type="text"><br>
		<label for="pwd">密碼:</label><br>
		<input name="pwd" id="pwd" type="password"><br>
		<input type="submit" value="登入">
	</form>
<h1>立即註冊</h1>
	<form action="Register" method="post">
		<label for="acc">帳號:</label><br>
		<input name="acc" id="acc" type="text"><br>
		<label for="pwd">密碼:</label><br>
		<input name="pwd" id="pwd" type="password"><br>
		<input type="submit" value="註冊">
	</form>
	<script type="text/javascript">
	</script>
</body>
</html>