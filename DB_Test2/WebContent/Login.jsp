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
<h1>立即登入</h1>

	<form action="MyFirstServlet" method="post">
		<table style="border:3px #FFD382 dashed;" cellpadding="10" border='1'>
			<tr>
			<td>
			帳號:
			</td>
			<td>
			<input name="acc" id="acc" type="text" required="required">			
			</td>
			</tr>	
			<tr>
			<td>
			密碼:</td>
			<td>
			<input name="pwd" id="pwd" type="password" required="required"><br>
			</td>
			</tr>
			<tr>
			<td colspan = 2>
			<input type="submit" value="登入">
			<input type="reset" value="重設">
			</td>
			</tr>
		</table>
	</form>
		 <a href='Register.jsp'>立即註冊</a>
	<script type="text/javascript">
	</script>
</body>
</html>