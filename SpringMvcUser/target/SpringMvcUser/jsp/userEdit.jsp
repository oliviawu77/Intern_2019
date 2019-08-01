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
<title>使用者資料編輯</title>
	<script type="text/javascript">
	var acc = location.search.substr(5)
		alert("更改"+acc+"的資料");
	
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

		if(checkEmail(document.regForm.email.value))
		{
			alert("Email 格式錯誤！");
			return false;
			}
		else if(password!=repassword){
		    window.alert("密碼不一致！");
		    return false;
		    }        		
		else if ((age > 99 | age < 1) & (age != 0)){
			alert("年齡超過範圍(1~99)！");
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
    <jsp:useBean id="acc" class="jbr.springmvc.model.User">  
        <jsp:setProperty name="acc" param="acc" property="acc"></jsp:setProperty>  
    </jsp:useBean>  
<h1>使用者資料編輯</h1>
		<form:form action="userEditProcess" method="post" name="edit_form" 
			id="edit_form" modelAttribute="user" onsubmit="return check()">
		<table>
			<tr>
				<td><form:label path="acc">帳號：</form:label></td>
				<td><form:input class="input" path="acc" name="acc" id="acc" value="${param['acc']}" readonly="true"/>
			</tr>		
			<tr>
				<td><form:label path="name">姓名：</form:label></td>
				<td><form:input class="input" path="name" name="name" id="name" /></td>
			</tr>
			<tr>
			<tr>
				<td><form:label path="pwd">密碼：</form:label></td>
				<td><form:password class="input" path="pwd" name="pwd" id="pwd" /></td>
			</tr>
			<tr>
				<td><form:label path="pwd_check">確認密碼：</form:label></td>
				<td><form:password class="input" path="pwd_check" name="pwd_check" id="pwd_check" /></td>
			</tr>			
			<tr>
				<td><form:label path="email">Email：</form:label></td>
				<td><form:input class="input" path="email" name="email" id="email" /></td>
			</tr>
			<tr>
				<td><form:label path="msg">訊息：</form:label></td>
				<td><form:input class="input" path="msg" name="msg" id="msg" /></td>
			</tr>			
			<tr>
				<td>性別：</td>
				<td><form:radiobutton path="sex" name="sex" id="sex" value="male" label="男" /><form:radiobutton path="sex" name="sex" id="sex" value="female" label="女" /></td>
			</tr>
			<tr>
				<td><form:label path="age">年齡：</form:label></td>
				<td><form:input type="number" class="input" path="age" name="age" id="age" /></td>
			</tr>

			<tr>
				<td><form:button id="register" name="register" class="button button1">修改</form:button>
				<input type="button" id="return" value="返回" name="return"  class="button button1" onclick="location.href='welcome'"></td>
			</tr>

		</table>
	</form:form>
		<form:form action="userDeleteProcess" method="post" name="delete_form" 
			id="delete_form" modelAttribute="user" onsubmit="return delete_check()">
		<table>			
			<tr>
				<form:label path="acc"></form:label>
				<form:input type="hidden" path="acc" name="acc" id="acc" value="${param['acc']}" readonly="true"/>
				<form:button id="register" name="register" class="button button1">刪除使用者</form:button>
			</tr>			
		</table>	
	</form:form>
</body>
</html>