package chap09_1208;

public class A {
	A(){System.out.println("A 객체생성");}
	
	
	//인스턴스 멤버 클래스
	class B {
		//생성자
		B() {	System.out.println("B 객체생성");}
		//필드
		int field1;
		//static int field2; //인스턴스멤버클래스 안에 정적필드와메소드 불가. class B가 static이면 가능.
		
		//메소드
		void method1() {
			
		}
		//static void m() {}
	}
	
	
	
	//정적 멤버 클래스
	static class C {
		C() {System.out.println("C 객체 생성");}
		int field1;
		static int field2;
		void method1() {}
		static void method2() {}
	}
	
	
	
	
	void method() {
		//로컬 클래스
		class D {
			D() { System.out.println("D 객체생성");}
			int field1;
			//static int field2;
			void method1() {}
			//static void method2(){}
		}
		D d = new D();
		d.field1 = 3;
		d.method1();
	}
}