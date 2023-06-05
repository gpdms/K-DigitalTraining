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

/**
 * Servlet implementation class MyController
 */
@WebServlet("/scott.do")
public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}
	private void process(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		Dao dao = Dao.getInstance();
		List<Emp> elst = dao.selectEmpAll();
		
		
		request.setAttribute("data", elst);
		RequestDispatcher rd =
				request.getRequestDispatcher("/result.jsp");
		rd.forward(request, response);
	}

}
