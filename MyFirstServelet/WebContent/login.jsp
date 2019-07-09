<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登入頁面</title>
</head>
<body>

<!-- 在這裡要注意的是action="MyFirstServlet"
這裡action會影響到我們登入後所呈現的url,因為通常我們並不會想讓我們的程式名稱直接秀在網址上 -->

<form action="MyFirstServlet" method="post">
<div >
	<table>
	<tr>
	<td>
  		<p>姓名:</p><input type="text" name="name">
	</td>
	</tr>
	<tr>
 	<td>
   		<p>密碼:</p><input type="password" name="mypassword">
	</td>
	</tr>
	<tr>
 	<td>
   		<input type="submit" value="登入">
	</td>
	</tr>	
	</table>
</div>
</form>
   		<input type="button" value="註冊" onclick="location.href='register.jsp'">
</body>
</html>