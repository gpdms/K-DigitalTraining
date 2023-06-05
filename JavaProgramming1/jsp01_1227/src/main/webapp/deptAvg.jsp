<%@page import="jdbc.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<%
EmpDao ed = EmpDao.getInstance();
for (Emp emp : ed.selDeptSvg()) { %>
	<tr><td><%=emp.getDeptno() %></td>
	<td><%=emp.getJob() %></td>
	<td><%=emp.getSal() %></td></tr>
<%}
%>
</table>
</body>
</html>