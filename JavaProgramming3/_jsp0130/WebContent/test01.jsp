<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="true"> <%--true여야만 화면에 나옴. true이외의 것들 쓰면 모두 false --%>
무조건 실행
</c:if><br/>

<c:set var="aa" value="qq"/>
<c:set var="bb" value="${param.ddd }"/>

<c:if test="${aa == 'qq' }"> <%--참이니까 --%>
나온다
</c:if><br/>

<c:if test="${bb == 'mm' }"> <%--url에 ?ddd=mm 치면 나옴. param은 키워드.get방식 --%>
나온다2
</c:if><br/>

<c:if test="${param.vv >18 }"> <%--?ddd=mm&vv=20치면 나옴. --%>
나온다3
</c:if><br/>

</body>
</html>