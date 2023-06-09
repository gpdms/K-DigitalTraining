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
	<!-- 글목록 부분 -->
	<%
	String userID = null;
	int studentNum = 0;
	if(session.getAttribute("userID") != null){
	userID = (String) session.getAttribute("userID");
	studentNum = (int) session.getAttribute("studentNum");
	}
	
	//페이지 누르면 값 가져오기

	String commentpg = request.getParameter("commentpage");
	if (commentpg == null) {
		commentpg = "1";
	}
	int commentpage = Integer.parseInt(commentpg);
	//1->0 ; 2-> 10
	int index_no = (commentpage - 1) * 5;

	//DB연결, comment테이블정보 담은 리스트
	Dao dao = Dao.getInstance();
	List<Comment> commentList = dao.selectCommentID(studentNum, index_no);
	

	//내가 작성한 총 댓글 개수
	int totalComment = dao.countCommentID(studentNum);
	//
	/* int lastCommentpage = (int) Math.ceil((double) totalComment / 5); */
	%>
	<div id="showPage">
	<ul>
           <%
           for (int i = 0; i <= commentList.size() - 1; i++) {
           %>
               <li>
                   <article>
                       
                       <h1>
                       <a href="view.jsp?postNum=<%=commentList.get(i).getPostNum()%>&board=mypage">
                       <%=commentList.get(i).getTitle() %></a>
                       </h1>    
                      
                       <div id="date"><%=commentList.get(i).getDate() %></div>
                       <p>
                       <a href="view.jsp?postNum=<%=commentList.get(i).getPostNum()%>&board=mypage">
                       <%=commentList.get(i).getCommentContent() %></a>
                       </p>
                   </article>
               </li>
               <%} %>
           </ul>
	

	<!-- 페이징 -->
		<div class ="pasingArea">
			<div class = "pasingBox">
				<%
				if(totalComment > 0){
					int pageCount = totalComment/ 5 +(totalComment % 5 == 0? 0:1);
					int startPage = 1;
					if(commentpage % 5 != 0){
						startPage = (int)(commentpage/5)*5+1;
					}else{
						startPage = ((int)(commentpage/5)-1)*5+1;
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
					if(j == commentpage){%>
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
				url : 'myComment.jsp?commentpage='+ $(this).val(),
				success : function(x) {
					$('#showPage').html(x);
				}
			})
		});

	});
	</script>
</body>

</html>