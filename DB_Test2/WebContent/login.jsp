<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>登入</title>
</head>
<body>
	<form action="MyFirstServlet" method="post">
		<label for="acc">帳號:</label><br>
		<input id="acc" type="text"><br>
		<label for="pwd">密碼:</label><br>
		<input id="pwd" type="text"><br>
		<input type="button" value="登入">
	</form>
</body>
</html>