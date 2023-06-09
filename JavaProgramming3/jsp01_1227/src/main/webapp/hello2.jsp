<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<h1>Web Programming</h1>
<input id="in" /><button id="btn">클릭</button>
<ul id="itemList">
<li>HTML</li>
<li>CSS</li>
<li>JS</li>
</ul>

<script>
btn.addEventListener("click", function(){
    console.log(document.getElementById("in").value);

var inT = document.getElementById("in").value;

var newLi = document.createElement("li")
var txNode = document.createTextNode(inT);
newLi.appendChild(txNode);
document.getElementById("itemList").appendChild(newLi);
});
</script>

</body>
</html>