<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>	
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="reg_title" /></title>
	<link rel=stylesheet type="text/css" href="jsp/style.css">
	<script type="text/javascript">
		function checkEmail(remail) {
			if (remail.search(/^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/)!=-1) {
				return false;
			} else {
			  return true;
			}
		}
		
		function check(){
			
			var password = document.getElementById("pwd").value;
			var repassword = document.getElementById("pwd_check").value;
			var age = document.getElementById("age").value;

			if(checkEmail(document.regForm.email.value)){
				alert("Email 格式錯誤！");
				return false;
				}
			else if(password!=repassword){
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
			else if (age > 99 | age < 0){
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
	<spring:message code="page.cl" /><br>
	<a href="?lang=en">English</a>
	<a href="?lang=zh_TW">繁體中文</a>
	<a href="?lang=zh_CN">简体中文</a>
	<form:form id="regForm" name="regForm"  modelAttribute="user" action="registerProcess"
		method="post" onsubmit="return check()">

		<table>	
			<tr>
				<td><form:label path="name"><spring:message code="reg_name" /></form:label></td>
				<td><form:input path="name" name="name" id="name" /></td>
			</tr>
			<tr>
				<td><form:label path="acc"><spring:message code="reg_account" /></form:label></td>
				<td><form:input path="acc" name="acc" id="acc" /></td>
			</tr>
			<tr>
				<td><form:label path="pwd"><spring:message code="reg_password" /></form:label></td>
				<td><form:password path="pwd" name="pwd" id="pwd" /></td>
			</tr>
			<tr>
				<td><form:label path="pwd_check"><spring:message code="reg_password_check" /></form:label></td>
				<td><form:password path="pwd_check" name="pwd_check" pwd_check="email" /></td>
			</tr>			
			<tr>
				<td><form:label path="email"><spring:message code="reg_email" /></form:label></td>
				<td><form:input path="email" name="email" id="email" /></td>
			</tr>
			<tr>
				<td><spring:message code="reg_sex" /></td>
				<td><form:radiobutton path="sex" name="sex" id="sex"/><img src="jsp\masculine.png" height=30px width=30px/><form:radiobutton path="sex" name="sex" id="sex" value="female"/><img src="jsp\femenine.png" height=30px width=30px/></td>
			</tr>
			<tr>
				<td><form:label path="age"><spring:message code="reg_age" /></form:label></td>
				<td><form:input type="number" path="age" name="age" id="age" /></td>
			</tr>

			<tr>
				<td></td>
				<td><form:button id="register" name="register" class="button button1"><spring:message code="reg_submit" /></form:button>
				<input type="button" id="return" value="<<" name="return"  class="button button1" onclick="location.href='home.html'"></td>
				
			</tr>

		</table>
	</form:form>

</body>
</html>