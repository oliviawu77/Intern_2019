<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jbr.springmvc.dao.UserDaoImpl" %>
<%@ page import="jbr.springmvc.model.User" %>    
<%@ page import="java.util.ArrayList" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel=stylesheet type="text/css" href="jsp/style.css">
<title><spring:message code="edit_title" /></title>
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

		if(password!=repassword){
		    window.alert("密碼不一致！");
		    return false;
		    }
		else if(age > 99 | age < 0){
			alert("年齡範圍錯誤！");
			return false;
			}
		else if(checkEmail(document.edit_form.email.value)&document.edit_form.email.value!="")
		{
			alert("Email 格式錯誤！");
			return false;
			}			
		else{
			if(confirm("資料即將送出")){
				alert("資料修改成功！");
				return true;
				}
			else{
				alert("修改已取消！");
				return false;
				}
		}			
		}
	
	function checkEmail(remail) {
		if (remail.search(/^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/)!=-1) {
			return false;
		} else {
		  return true;
		}
	}	
	
	function delete_check(){
		if(confirm("確定刪除此使用者嗎？")){
			alert("使用者刪除成功！");
			return true;
			}
		else{
			alert("刪除已取消！");
			return false;
			}			
	}		
		 	
	</script>
</head>
<body>
	<spring:message code="page.cl" /><br>
	<a href="?acc=${param['acc']}&lang=en">English</a>
	<a href="?acc=${param['acc']}&lang=zh_TW">繁體中文</a>
	<a href="?acc=${param['acc']}&lang=zh_CN">简体中文</a>
    <jsp:useBean id="acc" class="jbr.springmvc.model.User">  
        <jsp:setProperty name="acc" param="acc" property="acc"></jsp:setProperty>  
    </jsp:useBean>  
		<form:form action="userEditProcess" method="post" name="edit_form" 
			id="edit_form" modelAttribute="user" onsubmit="return check()">
		<table>
			<tr>
				<td><form:label path="acc"><spring:message code="edit_account" /></form:label></td>
				<td><form:input class="input" path="acc" name="acc" id="acc" value="${param['acc']}" readonly="true"/>
			</tr>		
			<tr>
				<td><form:label path="name"><spring:message code="edit_name" /></form:label></td>
				<td><form:input class="input" path="name" name="name" id="name" /></td>
			</tr>
			<tr>
			<tr>
				<td><form:label path="pwd"><spring:message code="edit_password" /></form:label></td>
				<td><form:password class="input" path="pwd" name="pwd" id="pwd" /></td>
			</tr>
			<tr>
				<td><form:label path="pwd_check"><spring:message code="edit_password_check" /></form:label></td>
				<td><form:password class="input" path="pwd_check" name="pwd_check" id="pwd_check" /></td>
			</tr>			
			<tr>
				<td><form:label path="email"><spring:message code="edit_email" /></form:label></td>
				<td><form:input class="input" path="email" name="email" id="email" /></td>
			</tr>
			<tr>
				<td><form:label path="msg"><spring:message code="edit_message" /></form:label></td>
				<td><form:input class="input" path="msg" name="msg" id="msg" /></td>
			</tr>			
			<tr>
				<td><spring:message code="edit_sex" /></td>
				<td><form:radiobutton path="sex" name="sex" id="sex" value="male"/><img src="jsp\masculine.png" height=30px width=30px/><form:radiobutton path="sex" name="sex" id="sex" value="female"/><img src="jsp\femenine.png" height=30px width=30px/></td>
			</tr>
			<tr>
				<td><form:label path="age"><spring:message code="edit_age" /></form:label></td>
				<td><form:input type="number" class="input" path="age" name="age" id="age" /></td>
			</tr>

			<tr>
				<td><form:button id="register" name="register" class="button button1"><spring:message code="edit_submit" /></form:button>
			</tr>

		</table>
	</form:form>
		<form:form action="userDeleteProcess" method="post" name="delete_form" 
			id="delete_form" modelAttribute="user" onsubmit="return delete_check()">
		<table>			
			<tr>
				<form:label path="acc"></form:label>
				<form:input type="hidden" path="acc" name="acc" id="acc" value="${param['acc']}" readonly="true"/>
				<form:button id="delete" name="delete" class="button button1"><spring:message code="edit_delete" /></form:button>
			</tr>			
		</table>	
	</form:form>
</body>
</html>