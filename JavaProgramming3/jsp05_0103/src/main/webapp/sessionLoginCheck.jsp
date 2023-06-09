<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% //로그인 여부 확인
	String mid = (String) session.getAttribute("MID");
	if (mid != null && mid.equals("ok")) { //로그인 상태 체크. 유지

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
로그인 상태
</body>
</html>
<%} else {%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
로그아웃 상태
</body>
</html>
<% } %>

