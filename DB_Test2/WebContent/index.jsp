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
<h1>${wel_message}</h1>
<h2>${message}</h2>
<table>
	<tr>
	<td>
	<input type="button" value="編輯使用者資料" onclick="location.href='userEdit.jsp'">
	</td>
	</tr>		
</table>
		<p>目前在線人數:${cont}</p>
	<table style="border:3px #FFD382 dashed;" cellpadding="10" border='1'>
	<thead>
	<tr>
	<th>
	ID
	</th>
	<th>
	姓名
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
	</thead>
	<% 
		DBController dbc = new DBController();
		ArrayList<Data> temp = dbc.getData();
		for(int i=0; i<temp.size(); i++)
		{
			out.println("<tr>");
			out.println("<td>"+temp.get(i).id+"</td>");
			out.println("<td>"+temp.get(i).name+"</td>");
			out.println("<td>"+temp.get(i).acc+"</td>");
			out.println("<td>"+temp.get(i).msg+"</td>");
			out.println("<td>"+temp.get(i).email+"</td>");
			out.println("<td>"+temp.get(i).sex+"</td>");
			out.println("<td>"+temp.get(i).age+"</td>");
			out.println("</tr>");
		}
	%>
	</table><br>		
  <!-- 新增logout button -->
	<form action='Logout'  method="post">
		<input name="button" type="submit" id="button" value="登出">
	</form>
</body>
</html>