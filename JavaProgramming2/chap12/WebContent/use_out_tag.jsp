<%@ page contentType = "text/html; charset=utf-8" %>
<%@ page import = "java.io.IOException, java.io.FileReader" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>소스 보기</title></head>
<body>
<%--실행해서 url에 ?path=use_out_tag.jsp--%>
<%
	FileReader reader = null;
	try {
		String path = request.getParameter("path");
		reader = new FileReader(getServletContext().getRealPath(path));
								//Context는 프로젝트명. 루트 밑에 프로젝트명까지 경로
%>
<pre>
소스 코드 = <%= path %>
<c:out value="<%= reader %>" escapeXml="true" /> <%--escapeXml: 태그 탈출 --%>
</pre>
<%
	} catch(IOException ex) {
%>
에러: <%= ex.getMessage() %>
<% 
	} finally {
		if (reader != null)
			try {
				reader.close();
			} catch(IOException ex) {}
	}
%>

</body>
</html>
