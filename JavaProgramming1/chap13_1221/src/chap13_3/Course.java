package chap13_3;

import java.util.ArrayList;
import java.util.List;

public class Course<T> {
	private String name;
	private List<T> students;
	
	public Course(String name) {
		super();
		this.name = name;
		this.students = new ArrayList<T>(); 
		//객체 생성해야하는데 T가 뭔지 모르니까 new T라고 쓸 수 없어서, 부모 클래스 중 가장 높은 Object. 
		//배열이기 때문에 []
		//부모가 자식 안에 들어가서 강제형변환.(T[])
		
	}
	

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<T> getStudents() {
		return students;
	}


	public void print() {
		System.out.print(this.name+":[");
		students.stream().forEach((e)->System.out.print(e.toString()));
		System.out.println("]");
	}
}
