<%@page import="com.board.db.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>

<%
    BoardDto s = new BoardDto();
    s.setWriter("홍길동");
    s.setNum(123);
    
    request.setAttribute("score1", s);
%>
    이름 : ${score1.writer}<br>
  글번호 : ${score1.num}<br>
    
</body>
</html>