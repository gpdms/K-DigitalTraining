package chap09_3;

public class Outter {
	public void method1(int arg) { //자바7에서는 int arg 앞에 final붙여줘야.
		int localVariable = 1; //자바7에서는 앞에 final
		//arg = 100; //final때문에 수정 못함. 로컬클래스에 사용되는 매개변수와 로컬변수는 모두 final.
		//localVariable = 100;
		
		//메소드 안 클래스. 로컬클래스.
		class Inner {
			public void method() {
				int result = arg + localVariable;
			}
		}
		
	
		
	}
}
