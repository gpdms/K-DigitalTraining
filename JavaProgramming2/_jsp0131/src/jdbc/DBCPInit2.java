package jdbc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;



public class DBCPInit2 extends HttpServlet {

	@Override
	public void init() throws ServletException {
		loadJDBCDriver();
		initConnectionPool();
	}

//web.xml이랑 같이 보기
	private void loadJDBCDriver() {
		String driverClass = getInitParameter("jdbcdriver");
		System.out.println(driverClass);
	}

	private void initConnectionPool() {
	
			String jdbcUrl = getInitParameter("jdbcUrl");
			String username = getInitParameter("dbUser");
			String pw = getInitParameter("dbPass");
			String poolName = getInitParameter("poolName");
			System.out.println(jdbcUrl);
			System.out.println(username);
			System.out.println(pw);
			System.out.println(poolName);
		
	}	
} 
