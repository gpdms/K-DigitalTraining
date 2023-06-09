<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ol>
</ol>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
var list2 = ['Jessica', new Date(), true, 'Crystal', 3.14]; //모든타입 다 가능
for (var i=0; i<list2.length; i++) {
	console.log(list2[i]);
}

//이방법을 더 많이 씀
//제이쿼리
	$(function() {
		var list = ['Jessica', 'Tiffany', 'Sunny', 'Crystal', 3.14]
		$.each(list, function(i, v) {
			$('ol').append('<li>'+v+'</li>');
		});
	});
</script>
</body>
</html>