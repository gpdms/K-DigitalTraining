package jdbc;

public class EmpDaoEx {

	public static void main(String[] args) {
//		EmpDao ed = new EmpDao(); 안됨
		EmpDao ed = EmpDao.getInstance();
		for (Emp emp : ed.selectAll()) {
			System.out.println(emp);
		}
	}

}
