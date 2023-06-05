<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>

<%
    request.setAttribute("name", "홍길동");
    request.setAttribute("money", 5000);
    request.setAttribute("dataList", new String[] {"a", "b", "c"}); 
%>

<!-- JSTL if  -->
<c:if test="${name == '홍길동'}">
    이름은 홍길동입니다.<br>
</c:if>

<!-- JSTL choose -->
<!--     if - else 또는 if - else if - else 구조를 구현 -->
<c:choose>
    <c:when test = "${money >= 10000}">
        돈 많아요.
    </c:when>
    <c:when test = "${money > 0}">
        돈 조금 있어요.
    </c:when>
    <c:otherwise>
        돈 하나도 없어요.
    </c:otherwise>
</c:choose>
<br><br>

<!-- JSTL forEach : 카운터 변수를 사용하는 반복문 -->
<c:forEach var="count" begin="0" end="30" step="3">
    ${count}
</c:forEach>
<br>

<!-- JSTL forEach : 배열 또는 리스트를 순회하는 반복문 -->
<c:forEach var="data" items="${dataList}">
    ${data}
</c:forEach>

</body>
</html>