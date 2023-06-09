<%@page import="java.io.File"%>
<%@page import="user.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
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
	int studentNum = 0;
	if(session.getAttribute("userID") != null){
	userID = (String) session.getAttribute("userID");
	studentNum = (int) session.getAttribute("studentNum");
	}
%>

	<!-- 글목록 부분 -->
	<%
	//페이지 누르면 값 가져오기

	String postpg = request.getParameter("postpage");
	if (postpg == null) {
		postpg = "1";
	}
	int postpage = Integer.parseInt(postpg);
	//1->0 ; 2-> 10
	int index_no = (postpage - 1) * 5;

	//DB연결, post테이블정보 담은 리스트
	Dao dao = Dao.getInstance();
	List<Post> postlist = dao.selectLikeID(studentNum, index_no);

	//내가 좋아요한 총 게시물 개수
	int totalPost = dao.countLikeID(studentNum);
	//
	/* int lastPostpage = (int) Math.ceil((double) totalPost / 10); */
	
	
	
	%>
	
<div id="showPage">
	<ul>
           <%
           for (int i = 0; i <= postlist.size() - 1; i++) {
           %>
               <li>
                   <article>
                        <div id="profile">   
                  <%-------------익명게시판 프로필--------------- --%>      
                       <%
                       if(postlist.get(i).getBoard().equals("익명게시판")){%>
						
							<img src="image/blankProfile.jpg" alt="프로필사진">
							<div id="ano">익명</div>
					<%-------------맛집게시판 프로필--------------- --%>
						<%}else if (postlist.get(i).getBoard().equals("맛집게시판")){
							//postNum으로 studentNum 가져오기
							int postNum = postlist.get(i).getPostNum();
							Post p = dao.getPost(postNum);
							int stNum = p.getStudentNum();
							
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
						
						
                           <div id="date"><%=postlist.get(i).getDate() %></div>
                       </div>
                       <h1>
                       <a href="view.jsp?postNum=<%=postlist.get(i).getPostNum()%>&board=mypage">
                       <%=postlist.get(i).getTitle() %></a>
                       </h1>
                       <p>
                       <a href="view.jsp?postNum=<%=postlist.get(i).getPostNum()%>&board=mypage">
                       <%=postlist.get(i).getContent() %></a>
                       </p>
                       <div id="like-comment">
                           <span id="like">
                           <%
                           int likeOnOff = dao.LikeOnOff(postlist.get(i).getPostNum(),studentNum);
                           int countLike = dao.countLikePost(postlist.get(i).getPostNum());
                           int countComment = dao.countCommentPost(postlist.get(i).getPostNum());
                           
                           if	(likeOnOff == 0){
                           %>
                               <img src="image/OFF.png" alt="좋아요 수"> <%=countLike%>  
                        	<%
                           }else{
                        	 %>
                               <img src="image/ON.png" alt="좋아요 수"> <%=countLike%>  
                        	<%
                           }
                           %>
                           </span>
                           <span id="comment">
                               <img src="image/icon_comment.png" alt="댓글 수"> <%=countComment%>
                           </span>
                       </div>
                   </article>
               </li>
               <%} %>
               
           </ul>
<!-- 페이징 -->
		<div class ="pasingArea">
			<div class = "pasingBox">
				<%
				if(totalPost > 0){
					int pageCount = totalPost/ 5 +(totalPost % 5 == 0? 0:1);
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
						<button class="pageBtn" value=<%=startPage-5%>>이전</button>
					<%}
					//페이징
					int j;
					for( j= startPage; j<= endPage; j++){
					if(j == postpage){%>
						<button style="background-color:#bddbd2;" class="pageBtn" value=<%=j %>><%=j%></button>
						<%}else{
					%> 
						<button class="pageBtn" value=<%=j %>><%=j%></button>
					<%}
					}
					// 다음이라는 링크 만들건지 
					if(endPage < pageCount){%>
						<button class="pageBtn" value=<%=startPage+5%>>다음</button>
					<%}
				}
				
				%>
				</div>
			</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script>
		$(function(){
			$(".pageBtn").click(function() {
				$.ajax({
					url : 'myLike.jsp?postpage='+ $(this).val(),
					success : function(x) {
						$('#showPage').html(x);
					}
				})
			});
	
		});
	</script>
</body>

</html>