<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import= "user.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

	String commentContent = null;
	if(request.getParameter("commentContent") != null){
		commentContent = request.getParameter("commentContent");
		System.out.println("이건 코멘트 내용     " + commentContent);
	}
	
	int commentNum = 0;
	if(request.getParameter("commentNum") != null){
		commentNum =  Integer.parseInt(request.getParameter("commentNum")); 
		System.out.println("이건 코멘트 번호     " + commentNum);
	}
	System.out.println("이건 코멘트 밖 번호     "+commentNum +"      이건 코멘트 넘버");
	
	System.out.println("이건 코멘트뱎 냉ㅇ    "+commentContent +"      이건 코멘트 넘버");
	// 값이 넘어왔나 확인
 	
	
	Dao dao = Dao.getInstance();
	int result = dao.deleteComment(commentContent, commentNum);
 	
 	if(result == 1){
 		System.out.print("deleted the comment");
 		
 	}
%>
<script type="text/javascript">
	  location.href = "view.jsp" 
	  alert("댓글이 삭제 되었습니다.");
</script>

</body>
</html>