<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("someVal", "test");
	String aa = "test"; 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${someVal == 'test' } <br/>
<%=aa.equals("test") %> <br/>
<%=aa.compareTo("test") %><br/> <%--같으면 0, 다르면 -1 --%>
</body>
</html>