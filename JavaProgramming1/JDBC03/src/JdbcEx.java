import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcEx {
	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	
	//드라이버
	public static void connect() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("드라이버 설치 완료");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/thisisjava", "java", "mysql");
		System.out.println("접속 완료");
	}
	
	//SELECT
	public static void selectAll() throws SQLException {
		stmt = conn.createStatement();
		rs = stmt.executeQuery("select * from student");
		while (rs.next()) { // if 쓰면 최초 데이터 하나만 가져옴. while 쓰면 전체 데이터 가져옴.
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String hakbun = rs.getString("hakbun");
			String address = rs.getString("address");
			System.out.println(id + "," + name + "," + hakbun + "," + address);
		}
	}
	
	//INSERT
	public static void insert(String name, String hakbun, String address) throws SQLException {
		stmt = conn.createStatement();
		int result = stmt.executeUpdate("insert into student values(0,'"+name+"','"+hakbun+"','"+address+"')");
		System.out.println(result + "건 입력 성공");
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//메소드로 만들어서 호출하기. 매번 길게쓰기 귀찮으니까. static이니까 그냥 메소드명으로 호출.
		connect();
		insert("김남준", "202206", "일산");
		selectAll();
	}

}
