<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table class = "aa" border="1"></table>
<h1></h1>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
$(function(){
	var list = ['홍', '김', '이', '박'];
	//반복문 for each
	$.each(list, function(i,v) { //(인덱스,값)
		console.log(v);
		$('.aa').append('<tr><td>'+v+'</td></tr>'); //.text하면 그자리에 값들이 대체됨. append는 기존에있던거에 추가
	});
	
	
});
</script>
</body>
</html>