<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="user.*" %>
<%@ page import="java.io.PrintWriter" %> 
<%@ page import="java.io.File" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
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
		
		
		String saveFolder ="bbsUpload"; //사진을 저장할 경로
		String encType="utf-8"; // 변환 방식
		int maxSize = 5*1024*1024; // 사진의 size
		
		ServletContext context = this.getServletContext(); //절대경로를 얻는다.
		String realFolder = context.getRealPath("bbsUpload"); //saveFolder의 절대경로를 받는다.
		System.out.println(realFolder);
		MultipartRequest multi = null;
		
		
		//파일업로드를 실질적으로 담당하는 부분
		multi = new MultipartRequest(request,realFolder,maxSize,encType,new DefaultFileRenamePolicy());	
		
		//form으로 전달받은 3가지를 가져온다.\
		
		String fileName = multi.getFilesystemName("fileName"); //파일이름
		String bbsTitle = multi.getParameter("bbsTitle"); // 게시판 제목 
		String bbsContent = multi.getParameter("bbsContent"); // 게시판 내용
	
		
		if(userID == null){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('로그인을 진행하세요')");
			script.println("location.href = 'login.jsp'");
			script.println("</script>");
		} else{
			if(bbsTitle == null || bbsContent == null){
						PrintWriter script = response.getWriter();
						script.println("<script>");
						script.println("alert('입력이 안된 사항이 있습니다.')");
						script.println("history.back()");
						script.println("</script>");
					} else {
						
						Dao dao = Dao.getInstance();
						int result = dao.write(bbsTitle, studentNum, bbsContent);
						if(result == -1){
							PrintWriter script = response.getWriter();
							script.println("<script>");
							script.println("alert('글쓰기에 실패했습니다')");
							script.println("history.back()");
							script.println("</script>");
						} else{
							PrintWriter script = response.getWriter();
							if(fileName != null){
								File oldFile = new File(realFolder+"\\"+fileName); 
								File newFile = new File(realFolder+"\\"+postNum+"사진.jpg");
								oldFile.renameTo(newFile);
								System.out.println(newFile);
							}
							script.println("<script>");
							script.println("location.href = 'anolist.jsp'");
							script.println("</script>");
						} 
					}
		}
	
		
		
	%>
</body>
</html>