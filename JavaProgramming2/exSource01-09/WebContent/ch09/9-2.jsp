<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
    <tr>
        <td>3</td>
        <td style="text-align:left;">
            <a href="view.jsp?num=3">글 제목 3</a>
        </td>
        <td>홍길동</td>
        <td>2020-02-06 17:31:25</td>
        <td>12</td>
    </tr>
    <tr>
        <td>2</td>
        <td style="text-align:left;">
            <a href="view.jsp?num=3">글 제목 2</a>
        </td>
        <td>장길산</td>
        <td>2020-02-06 14:32:25</td>
        <td>31</td>
    </tr>
</table>

<br>
<input type="button" value="글쓰기" onclick="location.href='write.jsp'">

</body>
</html>