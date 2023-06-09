<%@page buffer = "1kb" %>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8"); //한글깨짐 방지
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//세션으로 학번 가져오기 or 세션말고 다른방법없을까
String userID = null;
	int studentNum = 0;
	if(session.getAttribute("userID") != null){
	userID = (String) session.getAttribute("userID");
	studentNum = (int) session.getAttribute("studentNum");
	}
//임의로 학번 정함
//int studentNum = 1001;
System.out.println("학번넘어오는지 학번:"+studentNum);
%>

<%

String saveFolder ="image"; //사진을 저장할 경로
String encType="utf-8"; // 변환 방식
int maxSize = 5*1024*1024; // 사진의 size

ServletContext context = this.getServletContext(); //절대경로를 얻는다.
String realFolder = context.getRealPath("image"); //image폴더의 절대경로를 받는다.
System.out.println(realFolder);
MultipartRequest multi = null;

//파일업로드를 실질적으로 담당하는 부분
multi = new MultipartRequest(request,realFolder,maxSize,encType,new DefaultFileRenamePolicy());	

//form으로 전달받은 파일이름 가져온다.
String fileName = multi.getFilesystemName("fileName"); 

//이전 사진명
File beforeImg = new File(realFolder+"\\"+studentNum+"프로필사진.jpg") ;


if(fileName != null) {
	   if(beforeImg.exists()) { //이전 프로필사진 있으면
	      beforeImg.delete(); //이전 사진 삭제
	      //사진업로드
	      File oldFile = new File(realFolder+"\\"+fileName);
	      File newFile = new File(realFolder+"\\"+studentNum+"프로필사진.jpg");
	      oldFile.renameTo(newFile);
	      System.out.println("저장된 파일 이름: "+newFile);
	      } else { //사진업로드
	      File oldFile = new File(realFolder+"\\"+fileName);
	      File newFile = new File(realFolder+"\\"+studentNum+"프로필사진.jpg");
	      oldFile.renameTo(newFile);
	      System.out.println("저장된 파일 이름: "+newFile);
	       }

	
}


%>

<script>
alert("프로필 사진이 변경되었습니다.");
location.href = 'myPage.jsp';
</script>
</body>
</html>