package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdbc.Dao;
import jdbc.Emp;

/**
 * Servlet implementation class MyController
 */
@WebServlet("/scott")
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
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//얘가 컨트롤러 : 컨트롤러는 서블릿이라고 불리는 자바코드(?)
		Dao dao = Dao.getInstance();
		List<Emp> elst = dao.selectEmpAll();
		
//		for (Emp emp : elst) {
//			System.out.println(emp);
//		}

		//브라우저에 보이게 하는게 뷰
		request.setAttribute("data", elst); //(이름,값). request기본객체 쓰는 이유: 포워딩할때 잠깐쓰고 클리어하려고.
		
		RequestDispatcher rd = request.getRequestDispatcher("/result.jsp");
		rd.forward(request, response);
		
		
	
		
	}
	
	
}
