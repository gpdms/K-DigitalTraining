<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form>
	<input type="hidden" name="seq" value="1">
	<label> 이름을 입력하세요: </label>
	<input type="text" name="username"/> <br/>
	<label> 패스워드를 입력하세요: </label>
	<input type="password" name="password"/> <br/>
	<input type="checkbox" name="hobby" value="music"/> music
	<input type="checkbox" name="hobby" value="yoga"/> yoga
	<input type="checkbox" name="hobby" value="reading"/> reading <br/>
	<input type="button" id="submit" value="전송"/> 
</form>
<hr>
<div id="result"></div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
//form에 action넣지 않고 action주는법
//form데이터를 쿼리스트링으로 변환하기
$(function() {
	$(function(){
		$('#submit').click(function() {
			var form_data = $('form').serialize(); //#이나.없으면 태그 //쿼리스트링을 만들어줌
			$('#result').text(form_data);
		});
	});
});
</script>
</body>
</html>