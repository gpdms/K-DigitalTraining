package project2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SeatUpdate {
	Connection conn;

	Statement stmt;

	ResultSet rs;

	String number;
	String seatNum;
	
	void setNum(String number){
		this.number=number;
	}
	
	void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}
	
	
	
	void sUpdate() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("드라이버 완료");
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/thisisjava", "java", "mysql");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("접속 완료");
	
	
		try {
			stmt = conn.createStatement();
			int result = stmt.executeUpdate("update customer set seat ='"+seatNum+"'where number ='"+number+"'");
			System.out.println(result+"건 입력 성공");
		} catch (SQLException e) {
//			System.out.println("좌석정보 삽입 실패");
			e.printStackTrace();
		}
		return;
	}
	
	
	
	void sRemove() {
		
	}

}
