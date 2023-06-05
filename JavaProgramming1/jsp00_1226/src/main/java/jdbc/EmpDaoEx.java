package jdbc;

public class EmpDaoEx {

	public static void main(String[] args) {
		EmpDao ed = EmpDao.getInstance();
		for (Emp emp : ed.selectAll(2)) {
			System.out.println(emp);
		}

	}

}
