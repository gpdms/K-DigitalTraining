<%@ page contentType = "text/html; charset=utf-8" %>
<html>
<head><title>로그인폼</title></head>
<body>
			<%-- getContextPath() 프로젝트명임. 없어도되는데 프로젝트명 명시하려고--%>
<form action="<%= request.getContextPath() %>/member/login.jsp"
      method="post">
아이디 <input type="text" name="id" size="10">
암호 <input type="password" name="password" size="10">
<input type="submit" value="로그인">
</form>

</body>
</html>
