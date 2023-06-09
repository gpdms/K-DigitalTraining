<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.*" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>테스트 페이지</title>
</head>
<body>
<%
    out.println("오늘 날짜 : " + LocalDate.now() + "<br>");
    out.println("현재 시간 : " + LocalTime.now());
%>
</body>
</html>