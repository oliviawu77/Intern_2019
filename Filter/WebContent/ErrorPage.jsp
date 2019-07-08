<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		<%=request.getServletContext().getInitParameter("ERROR")%>.
	</h1>
	<form action='home'>
		<input name="button" type="submit" id="button" value="Home">
	</form>

</body>
</html>