<%@page import="jdbc.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Dept dept = (Dept) session.getAttribute("tt"); //세션정보에서 나온것. 권한이 안되면 안된다고 나오는것.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=dept.getDeptno() %>
<%=dept.getDname() %>
<%=dept.getLoc() %>
</body>
</html>