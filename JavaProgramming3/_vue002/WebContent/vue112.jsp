<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/vue@2.7.14/dist/vue.js"></script>
<div id="app">
<p>{{count}}</p>
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
</body>
</html>