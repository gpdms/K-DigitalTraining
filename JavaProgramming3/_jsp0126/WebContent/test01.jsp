<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String aa = "test"; //출력안됨.
	request.setAttribute("aa1","test1"); //출력됨.
	//request대신 session, application, pageContext도 똑같이 출력됨.
	pageContext.setAttribute("aa2","test2");
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${ aa1 } <br/>
${aa2 } <br/>
${applicationScope.aa } <%--이렇게 잘안쓰고 위처럼 씀. 탐색해서 알아서 해주기때문--%>
${'10' + 12 }<br/> <%--문자열이 아니라 숫자로 인식. --%>
${'10' }${'12' }<br/> <%--이렇게 쓰면 문자열 --%>
<%--${'십'+'10' } 오류 --%>
</body>
</html>