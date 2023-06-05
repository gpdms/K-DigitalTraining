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
a {
	color: black;
	text-decoration: none;
}
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
<header class="p-3 text-bg-dark" style="position:fixed; top:0; width: 100%; z-index: 1; background: #99CC99;">
		<div class="container-fluid">
			<div class="row">
				<div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
					<a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none"></a>

					<ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
						<li><a href="#" class="nav-link px-2 text-secondary">Home</a></li>
						<li><a href="#" class="nav-link px-2 text-white">카테고리</a></li>
						<li><a href="anolist.jsp" class="nav-link px-2 text-white">게시판</a></li>
						<li><a href="#" class="nav-link px-2 text-white">1:1 채팅</a></li>
						<li><a href="#" class="nav-link px-2 text-white">My Page</a></li>
						<li><%if(userID != null){%>
	                    <a href="write.jsp" class="btn btn-success offset-10" style="width: 75px; margin-right: 100px">
	                    	글쓰기</a>
						<% }%></li>
					</ul>
<%--검색 --%>
					<form method="post" action="searchedList.jsp" class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
						<input type="search"
							class="form-control form-control-dark text-bg-dark"
							placeholder="Search..." aria-label="Search" name="searchWord">
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
	
	
	
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script>
	
	</script>
</body>

</html>