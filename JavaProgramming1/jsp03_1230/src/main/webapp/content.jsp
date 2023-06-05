<%@page import="jdbc.Emp"%>
<%@page import="jdbc.EmpDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//사번눌렀을때 나오는 페이지
	int num = Integer.parseInt(request.getParameter("empno"));
	EmpDao ed = EmpDao.getInstance();
	Emp emp = ed.select(num);
	out.print(emp); //emp만하면 16진코드(?). Emp가서 toString해주기. or emp.getname()하면 이름만뜸.
	
%>
</body>
</html>