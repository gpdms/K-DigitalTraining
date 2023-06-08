<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String ss ="test";
	//request.setAttribute("ss2", "test");
%>
<c:set var="ss2" value="<%=ss %>" scope="request"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
=><%=ss %> <br/>
표현언어 ${ss } <br/> <%--null임 --%>
표현언어 ${ss2 } <br/>
<%=request.getAttribute("ss2") %>
</body>
</html>