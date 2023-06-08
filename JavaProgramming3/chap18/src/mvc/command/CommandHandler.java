package mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//CommandHandler 인터페이스 정의
//모든 명령어 핸들러 클래스가 공통으로 구현해야하는 메서드 선언
public interface CommandHandler {
	public String process(HttpServletRequest req, HttpServletResponse res) 
	throws Exception;
}
