<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--선언부 느낌표붙음 --%>
<%!
public int multiply(int a, int b) {
	int c = a*b;
	return c;
}
%>
<%--따로써야 --%>
<%
	int sum = 0;
for (int i=1; i<=10; i++){
	sum = sum + i;
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>1-10까지의 합</title>
</head>
<body>
10*25=<%= multiply(10,25) %> <br/>
1부터 10까지의 합은 <%=sum %> 입니다.
</body>
</html>