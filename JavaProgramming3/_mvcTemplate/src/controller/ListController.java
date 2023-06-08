package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.Dao;
import jdbc.Emp;

@WebServlet("/list") //요청명. 웹사이트에서 클릭하면 얘가 요청된다는뜻.
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Dao dao = Dao.getInstance();
		List<Emp> elst = dao.selectEmpAll();
		request.setAttribute("list", elst);
		RequestDispatcher rd =
				request.getRequestDispatcher("/list.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
