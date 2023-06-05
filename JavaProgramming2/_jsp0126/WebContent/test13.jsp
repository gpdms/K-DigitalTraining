<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%-- <c:set>사용하기 위해 p.295보고쓰기 --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>스트림 API 사용하기</title>
</head>
<body>
<%--p.303
	${}는 value에 씀. --%>
<c:forEach var="i" begin="1" end="10" step="2">
${i}&nbsp;&nbsp;&nbsp;
</c:forEach>
</body>
</html>