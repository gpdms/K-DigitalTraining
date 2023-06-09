<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="user.*" %>
<%@ page import="java.io.PrintWriter" %> 
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
		User user = null;
		user = new User(0 ,request.getParameter("userID"), request.getParameter("userPassword"), 
				request.getParameter("userNicname"), request.getParameter("userEmail"));
		if(session.getAttribute("userID") != null){
			userID = (String) session.getAttribute("userID");
		}
		if(userID != null){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('이미 로그인 되어있습니다.')");
			script.println("location.href = 'main.jsp'");
			script.println("</script>");
		}
	
		if(request.getParameter("userID") == null || request.getParameter("userPassword") == null || request.getParameter("userNicname")  == null ||
				request.getParameter("userEmail") == null){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('입력이 안된 사항이 있습니다.')");
			script.println("history.back()");
			script.println("</script>");
		} else {
			Dao dao = Dao.getInstance();
			
			int result = dao.join(user);
			if(result == -1){
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('이미 존재하는 아이디가 있습니다')");
				script.println("history.back()");
				script.println("</script>");
			} else{
				session.setAttribute("userID", request.getParameter("userID"));
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('회원가입')");
				script.println("location.href = 'main.jsp'");
				script.println("</script>");
			} 
		}
		
	%>
</body>
</html>