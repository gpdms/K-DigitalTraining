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
<input v-model.lazy="myName" placeholder="이름" />
<%--v-model만 쓰면 바로 반영, .lazy붙이면 엔터누르거나 포커스가 벗어나면 반영 --%>
<p>나는 {{myName}}입니다.</p>
</div>
<script>
new Vue({
	el: "#app", 
	data: {
		myName: '안녕'
	}
})
</script>
</body>
</html>