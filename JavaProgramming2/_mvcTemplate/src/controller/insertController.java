package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.Dao;
import jdbc.Emp;

@WebServlet("/insert")
public class insertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int empno = Integer.parseInt(request.getParameter("empno"));
		String ename = request.getParameter("ename");
		String job = request.getParameter("job");
		int sal = Integer.parseInt(request.getParameter("sal"));
		Emp emp = new Emp(empno, ename, job, sal);
		Dao dao = Dao.getInstance();
		int res = dao.insertEmpTemp(emp);
		
		request.setAttribute("result", res);
		
		RequestDispatcher rd =
				request.getRequestDispatcher("/result.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
