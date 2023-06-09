<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% //세션
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	if (id.equals(pass)) {//여는괄호 //연습용으로 아이디랑 비밀번호 같으면.
		session.setAttribute("MID", "ok"); //세션에 정보 넣음.(이름, 값)
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
로그인 성공
</body>
</html>
<% } //닫는괄호
	else { %>
<script type="text/javascript">
alert("로그인 실패");
history.go(-1);
</script>
<%		
	}
%>