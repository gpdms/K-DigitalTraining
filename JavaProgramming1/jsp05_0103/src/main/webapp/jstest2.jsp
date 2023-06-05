<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		//자바 스크립트에서 객체 생성하기
		var car = new Object();
		//객체를 구성하는 요소
		car.make = 'samsung';
		car.model = 'sm5';
		car.year = 2012;
		
		//Date 타입 인스턴스를 하나의 프로퍼티로 지정
		car.buydate = new Date(2012, 12, 1);
		
		var owner = new Object();
		owner.name = "wonder girls";
		owner.age = 20;
		
		//프로퍼티의 값이 자바스크립트의 객체이다.
		car.owner = owner;
		
		console.log(car.make);
		console.log(car.model);
		//중첩된 프로퍼티에 접근하기
		console.log(car.owner.name);
	})
</script>
</body>
</html>