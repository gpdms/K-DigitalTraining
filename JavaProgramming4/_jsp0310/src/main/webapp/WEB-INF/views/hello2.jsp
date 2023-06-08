<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<jsp:include page="module/top.jsp" />

<h1>Hello, ${name}!</h1>
<button id="btn">클릭</button>
<jsp:include page="module/bottom.jsp" />

<script>
    console.log("안녕!");
    $('#btn').click(function(){
        alert('test');
    })
</script>
</body>
</html>