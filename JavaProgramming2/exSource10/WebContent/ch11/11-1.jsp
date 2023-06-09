<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>

<% 
    session.setAttribute("age", 20); 
%>

나이 : ${age}<br>

5년 뒤 나이 : ${age+5}<br>
5년 전 나이 : ${age-5}<br>

나이가 20살인가요? : ${age==20}<br>

</body>
</html>