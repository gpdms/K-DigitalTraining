<%@page import="user.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>


<body>




	<!-- 글목록 부분 -->
	<%
	//페이지 누르면 값 가져오기

	String commentpg = request.getParameter("commentpage");
	if (commentpg == null) {
		commentpg = "1";
	}
	int commentpage = Integer.parseInt(commentpg);
	//1->0 ; 2-> 10
	int index_no = (commentpage - 1) * 10;

	//DB연결, comment테이블정보 담은 리스트
	Dao dao = Dao.getInstance();
	int loginStudentNum = 1001; // 임의의 값 나중에 로그인 한 studentNum으로 바꿔주기
	List<Comment> commentList = dao.selectCommentID(loginStudentNum, index_no);

	//내가 작성한 총 댓글 개수
	int totalComment = dao.countCommentID(loginStudentNum);
	//
	int lastCommentpage = (int) Math.ceil((double) totalComment / 10);
	%>
	


		
					<ul>
						<%
						for (Comment comment : commentList) {
						%>
						<li>
							<article>
								<div id="profile">
									<img src="image/blankProfile.jpg" alt="프로필사진">
									
									<div id="date"><%=comment.getDate()%></div>
								</div>
								<h1><%="글제목"+comment.getTitle() %></h1>
								<p><%="댓글내용"+comment.getCommentContent()%></p>
								
							</article>
						</li>
						<%
						}
						%>

					</ul>
			

	<!-- 페이징 -->
	<div style="width: 600px; text-align: center; margin-top: 10px;">
		<%
		//페이징
		for (int i = 1; i <= lastCommentpage; i++) {
			//out.print("<a href='anolist2.jsp?commentpage= "+i+"'>"+i+"</a> ");
			//위에처럼 해도 되고 아래처럼 해도 된다 - commentpage 값 전달 되도록
		%>
		<a href="myComent.jsp?commentpage=<%=i%>"><%=i%></a>
		<%
		}
		%>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script>
		
	</script>
</body>

</html>