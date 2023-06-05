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
    <p v-text="myText"></p> <%--위와 똑같음 --%>
    <p v-html="myText"></p> <%--html은 다른점이 <h2>같은 태그요소가 들어가면  --%>
</div>
<script>
    new Vue({
        el: '#app',
        data: {
            myText: '<h2>Hello!!!</h2>' 
        }
    })
</script>
</body>
</html>