<%@page buffer = "1kb" %>
<%@page import="java.io.File"%>
<%@page import="user.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8"); //한글깨짐 방지
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%--부트스트랩 cdn --%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">

<!-- 글목록css -->
<style>
body{
	padding-top:87px;
	 
}

a {
	color: black;
	text-decoration: none;
}

#wrapper {
	border: 1px solid rgb(243, 242, 242);
	max-width: 800px; /*800이하 시 줄어듦*/
	height: 100%;
	margin: 0 auto;
	padding: 0 auto;
}

#userInfo {
	/*border: 1px solid blue;*/
	max-width: 800px;
	background-color: rgb(243, 242, 242);
	padding: 20px;
	height: 300px;
	
}

#img{
	width: 150px;
	height: 150px;
	margin: 10px auto;
	display: block;
	object-fit: cover; /*이미지의 종횡비를 유지하면서 박스를가득채움.*/
}

#userInfo div {
	margin: 5px auto;
	text-align: center;
}

#userInfo div a {
	text-decoration-line: none;
}

#userID a {
	color: black;
	font-weight: bold;
	
}
#nickName a, #studentNum a {
	color: grey;
}

/*여기서부터 안건듦*/
#content {
	border: 2px solid #bddbd2;
	max-width: 800px;
	padding: 0;
	padding:0 auto;
	
	
}
#myPageList {
	display: flex;
	margin: 0 auto;
	
}
#myPageList div{
	display: inline-block;
	width: 35%;
	text-align: center;
}
#myPageList button{
	width: 100%;
	/*border: 1px solid #333;*/
	border: 1px solid #bddbd2;
	
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

#content a {
	color: black;
	text-decoration: none;
}

#profile {
	/* border: 1px solid black; */
	height: 25px;
	margin: 3px 0;
	/*position: relative;*/
	display: flex;
}

#profile img {
	width: 25px;
	height: 25px;
}

#profile #ano {
	/* border: 1px solid blue; */
	/*position: absolute;
	margin: 0;
	padding: 0;
	display: inline-block;*/
	margin-left: 5px;
	height: 25px;
	line-height: 25px;
}

#profile #date {
	/* border: 1px solid blue; */
	/*position: absolute;
	margin: 0;
	padding: 0;
	display: inline-block;*/
	margin-left: 10px;
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

<body>
<%
	String userID = null;
	int studentNum = 0;
	if(session.getAttribute("userID") != null){
	userID = (String) session.getAttribute("userID");
	studentNum = (int) session.getAttribute("studentNum");
	}
	
	System.out.println("학생 :" + userID);
	if(userID == null || userID == ""){%>
		<script type="text/javascript">
			alert("로그인 해주세요.");
			location.href = 'login.jsp';
		</script>
	<%}%>
	<% 
	Dao dao = Dao.getInstance();
	
//임의로 studentNum 정함.
	User user = dao.selectUserOne(studentNum);
	
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
						<img src="image/blankProfile.jpg" alt="프로필사진" style="border-radius:20px" width="40px" height="40px">
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
	
	
	
	<div id="wrapper">
	<form  action="profimgAction.jsp" method="post" enctype="multipart/form-data" name="imgform">
		<div id="userInfo">
		<%
		//프로필 사진(경로에 사진 없으면 기본이미지)
			ServletContext context = this.getServletContext(); //절대경로를 얻는다.
            String realFolder = context.getRealPath("image"); //image폴더의 절대경로를 받는다.
            
			File viewImg = new File(realFolder+"\\"+studentNum+"프로필사진.jpg");
			if(viewImg.exists()){
		%>
			<img id="img" src="image/<%=studentNum %>프로필사진.jpg" alt="프로필사진" onclick="clickBtn()" class="rounded">
			<%} else { %>
				<img id="img" src="image/blankProfile.jpg" alt="프로필사진" onclick="clickBtn()" class="rounded">
			<%} %>
			<input type="file" name="fileName" id="profimg" style="display: none;" onchange="changeValue(this)" />
			
		
		<%--아이디, 닉네임, 학번 --%>
			<div id="userID">
				<a href="myinfoUpdate.jsp?studentNum=<%=user.getStudentNum() %>" 
				onclick="window.open(this.href,'_blank', 'width=600,height=300,left=500,top=300,toolbars=no,scrollbars=no'); return false;" >
				<%=user.getUserID() %></a>
			</div>
			<div id="nickName">
				<a href="myinfoUpdate.jsp?studentNum=<%=user.getStudentNum() %>" 
				onclick="window.open(this.href,'_blank', 'width=600,height=300,left=500,top=300,toolbars=no,scrollbars=no'); return false;">
				닉네임: <%=user.getNickName() %></a>
			</div>
			<div id="studentNum">
				<a href="myinfoUpdate.jsp?studentNum=<%=user.getStudentNum() %>" 
				onclick="window.open(this.href,'_blank', 'width=600,height=300,left=500,top=300,toolbars=no,scrollbars=no'); return false;">
				학번: <%=user.getStudentNum() %></a>
			</div>
		</div>
	</form>
	
	
		<section id="content">
			
			<div id="myPageList" class="btn-group" role="group" aria-label="Basic radio toggle button group">
				<div>
					<button id="exePost" class="bg-success p-2 text-dark bg-opacity-25">내가 쓴 글</button>
				</div>
				<div>
					<button id="exeComment" class="bg-success p-2 text-dark bg-opacity-25">댓글 단 글</button>
				</div>
				<div>
					<button id="exeLike" class="bg-success p-2 text-dark bg-opacity-25">좋아요 한 글</button>
				</div>
			</div>
			<div id="showList"></div>

		</section>
	</div>


	<script src="https://code.jquery.com/jquery-3.0.0.min.js"></script>
	
	<%--프로필사진 클릭 이벤트 --%>
	<script>
		function clickBtn() {
			$('#profimg').click();
		}
		
		/* $("#img").click(function(e){
			document.imgform.target_url.value = document.getElementById('img').src;
			e.preventDefault(); 
			$("#profimg").click();
		}); */
		
		function changeValue(obj) {
			document.imgform.submit();
		}
	</script>
	
	<%--버튼 클릭 이벤트 --%>
	<script>
	
	 
		$(function() {
			$("#exePost").click(function() {
				$.ajax({
					url : 'myPost.jsp',
					success : function(x) {
						$('#showList').html(x);
					}
				})
			});
			$("#exeComment").click(function() {
				$.ajax({
					url : 'myComment.jsp',
					success : function(x) {
						$('#showList').html(x);
					}
				})
			});
			$("#exeLike").click(function() {
				$.ajax({
					url : 'myLike.jsp',
					success : function(x) {
						$('#showList').html(x);
					}
				})
			});
		});
	</script>
</body>

</html>