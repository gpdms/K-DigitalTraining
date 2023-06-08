<%@page import="java.io.File"%>
<%@page import="java.io.Console"%>
<%@page import="user.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 헤더 부트스트랩 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<link rel="stylesheet" href="style.css">






<!-- 글목록css -->
<style>

body{
	padding-top:87px;
	 
}
a {
	color: black;
	text-decoration: none;
}

#content {
padding : 0;
margin-top : 0px;
position: relative
}

.pasingArea{
	text-align:center;
	margin-top:5px;
}


#goToWriteBtn{
	margin-left:410px;
}

.gotowrite{
	position:fixed;
	top: 200px;
	margin-left :55%;
}
</style>

</head>


<body>
	<%
		String userID = null;
		int loginStudentNum = 0;
		if (session.getAttribute("userID") != null) {
			userID = (String) session.getAttribute("userID");
			loginStudentNum = (int) session.getAttribute("studentNum");
		}
		if(session.getAttribute("postNum") != null){
			int postNum = (int)session.getAttribute("postNum");
			session.removeAttribute("postNum");
		}
		//게시판 
		String postBoard = request.getParameter("board");
		System.out.println("ㅎㅎ"+postBoard);
		System.out.println("ㅋㅋ");
		
	%>
	<!-- 헤더 -->
	<header class="p-3 text-bg-dark"
		style="position: fixed; top: 0; width: 100%; z-index: 1; background-color: white !important; border-bottom: 1px solid gray;">
		<div class="container">
			<div class="row">
				<div
					class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
					<a href="/"
						class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none"></a>

					<ul
						class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0"
						style="align-items: center;">
						<li><a href="main.jsp"><img src="image/shelter.png"></a></li>
						<li><a href="anolist.jsp?board=ano"
							class="nav-link px-2 text-secondary" style="letter-spacing:-3px;">익명 게시판</a></li>
						<li><a href="anolist.jsp?board=mustGo"
							class="nav-link px-2 text-secondary" style="letter-spacing:-3px;">맛집 게시판</a></li>
						<li><a href="myPage.jsp"
							class="nav-link px-2 text-secondary fw-semibold" style="letter-spacing:-2px;">My Page</a></li>
					</ul>
					
					
					<form method="post" action="searchedList.jsp"
								class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search"
								id="search">
								<input type="search"
									class="form-control form-control-dark text-bg-white"
									placeholder="검색..." aria-label="Search"
									name="searchWord">
							</form>
					<%
				if(userID == null){
			%>
					<div class="text-end">
						<button type="button" class="btn btn-outline-dark me-2"
							role="button" aria-haspopup="true" aria-expanded="false">
							<a href="login.jsp">로그인</a>
						</button>
						<button type="button" class="btn btn-warning" role="button"
							aria-haspopup="true" aria-expanded="false">
							<a href="join.jsp" id="sign-color">회원 가입</a>
						</button>
					</div>
					<%
				} else {
			%>
					<div class="text-end">
						<button type="button" class="btn btn-warning me-2"
							role="button" aria-haspopup="true" aria-expanded="false">
							<a href="logoutAction.jsp">LogOut</a>
						</button>
						<a href="myPage.jsp">
						<%
						int studentNum = (int) session.getAttribute("studentNum");
						//프로필 사진(경로에 사진 없으면 기본이미지)
						ServletContext context = this.getServletContext(); //절대경로를 얻는다.
			            String realFolder = context.getRealPath("image"); //image폴더의 절대경로를 받는다.
			            
						File viewImg = new File(realFolder+"/"+studentNum+"프로필사진.jpg");
						if(viewImg.exists()){
						%>
						<img src="image/<%=studentNum %>프로필사진.jpg" alt="프로필사진" style="border-radius:20px" width="40px" height="40px">
						<%} else { %>
						<img id="img" src="image/blankProfile.jpg" alt="프로필사진" style="border-radius:20px" width="40px" height="40px">
						<%} %>
						
						
						</a>
					</div>
					<%		
				}
			%>

				</div>
			</div>
		</div>
	</header>






	<!-- 글목록 부분 -->
	<%
		//페이지 누르면 값 가져오기

		String postpg = request.getParameter("postpage");
	    //String postbo = request.getParameter("board");
	    //System.out.println("안ㄴ"+postpg+postbo);
		if (postpg == null) {
			postpg = "1";
		}
		int postpage = Integer.parseInt(postpg);
		//1->0 ; 2-> 10
		int index_no = (postpage - 1) * 10;

		//DB연결, post테이블정보 담은 리스트
		Dao dao = Dao.getInstance();
		List<Post> postlist = null;
		int totalPost = 0;
		int lastPostpage = 0;
		String board = null;
		if(postBoard.equals("ano")){
			postlist = dao.selectPostAll(index_no);
			board = "익명게시판";
			//총 게시물 개수
			totalPost = dao.countPostAll(board);
			lastPostpage = (int) Math.ceil((double) totalPost / 10);
		}else if (postBoard.equals("mustGo")){
			postlist = dao.selectFoodPostAll(index_no);
			board = "맛집게시판";
			//총 게시물 개수
			totalPost = dao.countPostAll(board);
			lastPostpage = (int) Math.ceil((double) totalPost / 10);
		}
	%>
	<div class="container-fluid" id="wrapper2">
	<div id="wrapper">
		<section id="content" style="background-color:white">
		<!-- 게시판 구분 표시 -->
		<%  if(postBoard.equals("ano")){%>		
			<h1>익명게시판</h1>
			<%}else if (postBoard.equals("mustGo")){%>
			<h1>맛집게시판</h1>
		<%} %>
			<ul>
				<%
					for (int i = 0; i<postlist.size(); i++) {
						Post p = postlist.get(i);
						int studentNum = p.getStudentNum();
						
				%>
				<li>
					<article>
						<div id="profile">
					<%-------------익명게시판 프로필--------------- --%>
						<%
						if(postBoard.equals("ano")){%>
						
							<img src="image/blankProfile.jpg" alt="프로필사진">
							<div id="ano">익명</div>
					<%-------------맛집게시판 프로필--------------- --%>
						<%}else if (postBoard.equals("mustGo")){
								//프로필 사진(경로에 사진 없으면 기본이미지)
								ServletContext context = this.getServletContext(); //절대경로를 얻는다.
					            String realFolder = context.getRealPath("image"); //image폴더의 절대경로를 받는다.
								File viewImg = new File(realFolder+"\\"+studentNum+"프로필사진.jpg");
					            
								if(viewImg.exists()){ %> 
									<img id="img" src="image/<%=studentNum %>프로필사진.jpg" alt="프로필사진">
								<%} else { %>
									<img src="image/blankProfile.jpg" alt="프로필사진">
									<%}
								//닉네임 불러오기
									User user = dao.selectUserOne(studentNum);
									String nickName = user.getNickName();
									System.out.println("닉네임:"+nickName);
									%>
							<div id="ano"><%=nickName %></div>
							<%} %>
						
							
							<div id="date"><%=p.getDate()%></div>
						</div>
						
						<h1>
							<a href="view.jsp?postNum=<%=p.getPostNum()%>&board=<%=postBoard%>" style="letter-spacing:-2px;">
								<%=p.getTitle()%></a>
						</h1>
						<p>
							<a href="view.jsp?postNum=<%=postlist.get(i).getPostNum()%>&board=<%=postBoard%>" style="letter-spacing:-2px;">
								<%=p.getContent()%></a>
						</p>
						<div id="like-comment">
							<span id="like"> <%
 	int likeOnOff = dao.LikeOnOff(postlist.get(i).getPostNum(), loginStudentNum);
 		int countLike = dao.countLikePost(postlist.get(i).getPostNum());
 		int countComment = dao.countCommentPost(postlist.get(i).getPostNum());

 		if (likeOnOff == 0) {
 %> <img src="image/OFF.png" alt="좋아요 수">
								<%=countLike%> <%
 	} else {
 %> <img src="image/ON.png" alt="좋아요 수">
								<%=countLike%> <%
 	}
 %>
							</span> <span id="comment"> <img src="image/icon_comment.png"
								alt="댓글 수"> <%=countComment%>
							</span>
						</div>
					</article>
				</li>
				<%
					}
				%>

			</ul>
		</section>
	</div>
	<!-- 페이징 -->
		<div class ="pasingArea">
			<div class = "pasingBox">
				<%
				if(totalPost > 0){
					int pageCount = totalPost/ 10 +(totalPost % 10 == 0? 0:1);
					int startPage = 1;
					if(postpage % 5 != 0){
						startPage = (int)(postpage/5)*5+1;
					}else{
						startPage = ((int)(postpage/5)-1)*5+1;
					}
					int pageBlock = 5;
					int endPage = startPage + pageBlock - 1;
					if(endPage > pageCount) endPage = pageCount;
					
					// 이전이라는 링크 만들건지 
					if(startPage > 5){ %>
						<button ><a href="anolist.jsp?board=<%=postBoard%>&postpage=<%=startPage-5%>">이전</a></button>
					<%}
					//페이징
					int ii;
					for( ii = startPage; ii<= endPage; ii++){
						//  현재 페이지 색  #7497d1 #7286D3 #d5e3f9
						if(ii == postpage){%>
							<button style="background-color:#efe2ae; "><a href="anolist.jsp?board=<%=postBoard%>&postpage=<%=ii%>"><%=ii %></a></button>
						<%}else{
					%> 	
						<button ><a href="anolist.jsp?board=<%=postBoard%>&postpage=<%=ii%>"><%=ii %></a></button>
					<%}
					}
					// 다음이라는 링크 만들건지 
					if(endPage < pageCount){%>
						<button><a href="anolist.jsp?board=<%=postBoard%>&postpage=<%=startPage+5%>">다음</a></button>
					<%}
				}
				%>
			</div>
		</div>	
	
	</div>
	<div class="gotowrite">
		<% if(session.getAttribute("userID") != null){%>
	<a href="write.jsp?board=<%=postBoard %>" id="goToWriteBtn" class="btn btn-success" style="width: 100px; letter-spacing:-2px; font-size:20px; font-weight:bold">글쓰기</a>
	<%} %>
	</div>		
	</div>
	
	<div class="container">
		<footer class="py-2 my-3">
			<ul class="nav justify-content-center border-bottom pb-2 mb-2"
				style="align-items: center;">
				<li><a href="main.jsp"><img src="image/shelter.png"></a></li>
				<li><a href="anolist.jsp?board=ano"
							class="nav-link px-2 text-secondary"
							style="letter-spacing: -3px;">익명 게시판</a></li>
						<li><a href="anolist.jsp?board=mustGo"
							class="nav-link px-2 text-secondary"
							style="letter-spacing: -3px;">맛집 게시판</a></li>
						<li><a href="myPage.jsp"
							class="nav-link px-2 text-secondary fw-semibold"
							style="letter-spacing: -2px;">My Page</a></li>
			</ul>
			<p class="text-center text-muted">&copy; 2023 Choongang, Inc</p>
		</footer>
	</div>
	
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script>

	
	</script>
</body>

</html>