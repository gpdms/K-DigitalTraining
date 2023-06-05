<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>버튼클릭하면 숫자 증가</title>
</head>
<body>
<%--vuejs cdn복붙 --%>
<script src="https://cdn.jsdelivr.net/npm/vue@2.7.14/dist/vue.js"></script>

<div id="app">
	<p>{{count}}회</p>
	<button v-on:click="countUp">증가</button>
	<button v-on:click="countDown">감소</button>
</div>



<script>
new Vue({
	el: "#app",
	data: {
		count: 0
	},
	methods: {
		countUp: function() {
			this.count++;
		},
		countDown: function() {
			this.count--;
		}
	}	
})
</script>

<%--
el: app이라는 아이디를 가진 태그를 찾아서 인스턴스를 붙여준다.
data: 데이터 속성을 줌. 
methods: 화면 동작과 이벤트로직을 제어하는 메소드
 --%>
</body>
</html>