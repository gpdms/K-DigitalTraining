<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-03-14
  Time: 오전 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<tf:header title="텍스트 제목" level="3"/>
<tf:now/>
<tf:header title="${aaa}" />
</body>
</html>
