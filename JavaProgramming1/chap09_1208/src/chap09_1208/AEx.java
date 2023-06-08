package chap09_1208;

public class AEx {

	public static void main(String[] args) {
		
	//인스턴스 멤버 클래스 객체 생성
		A a = new A();
		A.B b = a.new B();
		//위 두줄을 한줄로하면
		A.B z = new A().new B(); //A먼저 생성되고 B생성
		
		b.field1 = 3;
		b.method1();
		
		
	//정적 멤버 클래스 객체 생성
		A.C c = new A.C(); //A.C로 생성
		c.field1 = 3;
		c.method1();
		
		A.C.field2 = 3; //static이니까 바로 불러올 수
		A.C.method2();
		
	}

}
