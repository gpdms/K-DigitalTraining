package chap05_1128;

public class Students {
	Student[] stuArr; //클래스 배열을 멤버필드로.
	
	void init() {
		for (int i=0; i<stuArr.length; i++) {
			insertStudent(i, "홍"+i, "0"+(i+1),"서울",89+i,97+i,67+i);
		}
	}

	void insertStudent(int i, String name, String hakbun, String address, 
								int kor, int math, int eng) {
		stuArr[i] = new Student(name, hakbun, address, kor, math, eng);
	}
	
	Student searchStudent(String hakbun) {
		for (int i = 0; i < stuArr.length; i++) {
			if (stuArr[i].hakbun.equals(hakbun)) {
				return stuArr[i];
			}
		}
		return null;
	}
	
	void updateScore(String hakbun, int kor, int math, int eng) {
		Student student = searchStudent(hakbun);
		if (kor >= 0) {
			student.kor = kor;
		}
		if (math >= 0) {
			student.math = math;
		}
		if (eng >= 0) {
			student.eng = eng;
		}
	}
}
