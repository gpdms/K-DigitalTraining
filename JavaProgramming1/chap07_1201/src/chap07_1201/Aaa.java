package chap07_1201;

public class Aaa {
	//static 멤버
	static int a;
	static void aaa() {
		System.out.println("Aaa");
//		System.out.println(b); 오류. static안에는 static만 들어감. 인스턴스멤버는 객체를 생성해야만 들어갈 수 있기 때문에.
	}
	
	//인스턴스 멤버-new로 객체 생성한 후 접근해야.
	int b;
	void bbb() {
		System.out.println(b);
	}
	
	//static멤버와 인스턴스멤버 같이 쓸수는 있지만 안씀.
}
