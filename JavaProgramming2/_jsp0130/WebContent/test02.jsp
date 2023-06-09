<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <%--page 디렉토리 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--taglib 디렉토리 --%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--choose태그는 switch나 if else혼합한 형태. 다수의 조건문을 하나의 블록에서 수행할 때 --%>
<c:choose>
<c:when test="${param.name == 'bk' }"> <%--url에 ?name=bk 치면 나옴 --%>
나온다
</c:when>
<c:when test= "${param.name == 'bk2' }">
나온다2
</c:when>
<c:otherwise>
when에 해당하지 않을 경우 otherwise
</c:otherwise>
</c:choose>

</body>
</html>