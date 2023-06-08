package mvc.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import mvc.command.NullHandler;

public class ControllerUsingFile extends HttpServlet {
	//p.533
    // <커맨드, 핸들러인스턴스> 매핑 정보 저장. 각각 문자열, 객체 타입
    private Map<String, CommandHandler> commandHandlerMap = 
    		new HashMap<>();
    
    //init(): 서블릿을 생성하고 초기화할때 호출되는 메서드
    public void init() throws ServletException {
        String configFile = getInitParameter("configFile"); //getInitParameter: web.xml에서 읽어옴. commandHandler.properties임.
        Properties prop = new Properties(); //Properties 객체: (이름,값) 목록을 갖는 클래스.
        String configFilePath = getServletContext().getRealPath(configFile); //설정파일(commandHandler.properties)의 경로를 구함.
        try (FileReader fis = new FileReader(configFilePath)) { 
            prop.load(fis); //설정파일로부터 매핑정보를 가져와 Properties객체에 저장.프로퍼티 이름=>커맨드이름. 값=>클래스이름.
        } catch (IOException e) {
            throw new ServletException(e);
        }
        //반복문돌림
        Iterator keyIter = prop.keySet().iterator();
        while (keyIter.hasNext()) {
            String command = (String) keyIter.next();
            String handlerClassName = prop.getProperty(command);
            try {
                Class<?> handlerClass = Class.forName(handlerClassName); //클래스가 있느냐. 없으면 ClassNotFound에러.
                CommandHandler handlerInstance = 
                        (CommandHandler) handlerClass.newInstance(); //객체생성
                commandHandlerMap.put(command, handlerInstance);
            } catch (ClassNotFoundException | InstantiationException 
            		| IllegalAccessException e) {
                throw new ServletException(e);
            }
        }
    }
    
    //get방식
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }
    
    //post방식
    protected void doPost(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("cmd");
        CommandHandler handler = commandHandlerMap.get(command);
        
        if (handler == null) {
            handler = new NullHandler();
        }
        String viewPage = null;
        try {
            viewPage = handler.process(request, response);
        } catch (Throwable e) {
            throw new ServletException(e);
        }
        if (viewPage != null) {
	        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
	        dispatcher.forward(request, response);
        }
    }
}
