package package2;

import package1.A;

public class B extends A {
	public B() {
		super();
		this.field = "value";
		this.method();
		
		//A a = new A();  //오류.default접근제한자때문에.
		//a.field = "value"; 
		//a.method();		
	}
}
