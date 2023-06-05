<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <%--page 디렉토리 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--taglib 디렉토리 --%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>forEach태그</title>
</head>
<body>
<c:forEach var="i" begin="1" end="10">
<c:set var="sum" value="${sum+i }" />
</c:forEach>
${sum }
</body>
</html>