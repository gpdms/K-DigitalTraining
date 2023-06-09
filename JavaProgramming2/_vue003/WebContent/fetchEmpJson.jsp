<%@page import="java.util.List"%>
<%@page import="jdbc.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Dao dao = Dao.getInstance();
	String str = dao.selectEmpTempJson();
	out.print(str);
%>