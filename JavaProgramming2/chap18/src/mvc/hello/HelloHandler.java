package mvc.hello;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

//커맨드패턴: 하나의 명령어를 하나의 클래스에서 처리
public class HelloHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		req.setAttribute("hello", "안녕하세요!");
		return "/WEB-INF/view/hello.jsp";
	}

}
