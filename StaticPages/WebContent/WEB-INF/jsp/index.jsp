<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring Landing Page</title>
</head>
<body>
<h2>Spring Landing Page</h2>
<p>點擊以取得網頁</p>
<form:form method="GET" action="/StaticPages/staticPage">
<table>
    <tr>
    <td>
    <input type="submit" value="取得HTML頁面"/>
    </td>
    </tr>
</table>  
</form:form>
</body>
</html>