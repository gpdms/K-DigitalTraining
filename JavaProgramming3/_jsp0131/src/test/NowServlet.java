package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//@WebServlet("/now") //web.xml과 같은 기능. @는 컴파일하고 저장해야. 수정을 수시로 해야한다면 web.xml이 나음.
@WebServlet(urlPatterns= {"/now2", "/now4"})
public class NowServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
	HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8"); //한글부분

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>현재시간</title></head>");
		out.println("<body>");
		out.println("현재 시간은");
		out.println(new Date());
		out.println("입니다.");
		out.println("</body></html>");
	}
//실행해서 url에 /now붙여주기
}