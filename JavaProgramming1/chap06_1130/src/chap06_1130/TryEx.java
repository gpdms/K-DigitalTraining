package chap06_1130;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TryEx {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = null;
		
			conn= DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/thisisjava",
					"java",
					"mysql");
			
			System.out.println("연결성공");
					
	
		
	}

}
