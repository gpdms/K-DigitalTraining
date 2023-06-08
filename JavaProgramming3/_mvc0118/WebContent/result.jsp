<%@page import="jdbc.Emp"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	//MyController.java랑 같이 보기
	List<Emp> lst = (List<Emp>) request.getAttribute("data"); //강제형변환
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
나왔다 <br/>
<%
for (Emp emp : lst) {
	out.println(emp+"<br/>");
}

//jsp를 실행시키는게 아니라 웹사이트를 실행시킴. 프로젝트를 실행시킴. 주소창 끝에 scott 입력해주기.

%>
</body>
</html>