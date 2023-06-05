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

	String postpg = request.getParameter("postpage");
	if (postpg == null) {
		postpg = "1";
	}
	int postpage = Integer.parseInt(postpg);
	//1->0 ; 2-> 10
	int index_no = (postpage - 1) * 10;

	//DB연결, post테이블정보 담은 리스트
	int loginStudentNum = 1001; // 임의의 값 나중에 로그인 한 studentNum으로 바꿔주기
	Dao dao = Dao.getInstance();
	List<Post> postList = dao.selectPostID(loginStudentNum, index_no);

	//내가 작성한 총 게시물 개수
	int totalPost = dao.countPostID(loginStudentNum);
	//
	int lastPostpage = (int) Math.ceil((double) totalPost / 10);
	%>
	


		
					<ul>
						<%
						for (Post post : postList) {
						%>
						<li>
							<article>
								<div id="profile">
									<img src="image/blankProfile.jpg" alt="프로필사진">
									<div id="ano">익명</div>
									<div id="date"><%=post.getDate()%></div>
								</div>
								<h1><%=post.getTitle()%></h1>
								<p><%=post.getContent()%></p>
								<div id="like-comment">
									<span id="like"> <img src="image/icon_like.png"
										alt="좋아요 수"> <%=post.getLikeCount()%>
									</span> <span id="comment"> <img src="image/icon_comment.png"
										alt="댓글 수"> <%=post.getCommentCount()%>
									</span>
								</div>
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
		for (int i = 1; i <= lastPostpage; i++) {
			//out.print("<a href='anolist2.jsp?postpage= "+i+"'>"+i+"</a> ");
			//위에처럼 해도 되고 아래처럼 해도 된다 - postpage 값 전달 되도록
		%>
		<a href="myPost.jsp?postpage=<%=i%>"><%=i%></a>
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