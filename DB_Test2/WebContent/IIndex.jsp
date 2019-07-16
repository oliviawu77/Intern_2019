<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="controller.DBController" %>
<%@ page import="controller.Data" %>
<%@ page import="java.util.ArrayList" %>    
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
	<input type="button" value="更換密碼" onclick="location.href='ChangePwd.jsp'">
	</td>
	</tr>
	<tr>
	<td>
	<input type="button" value="更換我的訊息" onclick="location.href='ChangeMsg.jsp'">
	</td>
	</tr>	
</table>
		<p>目前在線人數:${cont}</p>
	<table style="border:3px #FFD382 dashed;" cellpadding="10" border='1'>
	<tr>
	<th>
	ID
	</th>
	<th>
	帳戶
	</th>
	<th>
	訊息
	</th>
	<th>
	電子郵件
	</th>
	<th>
	性別
	</th>
	<th>
	年齡
	</th>			
	</tr>	
	<% 
		DBController dbc = new DBController();
		ArrayList<Data> temp = dbc.getData();
		for(int i=0; i<temp.size(); i++)
		{
			out.println("<tr>");
			out.println("<td>"+temp.get(i).id+"</td>");
			out.println("<td>"+temp.get(i).acc+"</td>");
			out.println("<td>"+temp.get(i).msg+"</td>");
			out.println("<td>"+temp.get(i).email+"</td>");
			out.println("<td>"+temp.get(i).sex+"</td>");
			out.println("<td>"+temp.get(i).age+"</td>");
			out.println("</tr>");
		}
	%>
	</table>		
  <!-- 新增logout button -->
	<form action='Logout'  method="post">
		<input name="button" type="submit" id="button" value="登出">
	</form>
</body>
</html>