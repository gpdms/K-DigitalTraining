package chap07_1202;

public class ChildEx {

	public static void main(String[] args) {
		Parent pa = new Child(); //부모클래스 변수명 = new 자식클래스 가능.
//		Child ch = new Parent(); 반대로는 안됨.
		
		pa.m1();
		pa.m2();
//		pa.m3(); 안됨.
	}

}
