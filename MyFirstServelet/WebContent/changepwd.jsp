<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更改我的密碼</title>
</head>
<body>
<h1>HI! ${name}</h1>
<form action="ChangePassword" method="post">
<div >
	<table>
	<tr>
	<td>
  		<h1>請輸入原本的密碼：</h1><input type="password" name="mypassword_origin">
	</td>
	</tr>
	<tr>
	<td>
  		<h1>請輸入要更改的密碼：</h1><input type="password" name="mypassword">
	</td>
	</tr>
	<tr>
 	<td>
   		<h1>請再次輸入要更改的密碼：</h1><input type="password" name="mypassword_check">
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