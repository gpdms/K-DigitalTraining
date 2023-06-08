<%@page import="user.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8"); //한글깨짐 방지
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//Dao 연결
	Dao dao = Dao.getInstance(); 

//수정후 확인버튼 누르면 DB에 update
	int studentNum = Integer.parseInt(request.getParameter("studentNum"));	
	String userID = request.getParameter("userID");
	String nickName = request.getParameter("nickName");
	String pw = request.getParameter("pw");
	String email = request.getParameter("email");
	
	User user = new User(studentNum, userID, nickName, pw, email);
	int result = dao.updateUser(user);
	//out.println(result+"건 수정완료");
%>
<%--수정완료되면 알림창뜨고 마이페이지로 돌아가기 --%>
<script>
alert("정보가 수정되었습니다.");
opener.location.reload(); //부모창 새로고침
window.close(); //팝업창 닫기
</script>
</body>
</html>