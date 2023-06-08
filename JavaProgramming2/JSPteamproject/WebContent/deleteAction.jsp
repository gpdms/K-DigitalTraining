<%@page import="user.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% int postNum = 0;
	if(request.getParameter("postNum") != null){
		postNum = Integer.parseInt(request.getParameter("postNum"));
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String board = request.getParameter("board");
System.out.println("딜리트 액션 보드값 = "+board);
Dao dao = Dao.getInstance();
dao.delete(postNum);
if(board.equals("main")){%>
<script type="text/javascript">
	location.href="main.jsp";
</script>
<%}else if(board.equals("mypage")){%>
	<script type="text/javascript">
	location.href="myPage.jsp";
</script>
<%}else{
response.sendRedirect("anolist.jsp?board="+board);}
%>
</body>
</html>