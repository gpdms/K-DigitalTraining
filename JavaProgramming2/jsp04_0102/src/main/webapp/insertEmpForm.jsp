<%@page import="jdbc.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
EmpDeptDao edd = EmpDeptDao.getInstance();
List<Dept> dlist = edd.selectDept();
%>
<form action="insertEmp.jsp" method="post">
<table border="1">
<tr><td>사번</td><td><input type="text" name="empno"/></td></tr>
<tr><td>이름</td><td><input type="text" name="ename"/></td></tr>
<tr><td>직무</td><td><input type="text" name="job"/></td></tr>
<tr><td>상금자 사번</td><td><input type="text" name="mgr"/></td></tr>
<tr><td>입사일</td><td><input type="text" name="hiredate"/></td></tr>
<tr><td>급여</td><td><input type="text" name="sal"/></td></tr>
<tr><td>보너스</td><td><input type="text" name="comm"/></td></tr>
<tr><td>부서번호</td><td>
<select name="deptno">
<option>부서선택</option>
<% for (Dept dept : dlist) { %>
<option value="<%=dept.getDeptno()%>"><%=dept.getDname() %></option>
<%} %>
</select>
</td></tr>
<tr><td>확인</td><td><input type="reset" name="초기화"/>
<input type="submit" value="저장"/></td></tr>
</table>
</form>

</body>
</html>