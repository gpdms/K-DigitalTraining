package chap07_1205;
class C{}
class B extends C{}

public class A {

	public static void main(String[] args) {
		C c = new B ();
		B b = (B) new C (); //cast연산자. 제약조건 있음.
	}

}
