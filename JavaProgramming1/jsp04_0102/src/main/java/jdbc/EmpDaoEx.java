package jdbc;

import java.util.stream.IntStream;

public class EmpDaoEx {

	public static void main(String[] args) {
		EmpDao ed = EmpDao.getInstance();
//		Dept dept = new Dept(60, "회계", "인천");
//		int res = ed.insertDeptTemp(dept);
//		System.out.println(res); //1 나오면 성공
		
		//자료넣기
		IntStream.rangeClosed(1, 9).forEach(n-> {
			int res = ed.insertDeptTemp(new Dept(n*10, "회계"+n, "인천"+n));
			System.out.println(res);
		}
		
		);
		
	}

}
