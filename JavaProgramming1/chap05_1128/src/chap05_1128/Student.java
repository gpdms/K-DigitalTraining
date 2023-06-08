package chap05_1128;

//클래스
public class Student {
	
	//필드 -중괄호가 없음. 아래에 위치해도 상관없음. 메소드 안에만 있으면됨. 클래스는 위아래 상관없음.
	String name;
	String hakbun;
	String address;
	int kor;
	int math;
	int eng;
	
	Student (){
		
	}
	
	//생성자-클래스이름과 동일. 중괄호가 있음. return타입 없음(객체를 만들어서 넘겨줘야하니까)
	Student(String name, String hakbun, String address) { //매개변수를 받아서 
		this.name = name; //필드에 변수를 전달
		this.hakbun = hakbun;
		this.address = address;
	}
	//생성자 오버로딩
	//이름중복 허용.
	Student(String name, String hakbun, String address, int kor, int math, int eng) {
		this.name = name;
		this.hakbun = hakbun;
		this.address = address;
		this.kor = kor;
		this.math = math;
		this.eng = eng;
	}
	
	//int같은 타입에서는 return값없으면 void해주어야
	int sum() { //int보다 숫자 너무 크면 long
		return this.kor + this.math + this.eng;
	}
	
	double avg() { //double, float
		return sum() / 3.0; //정수형과 정수형이면 정수형으로 나옴.
		//return (double) sum()/3; 이렇게 써줘도됨!
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", hakbun=" + hakbun + ", address=" + address + ", kor=" + kor + ", math="
				+ math + ", eng=" + eng + "]";
	}
	
	
}
