package chap06_1130;

public class _4_Bbb {
	
	int a;
	
	//메소드
	
	
	//리턴타입 없음. 매개변수 없음. 실행만 하는 것.
	void bbb() {
		System.out.println(a);
	}
	
	//리턴타입 있음. 매개변수 없음.
	int ccc() {
		 return a+10;
	}
	
	//리턴타입 없음. 매개변수 있음.
	void add (int a) {
		this.a = a*10;
//		System.out.println(this.a);
		bbb(); //같은 기능이니까 얘를 가져옴. 나중에 수정생기면 자동수정되니까.
		this.bbb(); 
	}
	
	//리턴타입 있음. 매개변수 있음.
	int eee (int a) {
		return 20*a;
	}
}
