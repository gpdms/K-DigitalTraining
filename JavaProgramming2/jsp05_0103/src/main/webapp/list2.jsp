<%@page import="jdbc.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
 <% //현재는 필요없는
 String str = request.getParameter("order");
 int num = 0;
 if (str != null) {
	 num = Integer.parseInt(str);
 }
 %>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head> 
<body>

<a href="insertEmpForm.jsp">사원 등록</a>
<table border = "1">
	<tr>
		<td>사번</td>
		<td>이름</td>
		<td> <!-- onChange에 변경 이벤트 발생시 호출될 함수명 -->
			<select onChange="order(this.value)">
				<option value="0">부서별</option>
				<option value="1">오름차순</option>
				<option value="2">내림차순</option>
			</select>
		</td>
	</tr>
	
	<%
	Dao ed = Dao.getInstance(); //ctrl+space
	for(Emp emp : ed.selectEmpTempAll()) {
	%>
	<tr>
	<!-- detail에 매개변수로 사번들이 들어감 -->
		<td><a href="updateEmpForm.jsp?empno=<%=emp.getEmpno()%>"><%=emp.getEmpno()%></a></td>
		<td><%=emp.getEname()%></td>
		<td><%=emp.getDeptno()%></td>
	
	</tr>
	<%
	}
	%>

</table>
</body>
</html>