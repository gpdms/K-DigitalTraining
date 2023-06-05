<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    
<%@ page import="java.util.*" %>
<%@ page import="com.board.db.*" %>

<%
    // 게시글이 담긴 DTO객체들의 리스트를, request의 속성 "msgList"로 등록
    request.setAttribute("msgList", new BoardDao().selectList());
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        table     { width:680px; text-align:center; }
        th        { background-color:cyan; }
        
        .num      { width: 80px; }
        .title    { width:230px; }
        .writer   { width:100px; }
        .regtime  { width:180px; }
                
        a:link    { text-decoration:none; color:blue; }
        a:visited { text-decoration:none; color:gray; }
        a:hover   { text-decoration:none; color:red;  }
    </style>
</head>
<body>

<table>
    <tr>
        <th class="num"    >번호    </th>
        <th class="title"  >제목    </th>
        <th class="writer" >작성자  </th>
        <th class="regtime">작성일시</th>
        <th                >조회수  </th>
    </tr>
    
    <c:forEach var="msg" items="${msgList}">
    <tr>
        <td>${msg.num}</td>
        <td style="text-align:left;">
            <a href="view.jsp?num=${msg.num}">${msg.title}</a>
        </td>
        <td>${msg.writer}</td>
        <td>${msg.regtime}</td>
        <td>${msg.hits}</td>
    </tr>
    </c:forEach>            
</table>

<br>
<input type="button" value="글쓰기" onclick="location.href='write.jsp'">

</body>
</html>