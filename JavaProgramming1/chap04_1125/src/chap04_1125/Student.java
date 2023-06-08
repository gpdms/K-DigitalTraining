package chap04_1125;

public class Student { // 클래스
	String name;
	String hakbun;
	String address;
	int kor;
	int math;
	int eng;

//생성자					필드
	public Student(String name, String hakbun, String address) {
		super();
		this.name = name;
		this.hakbun = hakbun;
		this.address = address;

	}

//셍성자					필드
	public Student(String name, String hakbun, String address, int kor, int math, int eng) {
		super();
		this.name = name;
		this.hakbun = hakbun;
		this.address = address;
		this.kor = kor;
		this.math = math;
		this.eng = eng;
	}

//메소드 ( void쓰면 return값이 없음)
	int sum() {
//		int result = this.kor + this.math + this.eng;
//		return result;
		// return = this.kor + this.math + this.eng; 동일
		return this.kor + this.math + this.eng;

	}

	void printSum() {
		System.out.println(sum());
	}

	// return값과 동일한 데이터타입
	double avg() {
		// double result = sum() / 3;
		// return result;
		return sum() / 3.0; // .0을붙여줘서 double로. 안붙이면 소수점이하 0으로뜸.
	}

	void printAvg() {
		System.out.println(avg());
	}

	

}
