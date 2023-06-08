<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="user.*"%>
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
	Comment comment = new Comment();
	Dao dao = Dao.getInstance();
	String commentContent = request.getParameter("commentcontent");
	System.out.println("insert into commentContent = " + commentContent);
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	int studentNum = Integer.parseInt(request.getParameter("studentNum"));
	int postNum = Integer.parseInt(request.getParameter("postNum"));

	comment.setPostNum(postNum); //LookBoard.jsp로 돌아가도 postNum 유지하기 위해 

	System.out.println("from here commentAction");
	System.out.println("title : " + title);
	System.out.println("content : " + content);
	System.out.println("content : " + content);
	System.out.println("commentcontent dsdsada = "+commentContent);
	System.out.println(postNum);
	int result = dao.insertCommentContent(postNum, studentNum, commentContent.trim());

	/*자신의 commentNum을 찾는 메서드  */
	int commentNumber = dao.selectCommentNum(commentContent);

	if (result == 0) {%>
	<script type="text/javascript">
		alert("공백이 아닌 댓글을 입력해 주세요");
		location.href = "view.jsp";
	</script>
<%}else if (result == 1){%>
	<script type="text/javascript">
		alert("댓글이 입력되었습니다.");
		location.href = "view.jsp";
	</script>
<%} %>

</body>
</html>