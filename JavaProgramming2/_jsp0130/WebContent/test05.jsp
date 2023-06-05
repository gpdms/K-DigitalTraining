<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>forTokens 태그</title>
</head>
<body>

<c:forTokens var="tk" items="1,2;3,4;5" delims=",">
${tk }<br/>
</c:forTokens>

</body>
</html>