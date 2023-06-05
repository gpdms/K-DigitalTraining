package jdbc;

import java.util.List;

public class DaoEx {

	public static void main(String[] args) {
		Dao dao = Dao.getInstance();
		List<String> lst = dao.selectEmpJson();
		for (String str : lst) {
			System.out.println(str);
		}
	}

}
