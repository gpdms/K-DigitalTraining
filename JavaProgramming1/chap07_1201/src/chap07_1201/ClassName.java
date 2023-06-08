package chap07_1201;

public class ClassName {
	//인스턴스 필드와 메소드
	int field1;
	void method1() {}
	//정적 필드와 메소드
	static int field2;
	static void method2() {}
	
	static {
//		field1 = 10; 인스턴스이기 때문에 안됨
//		method();
		field2 = 0;
		method2();
	}
	
	
		static void method3() {
//		field1 = 10;
//		method1();
		field2 = 10;
		ClassName.method2(); //클래스명.멤버 이렇게 써도됨.
		
		//객체 생성하면 쓸수있음.
		ClassName obj = new ClassName();
		obj.field1 = 10;
		obj.method1();
		
	}
	
	
}
