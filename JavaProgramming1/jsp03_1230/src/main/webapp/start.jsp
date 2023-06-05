<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- UI -->
<p>
<span id="tb"></span>
<span id="tb2"></span>
<input type="button" id="exe" value="사원정보"/>
</p>
<!-- ui끝 -->

<!-- 제이쿼리 googleCDN에서 복붙 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
$('#exe').click(function(){
	//제이쿼리약자$, 메소드 ajax, ()가 객체같은것.
	$.ajax({
		url: 'list.jsp', //url에 프로그램을 넣음. 사실 html문서를 통째로 가져옴. 테이블부분만 필요한디.list.jsp에서 필요없는부분지워줌.뭘지우라는건지모르겠다
		success: function(data) {
			//console.log(data);
			$('#tb').html(data); //html형식으로 데이터를 집어넣음. text로바꾸면 text로
		}
	});
});



function detail(empno) {
	console.log(empno);
	$.ajax({
		url:'content.jsp?empno='+empno,
		success: function(data){
			$('#tb2').html(data);
		}
	});
}

function order(v) {
	console.log(v);
	$.ajax({
		url: 'list.jsp?order='+v,
		success: function(data) {
			$('#tb').html(data);
		}
	});
}

</script>
</body>
</html>