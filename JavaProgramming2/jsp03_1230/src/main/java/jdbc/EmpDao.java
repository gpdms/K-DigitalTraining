package jdbc;

import java.io.FileReader;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EmpDao { // 얘 new생성 안해도
	// 프로그램 시작했을때 하나만. new를 여러개 못하게.

	// 싱글톤
	private Connection conn = getConnect(); // getConnect()메소드 만들어야함
	private static EmpDao empDao = new EmpDao();

	public static EmpDao getInstance() { // 얘만 public. 얘만 서비스됨.
		return empDao;
	}

	private EmpDao() {

	}
//---여기까지 싱글톤.

	public List<Emp> lst; // 필드하나더 선언

	private Connection getConnect() {
		try {
			Properties prop = new Properties(); // Properties라는 클래스
			// 위치정보
			String path = EmpDao.class.getResource("db.properties").getPath();
			path = URLDecoder.decode(path, "utf-8");
			// 형식잡음
			prop.load(new FileReader(path)); // 파일 읽음
			String driver = prop.getProperty("driver"); // 안에있는 driver정보
			Class.forName(driver);
			String url = prop.getProperty("url");
			String user = prop.getProperty("user");
			String pw = prop.getProperty("pw");
			Connection conn = DriverManager.getConnection(url, user, pw);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Emp> realSelectAll() {
		lst = new ArrayList<Emp>();
		String sql = "select * from emp";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int deptno = rs.getInt("deptno");
				int sal = rs.getInt("sal");
				String hiredate = rs.getString("hiredate");
				int mgr = rs.getInt("mgr");
				int comm = rs.getInt("comm");
				Emp emp = new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno);
				lst.add(emp);
			}
			rs.close();
			return lst;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Emp> selectAll(int num) { // arraylist안에 Emp밖에 없으니까. 매개변수(n)가 나오면 무조건Emp
		List<Emp> lst2 = new ArrayList<>();
		switch (num) {
		case 0: // 정렬 안함
			return lst;
		case 1: // 부서별 오름차순
			lst.stream().sorted().sorted((n1, n2) -> n1.getDeptno() - n2.getDeptno()).forEach(n -> lst2.add(n));
			return lst2;
		case 2: // 부서별 내림차순
			lst.stream().sorted().sorted((n1, n2) -> n2.getDeptno() - n1.getDeptno()).forEach(n -> lst2.add(n));
			return lst2;
		}
		return lst2;
	}

	public Emp select(int num) {
		String sql = "select * from emp where empno = ?";
		Emp emp = null;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, num); // 물음표 안에 int값.
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int deptno = rs.getInt("deptno");
				int sal = rs.getInt("sal");
				String hiredate = rs.getString("hiredate");
				int mgr = rs.getInt("mgr");
				int comm = rs.getInt("comm");
				emp = new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno);
			}
			rs.close();
			pstm.close();
			return emp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}
