<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Vue.js sample</title>
    <link rel="stylesheet" href="style.css" >
    <script src="https://cdn.jsdelivr.net/npm/vue@2.5.17/dist/vue.js"></script>
</head>
<body>
<div id="app">
    <p> {{ myText }} </p>
    <p> {{ myPrice }} </p>
    <p> {{ myTea }} </p>
    <p> {{$data}} </p> <%--data정보 다가져옴. --%>
    <hr>
    <li v-for="(item, key) in $data">
    {{key}} : {{item}}
    </li>
</div>
<script>
	var teaList = [
		{name: '히비스커스', price: 3000}, //객체
		{name: '얼그레이', price: 2000},
		{name: '캐모마일', price: 5000},
	];
    new Vue({
        el: '#app',
        data: {
        	myTea: teaList, 
            myText: ['홍길동', '홍길금', '홍길은'], //배열
            myPrice: 500 //숫자
        }
    })
</script>
</body>
</html>