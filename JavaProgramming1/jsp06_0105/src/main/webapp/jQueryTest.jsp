<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class = "aa"></div>
<h1></h1>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
$(function(){
	var list = [123, '<h1>3.45</h1>', '테스트', new Date()]; //자바스크립트 배열은 아무거나 다됨
	console.log(list);
	$("h1").html(list);
	//.text와 .html차이
	//text는 '<h1>3.45</h1>'을 문자로 인식.
	//html은 태그로 인식
	//id는 #, class는 ., 태그는 아무것도안붙이고.
	
	
});
</script>
</body>
</html>