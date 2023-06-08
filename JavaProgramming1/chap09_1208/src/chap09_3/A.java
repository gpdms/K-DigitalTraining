package chap09_3;

public class A {
	int field1;
	void method1() {}
	
	static int field2;
	static void method2() {}
	
	//인스턴스 클래스
	class B {
		void method() {
			field1 = 10;
			method1();
			
			field2 =11;
			method2();
		}
	}
	//정적 클래스
	static class C {
		void method() {
			//field1 = 10; //접근할수없음 
			//method1(); 
			
			field2 =11;
			method2();
		}
	}
}
