<%@page import="java.net.URLDecoder"%>
<%@ page contentType = "text/html; charset=utf-8" %>
<%@ page import = "java.net.URLEncoder" %>
<%
	Cookie cookie1 = new Cookie("path1", //쿠키이름
			URLEncoder.encode("경로:/chap09/path1", "utf-8")); //쿠키값
	cookie1.setPath("/chap09/path1"); //프로젝트 디렉토리 경로
	response.addCookie(cookie1);
	
	Cookie cookie2 = new Cookie("path2", 
			URLEncoder.encode("경로:", "utf-8"));
	response.addCookie(cookie2);
	
	Cookie cookie3 = new Cookie("path3",
			URLEncoder.encode("경로:/", "utf-8"));
	cookie3.setPath("/");
	response.addCookie(cookie3);

	Cookie cookie4 = new Cookie("path4",
			URLEncoder.encode("경로:/chap09/path2", "utf-8"));
	cookie4.setPath("/chap09/path2");
	response.addCookie(cookie4);
%>

<html>
<head><title>쿠키 경로 지정</title></head>
<body>

다음과 같이 쿠키를 생성했습니다.<br>
<%= cookie1.getName() %>=<%= URLDecoder.decode(cookie1.getValue(), "utf-8") %><br> <%--유니코드로 한글깨짐.decode --%>
[<%= cookie1.getPath() %>]
<br>
<%= cookie2.getName() %>=<%= URLDecoder.decode(cookie2.getValue(), "utf-8") %>
[<%= cookie2.getPath() %>]
<br>
<%= cookie3.getName() %>=<%= URLDecoder.decode(cookie3.getValue(), "utf-8") %>
[<%= cookie3.getPath() %>]
<br>
<%= cookie4.getName() %>=<%= URLDecoder.decode(cookie4.getValue(), "utf-8") %>
[<%= cookie4.getPath() %>]

</body>
</html>
