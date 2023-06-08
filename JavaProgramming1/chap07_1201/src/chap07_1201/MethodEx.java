package chap07_1201;

public class MethodEx {
// 메소드 오버로딩이 아닌것
//	void method() {}
//	int method() { return 0;}
	//리턴타입은 무관. so 두 메소드는 오버로딩 만들 수 없음.
	
	void method(int a) {}
	int method() { return 0;}
	//이러면 오버로딩 됨.
	
	
	
	
	public static void main(String[] args) {
		System.out.println(10);
		System.out.println(3.14);
		System.out.println("연습");
		//오버로딩해준것.

	}

}
