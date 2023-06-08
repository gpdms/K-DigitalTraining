package p381;

public interface MyInterface {
	public void method1();
	default void method2() { //시간이 흘러 추가
		System.out.println("method2()");
	};  
}
