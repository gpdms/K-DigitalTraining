<%@page import="_jsp0126.Score"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
//객체생성(Score는 클래스파일)
	Score sc = new Score("홍길동",98);
	request.setAttribute("sco",sc);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${sco } <br/>
${sco.name }${sco.kor }
<%--getter setter지우면 오류뜸.
	.getName() -> .name
	.getKor() -> .kor
get제거, 대문자 소문자로, 괄호지우기. 이런 룰을 가지고 호출하고 있음. --%>
</body>
</html>