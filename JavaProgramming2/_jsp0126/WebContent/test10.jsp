<%@page import="_jsp0126.Ther"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Ther ther = new Ther();//객체생성(Ther.java파일)
	ther.setCel("서울", -7.0);
	request.setAttribute("t", ther);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${t.info }<br/> <%--필드에 존재하지 않더라도. 메소드 --%>
${t.cel }<br/> <%--왜안되지 --%>
${t.fah }<br/>
</body>
</html>