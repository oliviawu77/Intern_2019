<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>註冊</title>
</head>
<body>
<form action="Register" method="post">
<div >
	<table>
	<tr>
	<td>
  		<h1>姓名:</h1><input type="text" name="name">
	</td>
	</tr>
	<tr>
 	<td>
   		<h1>密碼:</h1><input type="password" name="mypassword">
	</td>
	</tr>
	<tr>
 	<td>
   		<h1>歡迎訊息:</h1><input type="text" name="welmsg">
	</td>
	</tr>	
	<tr>
 	<td>
   		<input type="submit" value="註冊">
	</td>
	</tr>	
	</table>
</div>
</form>
</body>
</html>