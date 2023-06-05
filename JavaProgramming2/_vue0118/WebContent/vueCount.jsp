<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
    <title>Vue.js sample</title>
    <link rel="stylesheet" href="style.css" >
    <script src="https://cdn.jsdelivr.net/npm/vue@2.5.17/dist/vue.js"></script>
</head>
<body>
<div id="app">
    <p> {{ count }}회 </p>
    <button v-on:click="countUp">카운터</button>
</div>
<script>
    new Vue({
        el: '#app',
        data: {
            count: 0
        },
        methods: {
        	countUp: function() {
        		this.count++;
        	}
        }
    })
</script>
</body>
</html>