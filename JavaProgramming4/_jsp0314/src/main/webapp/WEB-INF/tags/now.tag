<%@ tag body-content="empty" pageEncoding="utf-8" %> <!--body-content="empty" 몸체를 쓰는건 없다.?-->
<%@ tag import="java.util.Calendar"  %>
<%
    Calendar cal = Calendar.getInstance();
%>
<%= cal.get(Calendar.YEAR)%> 년
<%= cal.get(Calendar.MONTH+1)%> 월 <!--0월부터 시작해서 +1-->
<%= cal.get(Calendar.DATE)%> 일