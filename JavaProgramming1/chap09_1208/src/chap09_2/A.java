package chap09_2;

public class A {
	//인스턴스멤버클래스
	class B {}
	//정적멤버클래스
	static class C {}
	
	
	
	//인스턴스 필드
		//	B field; 이렇게도o. 클래스B라는 데이터타입
	B field = new B();
	C field2 = new C();
	static String str = "test"; //얘네는 됨.
	static int x = 100;
	
	//인스턴스 메소드
	void method1() {
		B var1 = new B();
		C var2 = new C();
	}
	
	
	
	//정적 필드 초기화
		//static B field3 = new B(); 안됨.
	static C field4 = new C();
	
	//정적 메소드
	static void method2() {
		//B var1 = new B();
		C var2 = new C();
	}
	
}
