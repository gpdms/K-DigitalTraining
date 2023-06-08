<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import = "user.*" %>
 <%
	request.setCharacterEncoding("utf-8"); //한글깨짐 방지
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
// 수정할 댓글을 받아왔다. LookBoard.jsp에서.
Dao dao = Dao.getInstance();
int commentNum = Integer.parseInt(request.getParameter("commentNum"));
/* int postNum = Integer.parseInt(request.getParameter("postNum")); */
int postNum = (int)session.getAttribute("postNum");
System.out.println("이건 업데이트코멘트 페이지에서 확인한 코멘트 넘버 = "+request.getParameter("commentNum"));
String updateComment = request.getParameter("updateCommentTextArea");
System.out.println("이건 업데이트코멘트 페이지에서 확인한 코멘트area = "+ request.getParameter("updateCommentTextArea"));

int result = dao.updateComment(updateComment, commentNum);
if(result == 1){%>


<%}%>

<script type="text/javascript">
 location.href = "view.jsp";
 alert("댓글이 수정되었습니다.");
</script>
</body>
</html>