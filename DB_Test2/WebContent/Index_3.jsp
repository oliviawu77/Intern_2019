<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="controller.DBController" %>
<%@ page import="controller.Data" %>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
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
	<input type="button" value="編輯使用者資料" onclick="location.href='User_edit.jsp'">
	</td>
	</tr>		
</table>
		<p>目前在線人數:${cont}</p>
<table style="border:3px #FFD382 dashed;" cellpadding="10" border='1'>
<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/crud"
     user="root"  password="12345678"/>
 
<sql:query dataSource="${db}" var="result">
SELECT * from account;
</sql:query>
 
<tr>
   <th>ID</th>
   <th>姓名</th>
   <th>帳戶</th>
   <th>訊息</th>
   <th>電子郵件</th>
   <th>性別</th>
   <th>年齡</th>
</tr>
<c:forEach var="row" items="${result.rows}">
<tr>
   <td><c:out value="${row.ID}"/></td>
   <td><c:out value="${row.Name}"/></td>
   <td><c:out value="${row.Account}"/></td>
   <td><c:out value="${row.Message}"/></td>
   <td><c:out value="${row.Email}"/></td>
   <td><c:out value="${row.Sex}"/></td>
   <td><c:out value="${row.Age}"/></td>
</tr>
</c:forEach>
</table><br>		
  <!-- 新增logout button -->
	<form action='Logout'  method="post">
		<input name="button" type="submit" id="button" value="登出">
	</form>
</body>
</html>