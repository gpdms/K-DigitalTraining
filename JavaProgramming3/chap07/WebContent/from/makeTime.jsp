<%@ page contentType = "text/html; charset=utf-8" %>
<%@ page import = "java.util.Calendar" %>
<%
	Calendar cal = Calendar.getInstance();
	request.setAttribute("time", cal);
						//문자열 아니고 객체임
%>
<jsp:forward page="/to/viewTime.jsp" />
