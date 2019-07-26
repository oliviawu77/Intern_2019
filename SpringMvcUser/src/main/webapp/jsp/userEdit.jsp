<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jbr.springmvc.dao.UserDaoImpl" %>
<%@ page import="jbr.springmvc.model.User" %>    
<%@ page import="java.util.ArrayList" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel=stylesheet type="text/css" href="jsp/style.css">
<title>使用者資料編輯</title>
	<script type="text/javascript">

		function check(){
			if(confirm("資料即將送出")){
				alert("資料修改成功！");
				return true;
			}
			else{
				alert("修改已取消！");
				return false;
			}
		}					
		 	
	</script>	
</head>
<body>
<h1>使用者資料編輯</h1>
		<form:form action="UserEditProcess" method="post" name="edit_form" 
			id="edit_form" modelAttribute="user" onsubmit="return check()">
		<table>
			<tr>
				<td><form:label path="acc">帳號：</form:label></td>
				<td><form:input path="acc" name="acc" id="acc" /></td>
			</tr>		
			<tr>
				<td><form:label path="name">姓名：</form:label></td>
				<td><form:input path="name" name="name" id="name" /></td>
			</tr>
			<tr>
			<tr>
				<td><form:label path="pwd">密碼：</form:label></td>
				<td><form:password path="pwd" name="pwd" id="pwd" /></td>
			</tr>
			<tr>
				<td><form:label path="pwd_check">確認密碼：</form:label></td>
				<td><form:password path="pwd_check" name="pwd_check" pwd_check="email" /></td>
			</tr>			
			<tr>
				<td><form:label path="email">Email：</form:label></td>
				<td><form:input path="email" name="email" id="email" /></td>
			</tr>
			<tr>
				<td><form:label path="msg">訊息：</form:label></td>
				<td><form:input path="msg" name="msg" id="msg" /></td>
			</tr>			
			<tr>
				<td>性別：</td>
				<td><form:radiobutton path="sex" name="sex" id="sex" value="M" label="男" /><form:radiobutton path="sex" name="sex" id="sex" value="F" label="女" /></td>
			</tr>
			<tr>
				<td><form:label path="age">年齡：</form:label></td>
				<td><form:input path="age" name="age" id="age" /></td>
			</tr>

			<tr>
				<td></td>
				<td><form:button id="register" name="register" class="button button1">修改</form:button>
				<input type="button" id="return" value="返回" name="return"  class="button button1" onclick="location.href='home'"></td>
				
			</tr>

		</table>
	</form:form>

</body>
</html>