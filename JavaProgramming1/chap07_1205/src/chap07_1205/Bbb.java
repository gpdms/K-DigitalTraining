package chap07_1205;
class Aaa{
	//멤버필드
	int x = 10;
	//생성자
	Aaa(int x){
		this.x = x;
	}
	//메소드
	void printX() {
		System.out.println(x);
	}
}
public class Bbb extends Aaa {
	//생성자
	Bbb(int x) {
		super(x);	//자식이 생성될때 부모도 생성되어야. 맨 위에 있어야.
		printX();
	}
		
	//메소드 오버라이딩
	void printX() {
	}

	public static void main(String[] args) {
//		Aaa aa = new Aaa(); //상속 안하고 이렇게쓰면 안됨? main 메소드는 클래스Bbb에 포함된 애가 아님. 따로떨어질 수 있음.
//		Bbb bb = new Bbb(); //얘네 두개는 서로 관련이 없는 것. 따로 선언해봤자 뭐해.
		
		
	}

}
