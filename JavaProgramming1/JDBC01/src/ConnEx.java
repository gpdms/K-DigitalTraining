import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//프로젝트마다 이 과정 해줘야함. build path, Class.forName("com.mysql.cj.jdbc.Driver");
public class ConnEx {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		 //드라이버 깔고 확인
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("드라이버 성공");
		
		//접속
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/thisisjava" , 
				"java", 
				"mysql");
		System.out.println("접속 성공");
		
		//명령어. 정보가져옴
		Statement st = conn.createStatement(); //import는 java.sql을 선택
		ResultSet rs = st.executeQuery("select * from student where id = 3"); //sql을 쓰고
		if (rs.next()) {
			System.out.println(rs.getString("address"));
		}
	}

}
