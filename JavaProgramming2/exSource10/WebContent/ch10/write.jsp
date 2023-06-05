<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.board.db.*" %>

<%
    // 글 번호 값 얻기, 주어지지 않았으면 0으로 설정
    String tmp = request.getParameter("num");
    int num = (tmp != null && tmp.length() > 0) ? Integer.parseInt(tmp)
                                                : 0;

    // 새 글쓰기 모드로 가정하고 시작
    BoardDto dto = new BoardDto();
    String action = "insert.jsp";
    
    // 글 번호가 주어졌으면 수정 모드
    if (num > 0) {
        dto = new BoardDao().selectOne(num, false);
        action = "update.jsp?num=" + num;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        table { width:680px; text-align:center; }
        th    { width:100px; background-color:cyan; }
        input[type=text], textarea { width:100%; }
    </style>
</head>
<body>

<form method="post" action="<%=action%>">
    <table>
        <tr>
            <th>제목</th>
            <td><input type="text" name="title"  maxlength="80"
                       value="<%=dto.getTitle()%>">
            </td>
        </tr>
        <tr>
            <th>작성자</th>
            <td><input type="text" name="writer" maxlength="20"
                       value="<%=dto.getWriter()%>">
            </td>
        </tr>
        <tr>
            <th>내용</th>
            <td><textarea name="content" 
                          rows="10"><%=dto.getContent()%></textarea>
            </td>
        </tr>
    </table>

    <br>
    <input type="submit" value="저장">
    <input type="button" value="취소" onclick="history.back()">
</form>

</body>
</html>