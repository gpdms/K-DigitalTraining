<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul id="target"><li>여<strong>기</strong>에</li></ul>
<input type="text" id="in1" />
<button id="t1">text</button>
<button id="h1">html</button><br/>
<h2 id="h2">클릭!</h2>
<h2 id="h3">보이기</h2>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
$(function(){
	$("#t1").click(function(){
		//alert($("#target").text());
		$("#target").text($('#in1').val()); //자스는 "",''똑같음
	});
	$("#h1").click(function(){
		//alert($("#target").html());
		$("#target").html("<li>"+$('#in1').val()+"</li>");
	});
	$("#h2").click(function(){
		$(this).hide();
	});
	$("#h3").click(function() {
		$("#h2").show();
	})
});
</script>
</body>
</html>