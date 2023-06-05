<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%-- <c:set>사용하기 위해 p.295보고쓰기 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	List<Long> vlst = Arrays.asList(1L,2L,5L,10L);
	//pageContext.setAttribute("vals", vlst); 얘랑
%>
<c:set var="vals" value="<%=vlst %>" /> <%--얘랑 같음 --%>
${vals }<br/>
${pageScope.vals } <br/>

</body>
</html>