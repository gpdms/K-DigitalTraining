import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDB {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	//생성자
	StudentDB() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/thisisjava", "java", "mysql");
		System.out.println("접속 완료");
	}
	
	//메소드
	//select
	void selectAll() throws SQLException {
		stmt = conn.createStatement(); //접속정보를 가져와서 createStatement.
		rs = stmt.executeQuery("select * from student");
		while(rs.next() ) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String hakbun = rs.getString("hakbun");
			String address = rs.getString("address");
			System.out.printf("[%d] %s %s %s \n", id, hakbun, name, address);
		}
	}
	
	//insert
	void insert(String name, String hakbun, String address) throws SQLException {
		stmt = conn.createStatement();
		int result = stmt.executeUpdate("insert into student values(0,'"+name+"','"+hakbun+"','"+address+"')");
		System.out.println(result+"건 입력 성공");
	}
	
	//delete
	void delete(int num) throws SQLException {
		stmt = conn.createStatement();
		int result = stmt.executeUpdate("delete from student where id="+num); //문자열일경우 ''넣어야함.
		System.out.printf("%d의 자료를 %d건 삭제", num, result);
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		StudentDB sd = new StudentDB();
		sd.selectAll();
		sd.insert("박지민", "202207", "부산");
		sd.delete(9);
		sd.delete(11);
	}

}
