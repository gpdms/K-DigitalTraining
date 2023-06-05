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

public class Dao {
	//싱글톤 패턴
	private static Dao dao = new Dao(); //private다른사람이 접근 못하고 자기자신만 쓰는 자기자신 객체생성.
	private Dao() {} //생성자. 외부에서 호출X. 자신만쓰는.
	public static Dao getInstance() {
		return dao;
	}
	//싱글톤 끝----
	
	private Connection conn = getConnect();//객체가 생성될때 한번만 connection이 돼야.
	private Connection getConnect() {
		try {
			Properties prop = new Properties(); 
			// 위치정보. db.properties파일이 .클래스라는 파일이 있는데에 있다
			String path = Dao.class.getResource("db.properties").getPath();
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
	
	
	public int insertEmpTemp(Emp emp) { 
		String sql = "insert into emp_temp (empno, ename, job, mgr, hiredate, sal, comm, deptno) "
				+ "values (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, emp.getEmpno());
			pstm.setString(2, emp.getEname());
			pstm.setString(3, emp.getJob());
			pstm.setInt(4, emp.getMgr());
			pstm.setString(5, emp.getHiredate());
			pstm.setInt(6, emp.getSal());
			pstm.setInt(7, emp.getComm());
			pstm.setInt(8, emp.getDeptno());
			int res = pstm.executeUpdate();
			
			pstm.close();
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	

	
	public List<Dept> selectDept() {
		List<Dept> dlst = new ArrayList<>();
		
		String sql = "select * from dept_temp order by deptno";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				Dept dept = new Dept(deptno, dname, loc);
				dlst.add(dept);
			}
			rs.close();
			pstm.close();
			return dlst;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public Emp selectEmpTemp (int num) {
		String sql = "select empno, ename, job, deptno, sal, to_char(hiredate, 'YYYY/MM/DD') as hiredate, mgr, comm "
				+ "from emp_temp where empno = ?";
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
	
	
	public List<Emp> selectEmpTempAll () {
		List<Emp> elst = new ArrayList<>(); //담아서return하게 ArrayList하나 생성
		String sql = "select * from emp_temp order by empno";
		Emp emp = null;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int deptno = rs.getInt("deptno");
				int sal = rs.getInt("sal");
				String hiredate = rs.getString("hiredate");
				int mgr = rs.getInt("mgr");
				int comm = rs.getInt("comm");
				emp = new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno);
				elst.add(emp);
			}
			rs.close();
			pstm.close();
			return elst;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	public int updateEmpTemp(Emp emp) { 
		String sql = "update emp_temp set ename=?, job=?, mgr=?, hiredate=?, sal=?, comm=?, deptno=? "
				+ "where empno=?";
				
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, emp.getEname());
			pstm.setString(2, emp.getJob());
			pstm.setInt(3, emp.getMgr());
			pstm.setString(4, emp.getHiredate());
			pstm.setInt(5, emp.getSal());
			pstm.setInt(6, emp.getComm());
			pstm.setInt(7, emp.getDeptno());
			pstm.setInt(8, emp.getEmpno());
			int res = pstm.executeUpdate();
			
			pstm.close();
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public Dept selectDeptTemp(int num) {
		String sql = "select * from dept_temp where deptno = ?";
		Dept dept = null; //지역변수이면 return 못하니까 밖으로 뺌
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, num);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) { //한건이면 if
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				dept = new Dept(deptno, dname, loc);
			}
			rs.close();
			pstm.close();
			return dept;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int deleteEmpTemp(int empno) { 
		String sql = "delete from emp_temp where empno = ?";
				
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, empno);
			int res = pstm.executeUpdate();
			
			pstm.close();
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public String selectEmpJson() {
		String str = "[";
		String sql = "select json_object( 'empno' value empno,"
				+ "                    'ename' value ename,"
				+ "                    'job' value job,"
				+ "                    'mgr' value mgr,"
				+ "                    'hiredate' value to_char(hiredate, 'YYYY/MM/DD'),"
				+ "                    'sal' value sal,"
				+ "                    'comm' value comm,"
				+ "                    'deptno' value deptno "
				+ "						)"
				+ "from emp_temp";
		
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				str += rs.getString(1);
				str += ",";
			}
			String ss = str.substring(0, str.length()-1); //맨끝에 ,나오면 안되니까. 0부터 전체길이에서 하나뺀것까지 자름.
			ss += "]"; //마지막에 붙임.
			pstm.close();
			return str;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
}
