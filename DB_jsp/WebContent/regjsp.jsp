<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="Account" class="com.java2s.AccountBean" scope="request">
   <jsp:setProperty name="Account" property="acc"/>
   <jsp:setProperty name="Account" property="pwd"/>
   <jsp:setProperty name="Account" property="msg"/>
   <jsp:setProperty name="Account" property="sex"/>
   <jsp:setProperty name="Account" property="mail"/>
   <jsp:setProperty name="Account" property="name"/>
   <jsp:setProperty name="Account" property="id"/>
   <jsp:setProperty name="Account" property="age"/>                                                                                                             
</jsp:useBean>
<h1>立即註冊</h1>
	<form action="reg_process.jsp" method="post" name="reg_form">
		<table style="border:3px #FFD382 dashed;" cellpadding="10" border='1'>
			<tr>
			<td>	
			姓名:
			</td>
			<td>
			<input name="name" id="name" type="text">
			</td>
			</tr>
			<tr>
			<td>				
			帳號:
			</td>
			<td>
			<input name="acc" id="acc" type="text">
			</td>
			</tr>
			<tr>
			<td>			
			密碼:
			</td>
			<td>
			<input name="pwd" id="pwd" type="password">
			</td>
			</tr>
			<tr>
			<td>	
			確認密碼:
			</td>
			<td>
			<input name="pwd_check" id="pwd_check" type="password">
			</td>
			</tr>
			<tr>
			<td>			
			Email:
			</td>
			<td>
			<input name="mail" id="mail" type="email">
			</td>
			</tr>
			<tr>
			<td>			
			性別:
			</td>
			<td>
			<input type="radio" name="sex" id="sex" value="male" checked="true">男
			<input type="radio" name="sex" id="sex" value="female">女
			</td>
			</tr>
			<tr>
			<td>			
			年齡:</td>
			<td>
			<input name="age" id="age" type="number" min="0" max="99">
			</td>
			</tr>
			<tr>
			<td colspan = 2>								
			<input type="submit" value="註冊" id="sub">
			<input type="reset" value="重設">			
			</td>
			</tr>
			</table>			
	</form>
                       
</body>
</html>