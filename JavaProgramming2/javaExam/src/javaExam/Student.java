package javaExam;

public class Student {
	String hakbun;
	String name;
	int kor, mat, eng;
	
	public Student(String hakbun, String name) {
		//super();
		this(hakbun, name, 0,0,0);
		//this.hakbun = hakbun;
		//this.name = name;
	}
	
	public Student(String hakbun, String name, int kor, int mat, int eng) {
		//super()대신 this(hakbun, name);
		this.hakbun = hakbun;
		this.name = name;
		this.kor = kor;
		this.mat = mat;
		this.eng = eng;
	}
	
	//총점을 리턴하는 메소드 sum() 평균 avg()
	
	
	
}
