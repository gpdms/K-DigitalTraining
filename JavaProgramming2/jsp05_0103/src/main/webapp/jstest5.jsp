<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
td {
  border: 1px solid gray;
}
</style>
</head>
<body>
<table id="treeData"></table>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
/*	$.getJSON('item.json', function(data, textStatus) {
		console.log(data);
        $("#treeData").append(
                 "<tr><td>id</td>" + "<td>name</td>" 
               + "<td>price</td>" + "<td>description</td>" + "</tr>");
        $.each(data, function() {
              $("#treeData").append("<tr>" + "<td>"                 
                      + this.id + "</td>" + "<td>"
                      + this.name + "</td>" + "<td align='right'>"
                      + this.price + "</td>" + "<td>"
                      + this.description + "</td>" + "</tr>");
          });
	 });*/
	 
	 $.ajax({
		url: "item.json",
		dataType: "json",
		success: function(data) {
			$("#treeData").append(
	                 "<tr><td>id</td>" + "<td>name</td>" 
	               + "<td>price</td>" + "<td>description</td>" + "</tr>");
	        $.each(data, function() {
	              $("#treeData").append("<tr>" + "<td>"                 
	                      + this.id + "</td>" + "<td>"
	                      + this.name + "</td>" + "<td align='right'>"
	                      + this.price + "</td>" + "<td>"
	                      + this.description + "</td>" + "</tr>");
	          });
		}
	 });
});
</script>
</body>
</html>