package mvc.hello;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.Dao;
import jdbc.Emp;
import mvc.command.CommandHandler;

//커맨드패턴: 하나의 명령어를 하나의 클래스에서 처리
public class ListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws UnsupportedEncodingException { //인터페이스 쓴 이유: 메소드의 시그너처를 동일하게 하기 위해서
		req.setCharacterEncoding("utf-8");
		Dao dao = Dao.getInstance();
		List<Emp> elst = dao.selectEmpAll();
		req.setAttribute("list", elst);
		return "/WEB-INF/view/list.jsp";
	}

}
