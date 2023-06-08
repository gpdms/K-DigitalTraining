<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String ttt = "2004"; //안됨
	int num = 2004; //안됨
%>
<c:set var="ttt" value="<%=ttt %>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%="10"+1 %><br/>
<%--<%=null+1%> 불가--%>
${null+1 } <br/> <%--표현언어에서는 null계산가능 --%>
${"10"+1 } <br/><%--"숫자":숫자로 인식, "문자":오류--%>
${"10"}${1} <br/>

<%= 3/2 %> <br/>
${3/2 }<br/>
${3 mod 2 }<br/>
${3==3 } <br/>
${3 eq 3 } <br/>

${ttt} <br/>
${ttt == '2004' } <br/>

</body>
</html>