<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8"); //한글깨짐 방지
%>

<%--useBean --%>
<jsp:useBean id="mi" class="_jsp0118.MemberInfo"/> <%--비어있는 객체 하나가 생성. --%>
<%-- <jsp:setProperty property="id" name="mi"/>--%> <%--ㅡmemForm으로부터 input 받은 값을 set --%>
<%-- <jsp:setProperty property="password" name="mi"/>--%>
<jsp:setProperty property="*" name="mi"/><%--위 두개를 합쳐서 *로. --%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%--연습 --%>
<%--<jsp:setProperty property="email" name="mi" value="rrr"/> --%> <%--mi라는 객체에 email프로퍼티, 값을 rrr --%>
<%--<jsp:getProperty property="email" name="mi"/>--%> <%--set해놓은걸 get함. 그래서 화면 출력. --%>


<%-- 여기가 진짜 --%>
<%--useBean: MemberInfo의 getter setter를 사용하고 있음. 멤버필드가 private인데 가져올 수 있는 이유임. setId이면 내부적으로 set제거,대문자를 소문자로. --%>
<jsp:getProperty property="id" name="mi"/> <br/>
<jsp:getProperty property="password" name="mi"/><br/>
<jsp:getProperty property="name" name="mi"/><br/>
<jsp:getProperty property="email" name="mi"/><br/>
<jsp:getProperty property="registerDate" name="mi"/><br/>

</body>
</html>