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

public class EmpDao {
	private Connection conn = getConnect();
	
//싱글톤: 외부에서 생성자 호출을 막기 위해 private 붙여줌. 
//자신의 타입인 정적필드 하나 선언하고 자신의 객체를 생성해 초기화.
//클래스 내부에서는 new 연산자로 생성자 호출이 가능.
//외부에서 호출하려면 정적 메소드 getInstance()를 선언하고, 정적필드에서 참조하고 있는 자신의 객체 리턴.
	
	//정적필드
	private static EmpDao empDao = new EmpDao();
	//생성자
	private EmpDao() {
	} 
	//정적메소드
	public static EmpDao getInstance() {
		return empDao;
	}
	private Connection getConnect() {
		try {
			Properties prop = new Properties();
			String path = EmpDao.class.getResource("db.properties").getPath();
			path = URLDecoder.decode(path, "utf-8");
			prop.load(new FileReader(path));
			String driver = prop.getProperty("driver");
			System.out.println(driver);
			Class.forName(driver);
			String url = prop.getProperty("url");
			System.out.println(url);
			String user = prop.getProperty("user");
			System.out.println(user);
			String pw = prop.getProperty("pw");
			System.out.println(pw);
//			String url = "jdbc:oracle:thin:@localhost:1521:xe";
//			String user = "scott", pw = "tiger";
			Connection conn = DriverManager.getConnection(url, user, pw);
			return conn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public Emp select(int num) {
		String sql = "select * from emp where empno = ?";
		Emp emp = null;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, num);
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
//				System.out.printf("%d %s %s %d %d\n", empno, ename, job, deptno, sal);
				emp = new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno);

			}
			rs.close();
			pstm.close();
			return emp;

//			return 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public List<Emp> selectAll(int num) {
		List<Emp> lst = new ArrayList<>();

		String sql = null;
		switch (num) {
		case 0: // 정렬 안함
			sql = "select * from emp";
			break;
		case 1: // 부서별 오름차순
			sql = "select * from emp order by deptno";
			break;
		case 2: // 부서별 내림차순
			sql = "select * from emp order by deptno desc";
			break;
		}
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
//				System.out.printf("%d %s %s %d %d\n", empno, ename, job, deptno, sal);
				Emp emp = new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno);
				lst.add(emp);
			}
			rs.close();
			pstm.close();
			return lst;

//			return 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public List<Emp> selDeptSvg() {
		List<Emp> lst = new ArrayList<>();

		String sql = "select deptno, job, avg(sal) as avg_sal" + "  from emp " + "group by deptno, job " + "order by deptno, job";

		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				int empno = 0;
				String ename = null;
				String job = rs.getString("job");
				int deptno = rs.getInt("deptno");
				int sal = rs.getInt("avg_sal");
				String hiredate = null;
				int mgr = 0;
				int comm = 0;
//				System.out.printf("%d %s %s %d %d\n", empno, ename, job, deptno, sal);
				Emp emp = new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno);
				lst.add(emp);
			}
			rs.close();
			pstm.close();
			return lst;

//			return 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}
	public static void main(String[] ar) {
		EmpDao ed = EmpDao.getInstance(); //connect함. 싱글톤
		List<Emp> lst = ed.selectAll(0); //자료를 가져오는
		for (Emp emp : lst) {
			System.out.println(emp);
		}
		//arraylist는 스트림으로 쓸 수 있음.
//		lst.stream().mapToInt(Emp::getSal).forEach(n->System.out.println(n));
							//.stream: 스트림 처음단계
							//.mapToInt:스트림 중간단계. 객체안에 ename, sal 등 여러값. 그중에서 Int값 하나 꺼내온다는 뜻	
							//Emp::getSal는 Emp.getSal()뜻함. Emp클래스 안에, getSal이라는 getter setter메소드. 
							//.forEach:스트림 최종단계
							//n은 Emp인것. n.눌러보면 Emp안에 있는 메소드들 나옴.
		lst.stream().forEach(n->System.out.println(n.getEmpno()+n.getEname()));
		
		lst.stream().map(Emp::getEname).forEach(n->System.out.println(n));
							//문자열일때 map
		int ss = lst.stream().mapToInt(Emp::getSal).sum(); //합계구함. 프린트 못하니까 변수에 넣음.
		System.out.println("합계: "+ss);
		
		long cc = lst.stream().count(); //중간단계는 없어도 최종단계는 있음. 최종단계 메소드들p.798
		System.out.println(cc);
		
		
	}
}




