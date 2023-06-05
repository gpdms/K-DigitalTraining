<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>함수</h1>
<script>

//var ss = 40; 가능
//test();//위로 옮겨도 작동
var x = 10;
function test() {
	//var ss = 100; var쓰는 순간 지역변수
	//ss = 100; 가능
	let y = 20;
	const dd=90;
	y=70;
	console.log("x:"+x);
	console.log("y:"+y);
	//var y = 20;
}
//console.log(ss); 가능
test();

//html p.535
//익명함수. function다음 함수이름이 없음.
let sum = function(a,b) { //변수sum에 함수를붙임.
	console.log(a+b);
}
sum(70, 80);
sum = "test";
console.log(sum);

//즉시실행함수
(function(a,b){
	console.log(a+b);
})(50,60);

//화살표 함수
const hi = () => console.log("안녕"); //중괄호묶어서 여러문장 가능.
hi();

let sumi = (a,b) => a+b;
console.log(sumi(2,3));

</script>
</body>
</html>