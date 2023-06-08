package chap09_1209;

public class Parent {
	void parentMethod() {}
}

class Child extends Parent {
	
}

class A {
	//A클래스의 필드
	Parent field = new Parent() { //중괄호; 하면서 자식객체로 생성.

		@Override
		void parentMethod() {
			// TODO Auto-generated method stub
			super.parentMethod();
		}
		
	};
	//메소드
	void method() {
		Parent localVAr = new Child(); //필드의 다형성. 
	}
	
	void method1(Parent parent) {
		
	}
	void method2() {
		method1(new Parent() {
			//재정의
			@Override
			void parentMethod() {
				// TODO Auto-generated method stub
				super.parentMethod();
			} //중괄호로 넣어서 익명자식객체생성해서 매개변수로 넣음.
			
		});
	}
}