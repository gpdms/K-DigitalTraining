package chap09_4;

public class Outter {
	String field = "Outter field";
	
	void method() {
		System.out.println("Outter method");
	}
	
	
	class Nested {
		String field = "Nested-field";
		void method() {
			System.out.println("Nested-method");
		}
	
		void print() {
			System.out.println(this.field); //this.field는 Nested-field
			this.method();
			System.out.println(Outter.this.field); //클래스이름.this는 외부클래스의 필드
			Outter.this.method();
		}
	}
}
