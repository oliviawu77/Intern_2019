<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<body>
<jsp:useBean id="students" class="com.java2s.StudentsBean"> 
   <jsp:setProperty name="students" property="firstName" value="Jack"/>
   <jsp:setProperty name="students" property="lastName" value="Smith"/>
</jsp:useBean>

<p>Student First Name: <jsp:getProperty name="students" property="firstName"/>
</p>
<p>Student Last Name: <jsp:getProperty name="students" property="lastName"/>
</p>


</body>
</html>