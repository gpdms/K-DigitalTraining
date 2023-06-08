package chap07_1202;

class A{}
class B extends A{}
class C extends A {}
class D extends B {}
class E extends C {}

public class PromoEx {

	public static void main(String[] args) {
		B b = new B();
		C c = new C();
		D d = new D();
		E e = new E();
		
		A a1 = new B();
		A a2 = new C(); //같은 얘기
		A a3 = d; // 같은얘기
		A a4 = e;
		
		B b1 = d;
		C c1 = e;

	}

}
