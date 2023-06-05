<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
${aaa } <%--값을 나타내기 때문에 body에 써야 화면에 나옴 --%>
<% request.setAttribute("vv", "Eee"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${empty vv } <br/> <%--객체가 비어있는지 검사. empty <값> --%>
${"가나"+="다" }
</body>
</html>