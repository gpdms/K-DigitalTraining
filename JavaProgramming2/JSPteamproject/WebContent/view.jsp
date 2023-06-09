<%@page import="java.util.ArrayList"%>
<%@page import="java.io.PrintWriter"%>
<%@ page import="java.io.File"%>
<%@page import ="user.*" %>
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

/**************댓글관련 CSS**************/
a {
	color: black;
	text-decoration: none; 
}

#sign-color {
	color: black;
}

#commentarea {
	
	margin : 80px auto 30px auto;
	width: 800px;
	height: 30%;
	
	
}


#showComment {
	max-width: 800px;
	padding-top: 0;
	padding-bottom: 0;
	margin : 0 auto 10px auto;
	background-color: lightgray;
	transition: 0.3s;
}

/* 전체 댓글 부분이 담길 케이스 */
#commentCase {
	padding: 5px;
	background-color: rgb(243, 242, 242);
	overflow: hidden;
	transition: 0.3s;
}


#writecomment {
	margin-left: 60px;
	cursor: pointer;
}

#commentDiv {
	max-width: 800px;
	padding-top: 10px;
	padding-bottom: 10px;
	margin-top: 10px;
	margin-left: 0;
	background-color: rgb(243, 242, 242);

}

#saveComment{
	display: inline-block;
}

/* 댓글 수정할 직접적인 textarea  */
.updateCommentTextArea {
	width: 85%;
	height: 20%;
}

/* updateComment버튼을 누르면 나오는 댓글을 수정 할 영역 */
.updateCommentarea {
	display: none;
}

.active .updateCommentarea {
	display: block;
}

label {
	color: #2e7903;
	cursor: pointer;
}

/*댓글들 li를 담을 ul  */
.commentUnorderdList {
	list-style: none;
	margin: 0;
	padding: 0;
}

li {
	list-style: none;
	margin: 0;
	padding: 0;
}
.a{
	float :right;
}

.updateComment{
	cursor : pointer;
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
		
		int postNum = 0;
		if(request.getParameter("postNum") != null){
			postNum = Integer.parseInt(request.getParameter("postNum"));
			System.out.println("게시판 번호는 :" + postNum);
			session.setAttribute("postNum", Integer.parseInt(request.getParameter("postNum")));
			postNum = (int)session.getAttribute("postNum");
			
		}
		String postBoard = request.getParameter("board");
		postNum = (int)session.getAttribute("postNum");
		Post post = new Post();
		Dao dao = Dao.getInstance();
		post = dao.getPost(postNum);
		
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
						<button type="button" class="btn btn-outline-light me-2"
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
				 <div id="wrapper">
      			 <section id="content">
           <ul>
               <li style="margin:10px">
                   <article>
                       <div id="profile">
                          <%-------------익명게시판 프로필--------------- --%>      
                       <%
                       //글쓴이 학번 가져오기
                       int stNum = post.getStudentNum();
                       
                       if(post.getBoard().equals("익명게시판")){%>
						
							<img src="image/blankProfile.jpg" alt="프로필사진">
							<div id="ano">익명</div>
					<%-------------맛집게시판 프로필--------------- --%>
						<%}else if (post.getBoard().equals("맛집게시판")){
							//프로필 사진(경로에 사진 없으면 기본이미지)
							ServletContext context = this.getServletContext(); //절대경로를 얻는다.
				            String realFolder = context.getRealPath("image"); //image폴더의 절대경로를 받는다.
							File viewImg = new File(realFolder+"\\"+stNum+"프로필사진.jpg");
				            
							if(viewImg.exists()){%>
								<img src="image/<%=stNum %>프로필사진.jpg" alt="프로필사진">
							<%} else { %>	
							<img src="image/blankProfile.jpg" alt="프로필사진">
							<%}
							//닉네임 불러오기
								User user = dao.selectUserOne(stNum);
								String nickName = user.getNickName();
								System.out.println("닉네임:"+nickName);
								%>
							<div id="ano"><%=nickName %></div>
						<%}%>
						
                           <div id="date"><%=post.getDate()%></div>
                       </div>
                       <h1 style="letter-spacing:-2px;"><%=post.getTitle() %></h1>
                       <%
                       ServletContext context = this.getServletContext(); //절대경로를 얻는다.
               		   String realFolder = context.getRealPath("bbsUpload"); //saveFolder의 절대경로를 받는다.
                       
                       File oldFile = new File(realFolder+"\\"+"0사진.jpg");
                       File viewFile = new File(realFolder+"\\"+postNum+"사진.jpg");
                       oldFile.renameTo(viewFile);
                       System.out.println(viewFile);
                       
                        if(viewFile.exists()){
                    	%>
                    	<br>
                       <img src="bbsUpload\\<%=postNum%>사진.jpg" width="600px" height="600px">
                       <%}
                        
                        String content = post.getContent().replaceAll("\n", "<br/>");
                        %>
                       <h2 style="font-size: 15px; letter-spacing:-2px;"><%=content%></h2>
                      	
                       <div id="like-comment">
                           <span id="like">
                                <%
	                           		int countLike = dao.countLikePost(postNum);
									int countComment = dao.countCommentPost(postNum);
									int likeOnOff = dao.LikeOnOff(postNum, studentNum);
                           			if(userID != null) {
                           		%>
		                            <button value=<%=postNum%> id="like_btn">
	                                <%
		                				
										if (likeOnOff == 0) {
		                            %>
	                               <img src="image/OFF.png" alt="좋아요 수" id="like_img">
		                        	<%
		                           		 } else {
		                        	 %>
	                               <img src="image/ON.png" alt="좋아요 수" id="like_img">
		                        	<%
		                          		 };
		                           %>
	                               </button> 
		                       <%
                           			} else {
		                       %>
		                       		<button id="like_btn" disabled>
		                       			<img src="image/OFF.png" alt="좋아요 수" id="like_img">
		                       		</button> 
		                       <%
                           			};
		                       %>
	                           <span id="likecount" value=""><%=countLike%></span>
                           </span>
                           <span id="comment">
                               <img src="image/icon_comment.png" alt="댓글 수"> <%=countComment %>
                           </span>
                       </div>
                   </article>
               </li>
           </ul>
       </section>
     		<a href="main.jsp" class="btn btn-success" style="width: 75px; margin: 15px;">목록</a>
			<%
				if (studentNum != 0 && studentNum == post.getStudentNum()) {
			%>
			<a href="update.jsp?postNum=<%=postNum%>"
				class="btn btn-primary offset-7" style="width: 75px;">수정</a> <a
				onclick="return confirm('정말로 삭제하시겠습니까?')"
				href="deleteAction.jsp?postNum=<%=postNum%>&board=<%=postBoard%>" class="btn btn-primary"
				style="width: 75px; margin-left: 15px;">삭제</a>
			<%
			}
			%>
   			</div>
		
		</div>
		
					<!------------------------------------댓글 다는 창------------------------------------------>
		<div id="commentarea">
		<form action=""></form>
		<!--id="writeCommentForm  -->
			<form action="commentAction.jsp" method="post">
				<input type="hidden" name="studentNum" value="<%=studentNum%>" />
				<input type="hidden" name="postNum" value="<%=postNum%>" />
				<%-- <input type="hidden" name="title" value="<%=title%>" /> --%>
				<input type="hidden" name="content" value="<%=content%>" />
				<%
					if(userID != null) {
				%>
				
				<textarea name="commentcontent" class="writeCommentArea"
					style="width: 100%; height: 100%; border-color: black;"
					class="form-control" placeholder="댓글을 입력하세요"></textarea>
				<input type="submit" value="댓글저장" id="saveComment" style="margin-left:720px;">
				
				<%
					} 
				%>	
				
			</form>
		</div>
	</div>
		
		
		<!---------------------------------- 댓글보는 창 ------------------------------------>
	<!-- 	<button id="showCommentbtn">댓글보기</button> -->
		<div id="showComment" >
			<div id="commentCase">
				<ul class = "commentUnorderdList">
					
				<%
					ArrayList<Comment> commentlist = dao.SelectCommentCommentNum(postNum);
					for (int i = 0; i < commentlist.size(); i++) {
		 				System.out.println(commentlist.get(i).getCommentContent());
					
				%>
					<li>				
				<div id="commentDiv">
					<!--------------------------- 댓글 수정을 위한 폼테그 --------------------------->
					<!-- action="updateComment.jsp" <iframe id="iframe2" name="iframe2" style="display:none"></iframe> -->
					<form action=""></form>
					<form action="updateComment.jsp" method="post" class = "updateCommentFormArea">
						<div id="commentNumber">
							<input type="hidden" name="commentNum"
								value="<%=commentlist.get(i).getCommentNum()%>"> date :
							<%=commentlist.get(i).getDate()%>
						</div>

						<!---------------------------------- 실제 나오는 댓글 ------------------------------->
						
						<%=commentlist.get(i).getCommentContent().trim()%>
						<%
							//본인이 단 댓글만  수정하기 버튼이 나올 수 있도록 한 조건문
								if (studentNum == commentlist.get(i).getStudentNum()) {
						%>

						<label class="updateComment">수정</label>
						<div class="updateCommentarea">
							<textarea class="updateCommentTextArea"
								name="updateCommentTextArea"><%=commentlist.get(i).getCommentContent().trim()%></textarea>
							<input type="submit" value="저장" id="updateCommentbtn">
						</div>
					</form>




					<!----------------------------- 댓글 삭제 하는 액션 폼 -------------------------------------->
					<!-- action = "deleteComment.jsp" -->
					<form action=""></form>
					<form action = "deleteComment.jsp" method="post">
						<input type="submit" value="삭제" />
						<input type="hidden" name="commentNum" value="<%=commentlist.get(i).getCommentNum()%>">
						<input type="hidden" name="commentContent" value="<%=commentlist.get(i).getCommentContent()%>">
					</form>
				</div>

				<%
					}
				%>
				</li>
			<%
				}
			%>
			</div><!--comment div-->
				</ul>
		</div><!--showcomment끝  -->
		
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
		$("#like_btn").click(function() {
			var img = document.getElementById('like_img');
			var likecount = document.getElementById('likecount').innerText;
			
			if (img.src.match('OFF')) {
				img.src = 'image/ON.png';
				
				fetch("likeBtn.jsp?postNum="+$(this).val())
				  .then(a => {document.getElementById('likecount').innerText = ++likecount;});
				
			} else {
				img.src = 'image/OFF.png';
				
				fetch("likeBtn.jsp?postNum="+$(this).val())
				  .then(b => {document.getElementById('likecount').innerText = --likecount;});
			}
		});
		
		
		/***********************댓글 저장, 수정, 삭제 등 데이터를 보낼 js/
		/* 새로운 댓글을 달때 정보를 보내는 방법  */
/* let writeCommentForm = document.getElementById('writeCommentForm');
writeCommentForm.addEventListener('submit', function(e){
	e.preventDefault();
	let formData = new FormData(writeCommentForm);
	console.log(FormData);

	fetch('./commentAction.jsp',{
		method:'POST',
		body : new URLSearchParams(formData)
	}).then(data => {
		
			alert("댓글이 저장되었습니다")
			location.reload();
			
	}) 
}) */

	
	
	 /* 여긴 토글 방법으로 수정하기 누르면 껏다 커졌다 반복. */
	 var updateElem = document.querySelector('.updateComment');
     var currentItem;


     function active(elem){
        elem.classList.toggle('active');
        currentItem = elem;
     }

     function inactive(elem){
        elem.classList.remove('active');
     }

	window.addEventListener('click', (e)=>{

        if(e.target.classList.contains('updateComment')){
            active(e.target.parentNode);
        }
    });
	
	
		
		
		
		
	</script>
</body>

</html>