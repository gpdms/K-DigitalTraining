<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//javax.servlet.http.Cookie 원래 지원해주는 클래스임. import안해도 되는 이유.
	Cookie ck = new Cookie("name", "test"); //(name,value)
	//response도 원래 있는 객체
	response.addCookie(ck);
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
쿠키생성
<%=ck.getName() %>:<%=ck.getValue() %>
<%--메소드는 책p.208에서 --%>
</body>
</html>