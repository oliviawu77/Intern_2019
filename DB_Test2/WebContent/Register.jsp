<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="controller.DBController" %>
<%@ page import="controller.Data" %>    
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>註冊</title>
	<script type="text/javascript">

		function check(){
			var password = document.getElementById("pwd").value;
			var repassword = document.getElementById("pwd_check").value;

			var age = document.getElementById("age").value;

			if(password!=repassword){
			    window.alert("密碼不一致！");
			    return false;
			    }        		
			else if (document.reg_form.name.value==""){
				alert("請填姓名！");
				return false;
			}
			else if(document.reg_form.acc.value==""){
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
			else if(document.reg_form.mail.value==""){
				alert("請填信箱！");
				return false;
			}			
			else if(document.reg_form.age.value==""){
				alert("請填年齡！");
				return false;				
			}
			else if (age > 99 | age < 1){
				alert("年齡超過範圍(1~99)！");
				return false;	
			}		
			else{
				if(confirm("資料即將送出"))
					return true;
				else
					return false;
			}			
		}					
		 	
	</script>	
</head>
<body>
<h1>立即註冊</h1>
	<form action="Register" method="post" name="reg_form" onsubmit="return check()">
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
			<input name="mail" id="mail" type="text">
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
			<input name="age" id="age" type="number">
			</td>
			</tr>
			<tr>
			<td colspan = 2>								
			<input type="submit" value="註冊">
			<input type="reset" value="重設">			
			</td>
			</tr>
			</table>			
	</form>
</body>
</html>