<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <%--page 디렉토리 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--taglib 디렉토리 --%> 
<% //해시맵
	HashMap<String, Object> mapData = new HashMap<>();
	//Map이라고 써도됨. 인터페이스임.   =   얘는 클래스
	mapData.put("name", "홍");
	mapData.put("today", new Date()); //오늘 날짜
	
	List<String> mlst = new ArrayList<>();
	mlst.add("김");
	mlst.add("이");
	mlst.add("박");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HashMap</title>
</head>
<body>

<c:set var="intArray" value="<%=new int[]{1,2,3,4,5} %>"/>
<c:forEach var="i" items="${intArray }" varStatus="dd">
${i }<%--items들의 값 --%> ${dd.index }<%--items배열의 인덱스.0부터시작.고정 --%> ${dd.count }<%--1부터시작.출력된것부터 차례로 순서 --%> <br/>
</c:forEach>

<c:forEach var="ss" items="<%=mlst %>">
${ss } <br/>
</c:forEach>

<c:set var="map" value="<%=mapData %>" /> <%--변수로 쓰려고 --%>
<c:forEach var="i" items="${map }"> <%--아님 여기다가 <%=mapData%>그대로 넣어도. --%>
${i.key } ${i.value } <br/>
</c:forEach>

</body>
</html>