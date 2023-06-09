package jdbc;

import java.util.List;

public class DaoEx {

	public static void main(String[] args) {
		Dao dao = Dao.getInstance();
		String str = dao.selectEmpTempJson();
		System.out.println(str);

	}

}
