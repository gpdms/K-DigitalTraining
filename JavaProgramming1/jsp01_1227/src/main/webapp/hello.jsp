<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>안녕</h1>
<script>
//alert("반갑습니다"); //페이지가 뜨기전에 alert먼저뜸.
console.log("Hello!");
//var reply = confirm("yes?"); 
//console.log(reply); //알림창에서 확인 누르면 true, 취소누르면 false
var name = prompt("이름은?", "디폴트");
console.log(name); //알림창에서 이름 입력하면 이름이 콘솔에 뜸.
document.write(name);//이름 입력하면 웹페이지에 뜸.
</script>
</body>
</html>