package testweb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/thisisjava", "java", "mysql");
			System.out.println("DB 접속");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	int insert(Student stu) {
		String sql = "insert into Student(name, hakbun, address	) values (?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql); //준비
			pstmt.setString(1, stu.name);//준비와 실행 사이에 넣기
			pstmt.setString(2, stu.hakbun);
			pstmt.setString(3, stu.addr);
			return pstmt.executeUpdate(); //실행
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) { //null이면 있지도 않은데 close하라해서 오류. null이 아닐때 close실행함.
				try {
				pstmt.close();
				} catch (SQLException e) {
				e.printStackTrace();
				}
			}
			
		}
		return 0;
	}
	
	//리턴타입임.
	List<Student> select() {
		List<Student> lst = new ArrayList<Student>();
		String sql = "select id, name, hakbun, address from student";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Student stu = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				lst.add(stu);
				
//				System.out.print(rs.getInt(1)+",");
//				System.out.print(rs.getString(2)+",");
//				System.out.print(rs.getString(3)+",");
//				System.out.println(rs.getString(4));
			}
			return lst;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public static void main(String[] args) {
		StudentDao dao = new StudentDao();
		dao.connect();
//		int res = dao.insert(new Student(999, "전정국", "202209", "부산"));
//		System.out.println(res+"건 입력!");
		List<Student> list = dao.select();
		for(Student stu : list) {
			System.out.println(stu);
		}
	}

}
