<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.board.db.*" %>
    
<%
    // 지정된 글 번호의 레코드를 DB에서 삭제
    int num = Integer.parseInt(request.getParameter("num"));
    new BoardDao().deleteOne(num);
  
    // 목록보기 화면으로 돌아감
    response.sendRedirect("list.jsp");
%>