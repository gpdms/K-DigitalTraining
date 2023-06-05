<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="en" /> <%--기본리소스 번들인 message.properties사용 --%>

<fmt:bundle basename="resource.message">
<fmt:message key="TITLE" var="aa"/>
<html>
<head><title>${aa}</title></head>
<body>

<fmt:message key="GREETING" />
<br>
<c:if test="${! empty param.id}"> <%--empty: null이냐 아니냐 --%>
<fmt:message key="VISITOR">
    <fmt:param value="${param.id}" />
</fmt:message>
</c:if>

</body>
</html>
</fmt:bundle>
