package chap09_2;

public class A {
	void m () {
		
	}
}
//class B extends A {} //이걸 생략하면
class C {
	void mc3() {
		A aa2 = new A() { //익명의 자식객체

			@Override
			void m() {
				// TODO Auto-generated method stub
				super.m();
			}
			
		};
	}
	
	A ab = new A();
	//A a = new B(); //얘가 오류뜸. 이때 쓰는 방법이
	
	A a = new A() {// 익명의 자식 객체. 중괄호;
		void mc1(A a) {}
		void mc2() {
			//A aa = new A();
			//mc1(aa);
			mc1(new A());//aa라는 변수를 이 밑에 말고 아무데도 쓸일 없으면 이렇게 쓰면됨
		}
	}; 
	
	
}