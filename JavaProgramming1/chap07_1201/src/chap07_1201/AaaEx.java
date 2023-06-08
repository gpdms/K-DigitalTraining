package chap07_1201;

public class AaaEx {

	public static void main(String[] args) {
//		Aaa a1 = new Aaa(); //오류는 안남.
//		Aaa a2 = new Aaa(); //static은 어차피 객체하나만 생성되기 때문에 쓰나마나.
		
//		a1.a = 10;
//		System.out.println(a2.a); //a1과 a2결과 같음. static때문에.

		
		
		//new 안쓰고 클래스명.필드 로 접근하면됨.
		Aaa.a = 10;
		
		//클래스명.메소드로 접근
		Aaa.aaa();
	}

}
