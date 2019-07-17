<%@page contentType="text/html" pageEncoding="UTF-8"
         errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>加法網頁</title>
    </head>
    <body>
        ${param.a} + ${param.b} = ${param.a + param.b}<br>
		方法：${pageContext.request.method}<br>
		參數：${pageContext.request.queryString}<br>
		IP：${pageContext.request.remoteAddr}<br>    
    </body>
</html> 