<%@page import="java.io.PrintWriter"%>
<%@ page import="java.io.File"%>
<%@page import="user.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./style.css" type="text/css">
<meta name="viewport" content="width=device-width" initail-scale="1">
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<!-- 글목록css -->
<style>
a {
	color: white;
	text-decoration: none;
}

#centerLine2 {
	height: 100px;
}

#wrapper {
	border: 1px solid #333;
	max-width: 800px; /*800이하 시 줄어듦*/
	height: 100%;
	margin: 0 auto;
	padding: 0 auto;
}

#content {
	/*border: 1px solid red;*/
	max-width: 800px;
	padding-top: 20px;
	padding-bottom: 20px;
	margin-top: 100px;
}

#content ul {
	list-style: none;
	margin: 0;
	padding: 0;
}

#content li {
	/* border: 1px solid red; */
	margin-top: 10px;
	padding: 5px;
	background-color: rgb(243, 242, 242);
	overflow: hidden;
}

#content article {
	height: 100px;
}

#profile {
	/* border: 1px solid black; */
	height: 25px;
	margin: 3px 0;
	position: relative;
}

#profile img {
	width: 25px;
	height: 25px;
}

#profile #ano {
	/* border: 1px solid blue; */
	position: absolute;
	margin: 0;
	margin-left: 5px;
	padding: 0;
	display: inline-block;
	height: 25px;
	line-height: 25px;
}

#profile #date {
	/* border: 1px solid blue; */
	position: absolute;
	margin: 0;
	margin-left: 50px;
	padding: 0;
	display: inline-block;
	height: 25px;
	line-height: 25px;
	color: grey;
}

#content h1 {
	/* border: 1px solid blue; */
	font-size: 25px;
	margin-top: 10px;
	margin-bottom: 0px;
	padding: 0;
	display: block;
	max-width: 800px;
	white-space: nowrap; /*여러줄을 한줄로*/
	overflow: hidden; /*넘치는 글 숨김*/
	text-overflow: ellipsis; /*...*/
}

#content p {
	/* border: 1px solid black; */
	font-size: 15px;
	margin: 0;
	/*padding-top: 10px;
padding-bottom: 10px;*/
	padding: 0;
	height: 25px;
	display: block;
	max-width: 800px;
	white-space: nowrap; /*여러줄을 한줄로*/
	overflow: hidden; /*넘치는 글 숨김*/
	text-overflow: ellipsis; /*...*/
}

#like-comment {
	float: right; /*오른쪽 정렬*/
	font-size: 15px;
	height: 15px;
	margin: 3px;
}

#like-comment img {
	width: 15px;
	height: 15px;
}

#like {
	color: #FF0000;
}

#comment {
	color: #0055FF;
}
</style>

</head>
<title>메인창</title>
</head>
<body>
	<%
		String userID = null;
		int studentNum = 0;
		if (session.getAttribute("userID") != null) {
			userID = (String) session.getAttribute("userID");
			studentNum = (int) session.getAttribute("studentNum");
		}
		if (userID == null){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('로그인을 하세요')");
			script.println("location.href = 'login.jsp'");
			script.println("</script>");
		}
		int postNum = 0;
		if(request.getParameter("postNum") != null){
			postNum = Integer.parseInt(request.getParameter("postNum"));
		}
		if (postNum == 0){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('유효하지 않은 글입니다')");
			script.println("location.href = 'anolist.jsp'");
			script.println("</script>");
		}
		
		Post post = new Post();
		Dao dao = Dao.getInstance();
		post = dao.getPost(postNum);
		
		
		if(studentNum != post.getStudentNum()){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('권한이 존재하지 않습니다')");
			script.println("location.href = 'anolist.jsp'");
			script.println("</script>");
		}
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
						<li><a href="#" class="nav-link px-2 text-secondary" style="letter-spacing:-3px;">인기글</a></li>
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




	<div class="container">
		<div class="row">
			<main style="margin-top: 90px">
			<div class="container">
				<div class="row">
					<form method="post"
						action="updateAction.jsp?postNum=<%=postNum%>" id="ActionBtn">
						<table class="table table-striped"
							style="text-align: center border:1px solid #dddddd">
							<thead>
								<tr>
									<th colspan="2"
										style="background-color: #eeeeee; text-align: center;">게시판
										글쓰기 양식</th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<td style="text-align: center"><input type="text"
										class="form-control" placeholder="글 제목" name="bbsTitle"
										maxlength="50" value="<%= post.getTitle() %>"></td>
								</tr>
								<tr>
									<td style="text-align: center"><textarea
											class="form-control" placeholder="글 내용" name="bbsContent"
											maxlength="2048" style="height: 350px;" value="<%= post.getContent() %>">
											<%=post.getContent() %></textarea></td>
								</tr>
							
							</tbody>
						</table>
						<input type="submit" value="글쓰기" onclick="clickBtn()"
							class="btn btn-success offset-10" style="width: 75px;">
					</form>
				</div>
			</div>
			</main>
		</div>
	</div>


	<script src="https://code.jquery.com/jquery-3.6.3.js"
		integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM="
		crossorigin="anonymous"></script>
	<script>
		function clickBtn(){
			$('#actionBtn').submit();
		}
	</script>
</body>
</html>