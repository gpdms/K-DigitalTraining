
<%@page import="user.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userID = null;
	int studentNum = 0;
	if(session.getAttribute("userID") != null){
	userID = (String) session.getAttribute("userID");
	studentNum = (int) session.getAttribute("studentNum");
	}
	
	int postNum = Integer.parseInt(request.getParameter("postNum"));
	
	Dao dao = Dao.getInstance();
	dao.likeDB(postNum, studentNum);
	
%>

