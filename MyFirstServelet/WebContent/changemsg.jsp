<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更改我的歡迎訊息</title>
</head>
<body>
<h1>Hello!</h1>
<form action="ChangeMsg" method="post">
<div >
	<table>
	<tr>
	<td>
  		<h1>請輸入欲更改的歡迎訊息:</h1><input type="text" name="welcomeMsg">
	</td>
	</tr>
	<tr>
 	<td>
   		<input type="submit" value="submit">
	</td>
	</tr>	
	</table>
</div>
</form>
</body>
</html>