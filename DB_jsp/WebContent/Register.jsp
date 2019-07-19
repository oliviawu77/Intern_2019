<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page import="java.sql.*,java.util.*"%>

<%
String name=request.getParameter("name");
String acc=request.getParameter("acc");
String pwd=request.getParameter("pwd");
String pwd_check=request.getParameter("pwd_check");
String email=request.getParameter("mail");
String sex=request.getParameter("sex");
String age=request.getParameter("age");
%>
<%
	try
	{
	request.setCharacterEncoding("UTF-8");

	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud", "root", "12345678");
	Statement st=conn.createStatement();
	ResultSet rs;
	int size = 0;
	String query = "select * from account";
	rs = st.executeQuery(query);
	while (rs.next()) {
			size++;
	}
	size++;
	query = "INSERT INTO `crud`.`account`(`ID`, `Account`, `Password`, `Message`, `Email`, `Sex`, `Age`, `Name`) VALUE('"+ size +"','"+ acc +"','"+ pwd +"','update','"+ email + "','"+ sex +"','"+ age +"','"+name+"')";
	System.out.println(query);
	st.executeUpdate(query);
	
	out.println("感謝你的註冊！ 請 <a href='login.html'>回到登入頁面</a>.");
	}
	catch(Exception e)
	{
	System.out.print(e);
	e.printStackTrace();
	}
%>