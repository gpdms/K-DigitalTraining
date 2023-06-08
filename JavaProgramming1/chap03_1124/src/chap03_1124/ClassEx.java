package chap03_1124;

class Test {
	private int num = 10;

	void setNum (int number) {
		if (number >0) {
			num = number;
		} else {
			System.out.println("0보다 큰 수만 가능");
		}
		
	}
	void printStr() {
		System.out.println(num);
	}
}

public class ClassEx {

	public static void main(String[] args) {
		// 클래스

//		new Test().num = 20;
//		new Test().num = 40; //둘은 서로 다른 객체를 참조함.
//		Test t1 = new Test();
//		t1.num = 20; // 둘은 같음

		Test t1 = null;
		t1 = new Test();
		
		Test t2 = new Test();
		
//		t1.num = 20; private안붙이면 직접 접근가능.
		t1.setNum(-20); //private붙이면 메소드를 통해서만 접근가능.
		t1.printStr();
//		System.out.println(t1.num);
//		t2.setNum=40;
		t2.setNum(40);
//		System.out.println(t2.num);
		t2.printStr();
	}

}
