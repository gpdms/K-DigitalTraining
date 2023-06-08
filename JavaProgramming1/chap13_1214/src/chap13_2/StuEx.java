package chap13_2;

import java.util.ArrayList;
import java.util.List;

public class StuEx {

	public static void main(String[] args) {
		List<Student> lst = new ArrayList<Student>(); //lst에는 객체의 주소값이 저장.
		Student stu = new Student(0, "김", "202201", "서울"); //객체생성해서
		lst.add(stu); //주소값에 넣기.
		
		lst.add(new Student(1, "이", "202202", "인천"));
		lst.add(new Student(2, "박", "202203", "경기"));
		System.out.println(lst.get(0).hakbun);
		for (Student st : lst) {
			System.out.println(st.name);
		}
	}

}
