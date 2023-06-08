package jdbc;

public class EmpDaoEx {

	public static void main(String[] args) {
		EmpDao ed = EmpDao.getInstance();
		for (Emp emp : ed.selectAll(0)) {
			System.out.println(emp);
		}

	}

}
