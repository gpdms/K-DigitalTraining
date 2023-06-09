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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<div id="app">
<input v-model="empno" placeholder="검색" />
<button v-on:click="select">검색</button>
<p>{{empno}}</p>
<h3 id="en">{{aaa}}</h3>
</div>

<script>
new Vue({
	el: "#app",
	data: {
		empno: '',
		aaa: ''
	},
	methods: {
		select: function() {
			var ss = this;
			console.log(this.empno);
			//this.aaa = 'test';
			fetch('fetchEmpJsonOne.jsp?empno='+this.empno)
			.then(res => res.json())
			.then(function(data){
				console.log(data.ename, data.job, data.sal);
				ss.aaa = data.ename; 
				//$('#en').text(data.ename+","+data.job+","+data.sal); //제이쿼리로 쓰는 방법
			});
		}
	}
})
</script>
</body>
</html>


