<%@ page contentType = "text/html; charset=utf-8" %>
<%@ page import = "java.net.URLEncoder" %>
<%
	//p.215
	Cookie cookie1 = new Cookie("id", "madvirus");
	cookie1.setDomain(".somehost.com"); //somehost.com이 도메인, 점 앞은 맘대로 넣을 수 있음. somehost앞에 점만 찍은 것은 앞을 다 포함한다는 뜻
										//도메인 주소가 내 소유여야 setDomain됨. so hosts메모장에 javacan.somehost.com넣어줌
	response.addCookie(cookie1);
	
	Cookie cookie2 = new Cookie("only", "onlycookie"); //localhost는 다되니까 얘는 되고
	response.addCookie(cookie2);

	Cookie cookie3 = new Cookie("invalid", "invalidcookie"); //얘는 안됨
	cookie3.setDomain("javacan.tistory.com");
	response.addCookie(cookie3);
%>
<html>
<head><title>쿠키생성</title></head>
<body>

다음과 같이 쿠키를 생성했습니다.<br>
<%= cookie1.getName() %>=<%= cookie1.getValue() %>
[<%= cookie1.getDomain() %>]
<br>
<%= cookie2.getName() %>=<%= cookie2.getValue() %>
[<%= cookie2.getDomain() %>]
<br>
<%= cookie3.getName() %>=<%= cookie3.getValue() %>
[<%= cookie3.getDomain() %>]

</body>
</html>
