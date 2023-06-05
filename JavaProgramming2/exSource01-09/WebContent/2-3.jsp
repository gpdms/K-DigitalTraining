<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.*" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>테스트 페이지</title>
</head>
<body>
<%
    /*                                                               
        여러 줄 주석 :                                               
        Java 코드 시작                                        
    */	
    out.println("오늘 날짜 : " + LocalDate.now() + "<br>");
    out.println("현재 시간 : " + LocalTime.now());
    // 한 줄 주석 : Java 코드 끝
%>
<br><br>
 /* HTML 영역에서는
    JSP의 주석이 */
 // 일반 텍스트로 인식됩니다.
 
 <!-- 
     HTML 영역에서는 HTML 주석을 사용하세요.
     이 주석은 "소스보기"를 하면 보입니다.
 -->
 
 <%-- 
     HTML 영역에서 JSP 주석을 사용할 수도 있습니다.
     이 주석은 "소스보기"를 해도 보이지 않습니다.
     톰캣이 이 프로그램을 처리할 때 삭제하기 때문입니다.
 --%>
 
</body>
</html>