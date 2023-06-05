<%@ page contentType = "text/html; charset=utf-8" %>
<%@ page import = "util.Cookies" %> <%--저자가 만든 유틸리티 --%>
<%
//유틸리티 사용법
	response.addCookie(Cookies.createCookie("name", "최범균")); //저자가만든 유틸리티 Cookies클래스의 createCookie메소드.
	response.addCookie(
		Cookies.createCookie("id", "madvirus", "/chap09", -1)); //(쿠키이름,값,경로, 브라우저닫으면 쿠키 삭제)
%>
<html>
<head><title>Cookies 사용 예</title></head>
<body>

Cookies를 사용하여 쿠키 생성

</body>
</html>
