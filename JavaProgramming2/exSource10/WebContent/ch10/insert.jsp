<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.board.db.*" %>
 
<%
    request.setCharacterEncoding("utf-8");

    // 양식에 입력되었던 값 읽기
    String writer  = request.getParameter("writer" );
    String title   = request.getParameter("title"  );
    String content = request.getParameter("content");

    // 빈 칸이 하나라도 있으면 오류 출력하고 복귀
    if (writer  == null || writer.length()  == 0 ||
        title   == null || title.length()   == 0 ||
        content == null || content.length() == 0) {
%>      
        <script>
            alert('모든 항목이 빈칸 없이 입력되어야 합니다.');
            history.back();
        </script>
<%        
        return;
    }

    // 글 데이터를 DTO에 저장
    BoardDto dto = new BoardDto();
    
    dto.setWriter (writer );
    dto.setTitle  (title  );
    dto.setContent(content);
    
    // 입력된 내용으로 새 글 레코드 추가
    new BoardDao().insertOne(dto);
    
    // 목록보기 화면으로 돌아감
    response.sendRedirect("list.jsp");
%>     

