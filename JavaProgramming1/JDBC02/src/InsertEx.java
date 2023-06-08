import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertEx {

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
		
		stmt = conn.createStatement(); //명령문을 만들어서 데이터베이스에 보내서 결과값받아옴.
//		int res = stmt.executeUpdate("insert into student "
//				+ "values(0,'김사랑','202204', '서울 강동구')"); //엔터치면 알아서+붙여줌
//		System.out.println(res+"건 입력성공");
		
		
		//입력받아서 데이터베이스에 넣기
		Scanner scan = new Scanner(System.in);
		System.out.print("이름>");
		String name = scan.nextLine();
		System.out.print("학번>");
		String hakbun = scan.nextLine();
		System.out.print("주소>");
		String address = scan.nextLine();
		int res = stmt.executeUpdate("insert into student "
				+ "values(0,'" + name + "','"+hakbun+"', '"+address+"')");
		System.out.println(res+"건 입력성공");
	}

}
