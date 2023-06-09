<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${list=[1,2,3,4,5]; sum = list.stream().sum(); '' }
${list } ${sum} <br/>
${list.stream().filter(x-> x%2 == 0 ).toList() } <br/>
${list.stream().filter(n-> n%2 == 0 ).map(x->x*x).toList() } 
</body>
</html>