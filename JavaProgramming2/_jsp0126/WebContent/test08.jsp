<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%-- <c:set>사용하기 위해 p.295보고쓰기 --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- <%request.setAttribute("var1", 10L); %>
<c:set var="var1" value="${10 }" /> <%--이두개가 같음. --%>
 -->
${var1 =10;'' } <%--할당연산자. 위 기능과 동일함. --%>
				<%--세미콜론 연산자. 뒤값이 덮어씀. ''안쓰면 500오류뜸. --%>
${var1 } <br/>

${hh=['a','b','c'];''} <%--''안쓰면 두번출력되니까. 실행은해주고 출력은 안되게 '' --%>
${hh }<br/>
\${hh }<br/> <%--문자열로 처리 --%>
</body>
</html>