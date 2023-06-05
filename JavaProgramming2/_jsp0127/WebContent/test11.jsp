<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${[1,2,3,4,5].stream().anyMatch(v-> v > 4).get() } <br/>
	<%--1~5 중에 하나만 매치가 되면 true --%>
${[1,2,3,4,5].stream().allMatch(v-> v > 4).get() } <br/>
	<%--전부 매치가 되면 true --%>
${[1,2,3,4,5].stream().noneMatch(v-> v > 6).get() } <br/>	
</body>
</html>