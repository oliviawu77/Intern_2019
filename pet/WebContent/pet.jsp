<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset= "UTF-8">
        <title>寵物類型大調查</title>
    </head>
    <body>
        <form action="pet" method="post">
            姓名：<input type="text" name="user"><br>
            郵件：<input type="email" name="email"><br>
            你喜愛的寵物代表：<br>
            <select name="type" size="6" multiple>
                <option value="貓">貓</option>
                <option value="狗">狗</option>
                <option value="魚">魚</option>
                <option value="鳥">鳥</option>
            </select><br>
            <input type="submit" value="送出"/>
        </form>
    </body>
</html> 