import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectEx {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("드라이버 완료");

		Connection conn = null;
		Statement stmt = null;
		
		conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/thisisjava",
				"java",
				"mysql");
		System.out.println("DB 접속 성공");
		stmt = conn.createStatement(); //여기까지는 InsertEx와 동일.
		
		
		ResultSet rs = null;
		rs = stmt.executeQuery("select * from student");
		while(rs.next()) {
			System.out.println(rs.getString("name"));
		}
		

	}

}
