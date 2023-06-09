package jdbc;

public class Emp implements Comparable<Emp>{ //테이블명, 테이블마다 클래스가 있어야함.
	//필드(컬럼명과 이름같게)
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private String hiredate;
	private int sal;
	private int comm;
	private int deptno;
	
	//생성자
	public Emp(int empno, String ename, String job, int mgr, String hiredate, int sal, int comm, int deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}

	//Getter Setter: private를 jsp에서 쓰려면 gettet setter를 public으로 해서 씀.
	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "[부서번호:"+deptno+ "]," + "사원정보 [성명=" + ename + ", 직무=" + job + ", 입사일=" + hiredate + ", 급여=" + sal + ", 보너스=" + comm
				+ "]";
	}

	@Override
	public int compareTo(Emp o) {
		return Integer.compare(empno, o.empno);
	}
	
	
	
	
}
