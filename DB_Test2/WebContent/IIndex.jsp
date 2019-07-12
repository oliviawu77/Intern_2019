<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome!${name}</title>
</head>
<body>
<p>${message}</p>
<table>
	<tr>
	<td>	
	<a href="/">更換我的密碼</a>
	</td>
	</tr>
	<tr>
	<td>
	<a href="/">更換我的訊息</a>
	</td>
	</tr>	

</table>
  <!-- 新增logout button -->
	<form action='Logout'  method="post">
		<input name="button" type="submit" id="button" value="登出">
	</form>
</body>
</html>