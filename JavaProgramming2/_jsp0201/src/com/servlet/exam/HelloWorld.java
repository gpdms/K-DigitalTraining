package com.servlet.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/now")
public class HelloWorld extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public HelloWorld() {
        super();
    }

    protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response) 
                                 throws ServletException, IOException {
        
        response.setContentType("text/html; charset=utf-8"); 
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("    <meta charset=utf-8>");
        out.println("</head>");
        out.println("<body>");
        out.println("이곳에 화면에 출력될 내용이<br>");
        out.println("들어갑니다.<br>");
        out.println("</body>");
        out.println("</html>");
    }

    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response)
                                  throws ServletException, IOException {
        doGet(request, response);
    }
}