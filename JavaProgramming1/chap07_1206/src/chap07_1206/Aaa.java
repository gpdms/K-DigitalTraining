package chap07_1206;

abstract class Bbb {
	abstract void print(); //추상 메소드
}
abstract class Ccc extends Bbb {
	//상속 받은 애가 추상메소드 반드시 재정의 해야함!
	//재정의 안하려면 abstract 붙이면 됨. 
	abstract void printC();
}

class Ddd extends Ccc {

	@Override
	void printC() {
		
	}

	@Override
	void print() {
		
	}
}

public class Aaa {
	public static void main (String[] ar) {
//		Bbb bb = new Bbb(); //추상클래스는 객체 생성 안됨.
//		Ccc cc = new Ccc(); //상송받은애는 객체 생성할 수 있음.
	}
}
