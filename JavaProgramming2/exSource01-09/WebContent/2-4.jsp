<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.*" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>테스트 페이지</title>
</head>
<body>
가&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;나<br/>
<%
    out.println("println이나 \n 개행문자를 사용했다고");
    out.println("줄이 넘어가지 않습니다.<br>");
    
    out.println("줄을 넘기려면 br 태그를 사용해야 합니다.<br><br>");
    
    out.println("연속된 공백은             공백 한 개로 출력<br>");
    out.println("         줄 시작부터 나오는 공백들은 무시됨<br><br>");

    out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;의도적인 공백");
%>
</body>
</html>