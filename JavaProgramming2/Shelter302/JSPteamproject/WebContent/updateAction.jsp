<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="user.*" %>
<%@ page import="java.io.PrintWriter" %> 
<%@ page import="java.io.File" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Enumeration" %>



<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width", initail-scale="1"> 
<link rel="stylesheet" href="css/bootstrap.css">
<title>JSP  게시판 웹 사이트</title>
</head>
<body>
	<%	
		String userID = null;
		int studentNum = 0;
		if(session.getAttribute("userID") != null){
			userID = (String) session.getAttribute("userID");
			studentNum = (int) session.getAttribute("studentNum");
		}
		System.out.println("가져온 학생 아이디 :" + userID);
		System.out.println("가져온 학생번호 :" + studentNum);
		
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
		
		System.out.println("포스트넘버의 숫자 : " + postNum);
		if(userID == null){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('로그인을 진행하세요')");
			script.println("location.href = 'login.jsp'");
			script.println("</script>");
		} else{
			if(request.getParameter("bbsTitle") == null || request.getParameter("bbsContent") == null 
					|| request.getParameter("bbsTitle").equals("") || request.getParameter("bbsContent").equals("")){
						PrintWriter script = response.getWriter();
						script.println("<script>");
						script.println("alert('입력이 안된 사항이 있습니다.')");
						script.println("history.back()");
						script.println("</script>");
					} else {
						
						Dao dao = Dao.getInstance();
						int result = dao.update(postNum, request.getParameter("bbsTitle"), request.getParameter("bbsContent"));
						if(result == -1){
							PrintWriter script = response.getWriter();
							script.println("<script>");
							script.println("alert('수정에 실패했습니다')");
							script.println("history.back()");
							script.println("</script>");
						} else{
							System.out.println(request.getParameter("bbsTitle"));
							System.out.println(request.getParameter("bbsContent"));
							System.out.println(result);
							PrintWriter script = response.getWriter();
							script.println("<script>");
							script.println("location.href = 'anolist.jsp'");
							script.println("</script>");
						} 
					}
		}
	
		
		
	%>
</body>
</html>