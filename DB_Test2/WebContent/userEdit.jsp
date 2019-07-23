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
	<form action="EditUser" method="post" name="reg_form" onsubmit="return check()">
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
			密碼:
			</td>
			<td>
			<input name="pwd" id="pwd" type="password">
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
			訊息:
			</td>
			<td>
			<input name="msg" id="msg" type="text">
			</td>
			</tr>			
			<tr>
			<td>			
			性別:
			</td>
			<td>
			<input type="radio" name="sex" id="sex" value="male">男
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
			<input type="submit" value="更新">
			<input type="reset" value="重設">			
			</td>
			</tr>
			</table>			
	</form>
</body>
</html>