<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>
<span id="tt"></span>
<input type="button" id="exe" value="실행" />
</p>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
//제이쿼리 ajax
$('#exe').click(function(){
	$.ajax({
		url: './list.jsp',
		success : function(x) {
			$('#tt').html(x);
		}
	})
	//console.log("test");
});
</script>
</body>
</html>