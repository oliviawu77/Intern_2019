<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="controller.DBController" %>
<%@ page import="controller.Data" %>    
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>登入</title>
</head>
<body>
	<% 
		DBController dbc = new DBController();
		ArrayList<Data> temp = dbc.getData();
	%>
	<form action="MyFirstServlet" method="post">
		<label for="acc">帳號:</label><br>
		<input id="acc" type="text"><br>
		<label for="pwd">密碼:</label><br>
		<input id="pwd" type="text"><br>
		<input type="button" value="登入">
	</form>
	<table border=1>
	<tr>
	<th>
	ID
	</th>
	<th>
	帳號
	</th>
	<th>
	密碼
	</th>
	</tr>

	<%
		for(int i=0; i<temp.size(); i++)
		{
			out.println("<tr>");
			out.println("<td>"+temp.get(i).id+"</td>");
			out.println("<td>"+temp.get(i).acc+"</td>");
			out.println("<td>"+temp.get(i).pwd+"</td>");
			out.println("</tr>");
		}
	%>
	</table>
	<script type="text/javascript">
	
	</script>
</body>
</html>