<%@ page contentType="text/html; charset=utf-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

<c:url value="http://search.daum.net/search" var="searchUrl">
	<c:param name="w" value="blog" />
	<c:param name="q" value="공원" />
</c:url>
<a href="${searchUrl}" >다음검색</a>
<ul>
	<li>${searchUrl}</li>
	<li><c:url value="/use_if_tag.jsp"  /></li> <%--절대경로 --%>
	<li><c:url value="./use_if_tag.jsp" /></li> <%--상대경로 --%>
</ul>

</body>
</html>
