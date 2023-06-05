<%@page import="java.io.PrintWriter"%>
<%@ page import="java.io.File" %>
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
<title>메인창</title>
</head>
<body>
<%
		String userID = null;
		if(session.getAttribute("userID") != null){
			userID = (String) session.getAttribute("userID");
		}
	%>
<header class="p-3 text-bg-dark" style="position:fixed; top:0; width: 100%; z-index: 1;"">
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
	
	 <div class="container">
		<div class="col-lg-4" style="margin: auto;">
			<div class="jumbotron" style="margin-top: 50%;"> 
				<form method="post" action="joinAction.jsp">
					<h3 style="text-align: center;">회원가입 화면</h3>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="아이디"
						name="userID" maxlength="20";>
					</div>
					
					<div class="form-group">
						<input type="password" class="form-control" placeholder="비밀번호"
						name="userPassword" maxlength="20";>
					</div>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="닉네임 설정"
						name="userNicname" maxlength="20";>
					</div>
					<div class="form-group">
						<input type="email" class="form-control" placeholder="이메일"
						name="userEmail" maxlength="20">
					</div>
					
					<input type="submit" class="btn btn-primary form-control" value="회원가입">
				</form>
		</div>
		<div class="col-lg-4"></div>
	</div>
  </div>
					

</body>
</html>