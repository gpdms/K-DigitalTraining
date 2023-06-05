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
	




	
	
<!-- 글목록css -->
<style>

#wrapper {
/*border: 1px solid #333;*/
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

#content ul{
list-style: none;
margin: 0;
padding: 0;
}
#content li{
/* border: 1px solid red; */
margin-top: 10px;
padding: 5px;
background-color: rgb(243, 242, 242);
overflow: hidden;
}
#content article{
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
#content h1{
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
#content p{
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
		if(session.getAttribute("userID") != null){
			userID = (String) session.getAttribute("userID");
		}
	%>
<!-- 헤더 -->
<header class="p-3 text-bg-dark" style="position:fixed; top:0; width: 100%; z-index: 1;">
		<div class="container-fluid">
			<div class="row">
				<div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
					<a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none"></a>

					<ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
						<li><a href="#" class="nav-link px-2 text-secondary">Home</a></li>
						<li><a href="#" class="nav-link px-2 text-white">카테고리</a></li>
						<li><a href="anolist.jsp" class="nav-link px-2 text-white">게시판</a></li>
						<li><a href="#" class="nav-link px-2 text-white">1:1 채팅</a></li>
						<li><a href="#" class="nav-link px-2 text-white">About</a></li>
					</ul>

					<form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
						<input type="search"
							class="form-control form-control-dark text-bg-dark"
							placeholder="Search..." aria-label="Search">
					</form>

<%-- 로그인하지않았을때 login버튼, 로그인했을때 logout버튼. --%>

					<%
				if(userID == null){
			%>
					<div class="text-end">
						<button type="button" class="btn btn-outline-light me-2"
							role="button" aria-haspopup="true" aria-expanded="false">
							<a href="login.jsp">Login</a>
						</button>
						<button type="button" class="btn btn-warning" role="button"
							aria-haspopup="true" aria-expanded="false">
							<a href="join.jsp" id="sign-color">Sign-up</a>
						</button>
					</div>
					<%
				} else {
			%>
					<div class="text-end">
						<button type="button" class="btn btn-outline-light me-2"
							role="button" aria-haspopup="true" aria-expanded="false">
							<a href="logoutAction.jsp">LogOut</a>
						</button>

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
	if(postpg == null) {
		postpg = "1";
	}
	int postpage = Integer.parseInt(postpg);
	//1->0 ; 2-> 10
	int index_no = (postpage-1)*10;
	
	
	
	//DB연결, post테이블정보 담은 리스트
	Dao dao = Dao.getInstance();
	int loginStudentNum = 1001; // 임의의 값 나중에 로그인 한 studentNum으로 바꿔주기
	List<Post> postlist = dao.selectPostAll(index_no);
	
	
	
	
	//총 게시물 개수
	int totalPost = dao.countPostAll();
	//
	int lastPostpage = (int)Math.ceil((double)totalPost/10);
	
%>
   <div id="wrapper">
       <section id="content">
           <ul>
           <%
           		for(Post post : postlist){
           %>
               <li>
                   <article>
                       <div id="profile">     
                           <img src="image/blankProfile.jpg" alt="프로필사진">
                           <div id="ano">익명</div>
                           <div id="date"><%=post.getDate() %></div>
                       </div>
                       <h1><%=post.getTitle() %></h1>
                       <p><%=post.getContent() %></p>
                       <div id="like-comment">
                           <span id="like">
                           <%
                           int likeOnOff = dao.LikeOnOff(post.getPostNum(),loginStudentNum);
                           if	(likeOnOff == 0){
                           %>
                               <img src="image/icon_like.png" alt="좋아요 수"> <%=post.getLikeCount()%>  
                        	<%
                           }else{
                        	 %>
                               <img src="image/icon_likeFull.png" alt="좋아요 수"> <%=post.getLikeCount()%>  
                        	<%
                           }
                           %>
                           </span>
                           <span id="comment">
                               <img src="image/icon_comment.png" alt="댓글 수"> <%=post.getCommentCount()%>
                           </span>
                       </div>
                   </article>
               </li>
               <%} %>
               
           </ul>
       </section>
   </div>
   
<!-- 페이징 -->
	<div style="width:600px; text-align:center; margin-top:10px;">
	<%
       	//페이징
       		for(int i=1; i<=lastPostpage; i++){
       			//out.print("<a href='anolist2.jsp?postpage= "+i+"'>"+i+"</a> ");
       			//위에처럼 해도 되고 아래처럼 해도 된다 - postpage 값 전달 되도록
       		%>
       			<a href="anolist.jsp?postpage=<%=i%>"><%=i %></a>
       		<%
       		}
       	%>	
	</div>  
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script>
	
	</script>
</body>

</html>