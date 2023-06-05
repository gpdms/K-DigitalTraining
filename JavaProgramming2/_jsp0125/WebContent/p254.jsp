<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setAttribute("name","연습"); //*얘랑
	String name1 = "test"; //#얘랑
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${10}<br/>
${10.123}<br/>
${requestScope.name} <br/> <%--*얘랑 --%>
${pageContext.request.requestURI} <br/>
<%=name1 %><br/> <%--#얘랑 --%>
${name1} <br/> <%--#얘랑. null임 --%>
${param.code1 } <br/> <%--url에 ?code1=1234 붙여주기 --%>
${param.code1 } <br/>

</body>
</html>