<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>
<%
	String Name=request.getParameter("Name");
	if(Name==null){
		Name="無名訪客";
	}
%>
<p>嗨!!<%=Name%><br></p>
<p>歡迎進入JSP的世界!!</p>
</body>
</html>
