package chap07_1205;

public class ChildEx {

	public static void main(String[] args) {
		Parent parent = new Child(); //필드의 다형성
		parent.method1();
		parent.method2();
		
//		parent.field2 = "data2";
//		parent.method3();
		
		Child child = (Child) parent; //강제 형변환
		child.field2 = "yyy";
		child.method3();
		
		Parent p = new Parent();
//		Child c = (Child) p; //먼저 자식타입이 부모타입으로 변환되어 있는 상태에서만 가능.
		boolean result = p instanceof Child;
		if(result) {
			Child c = (Child) p;
			System.out.println("성공");
		} else {
			System.out.println("안됩니다");
		}
	}

}
