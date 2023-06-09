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
<c:set var="vals" value="${{'name': '홍', 'age':20}}"  />
						<%--key : value 맵--%>
${vals.name}
${vals.age } <br/>

<c:set var="han" value="${{'가','가','나', '가'}}"  />
${han } <%--set타입은 중복 제거됨 --%>

</body>
</html>