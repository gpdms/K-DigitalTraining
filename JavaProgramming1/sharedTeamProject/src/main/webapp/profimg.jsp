<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String saveFolder ="bbsUpload"; //사진을 저장할 경로
	String encType="utf-8"; // 변환 방식
	int maxSize = 5*1024*1024; // 사진의 size
	
	ServletContext context = this.getServletContext(); //절대경로를 얻는다.
	String realFolder = context.getRealPath("bbsUpload"); //saveFolder의 절대경로를 받는다.
	System.out.println(realFolder);
	MultipartRequest multi = null;
	
	
	//파일업로드를 실질적으로 담당하는 부분
	multi = new MultipartRequest(request,realFolder,maxSize,encType,new DefaultFileRenamePolicy());	

	//form으로 전달받은 것 가져온다.\
			String fileName = multi.getFilesystemName("fileName"); //파일이름
			
%>
</body>
</html>