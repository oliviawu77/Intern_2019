<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>註冊</title>
	<link rel=stylesheet type="text/css" href="jsp/style.css">
	<script type="text/javascript">

		function check(){
			var password = document.getElementById("pwd").value;
			var repassword = document.getElementById("pwd_check").value;

			var age = document.getElementById("age").value;

			if(password!=repassword){
			    window.alert("密碼不一致！");
			    return false;
			    }        		
			else if (document.regForm.name.value==""){
				alert("請填姓名！");
				return false;
			}
			else if(document.regForm.acc.value==""){
				alert("請填帳號！");
				return false;
			}
			else if(document.getElementById("pwd").value==""){
				alert("請填密碼！");
				return false;
			}
			else if(document.getElementById("pwd_check").value==""){
				alert("請填確認密碼！");
				return false;
			}			
			else if(document.regForm.email.value==""){
				alert("請填信箱！");
				return false;
			}			
			else if(document.regForm.age.value==""){
				alert("請填年齡！");
				return false;				
			}
			else if (age > 99 | age < 1){
				alert("年齡超過範圍(1~99)！");
				return false;	
			}		
			else{
				if(confirm("資料即將送出")){
					alert("註冊成功！請重新登入");
					return true;
					}
				else
					return false;
			}			
		}					
		 	
	</script>

</head>
<body>
	<form:form id="regForm" name="regForm"  modelAttribute="user" action="registerProcess"
		method="post" onsubmit="return check()">

		<table>
			<tr>
				<td><form:label path="id">ID：</form:label></td>
				<td><form:input path="id" name="id" id="id" /></td>
			</tr>		
			<tr>
				<td><form:label path="name">姓名：</form:label></td>
				<td><form:input path="name" name="name" id="name" /></td>
			</tr>
			<tr>
				<td><form:label path="acc">帳號：</form:label></td>
				<td><form:input path="acc" name="acc" id="acc" /></td>
			</tr>
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
				<td>性別：</td>
				<td><form:radiobutton path="sex" name="sex" id="sex" value="male" label="男" /><form:radiobutton path="sex" name="sex" id="sex" value="female" label="女" /></td>
			</tr>
			<tr>
				<td><form:label path="age">年齡：</form:label></td>
				<td><form:input path="age" name="age" id="age" /></td>
			</tr>

			<tr>
				<td></td>
				<td><form:button id="register" name="register" class="button button1">註冊</form:button>
				<input type="button" id="return" value="返回" name="return"  class="button button1" onclick="location.href='home.html'"></td>
				
			</tr>

		</table>
	</form:form>

</body>
</html>