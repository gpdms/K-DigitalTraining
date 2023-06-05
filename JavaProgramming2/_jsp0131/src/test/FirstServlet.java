package test;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; //버전 맞춰줌
       
   
    public FirstServlet() {
        super();
        System.out.println("생성자");
    }

	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init"); //처음 한번 실행. 초기화 작업.
	}

	
	public void destroy() {
		System.out.println("destroy"); //수정 후 저장하면 얘가 실행. 이전 것이 destroy.
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service"); //새로고침하면 얘가 계속 실행
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		   
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
