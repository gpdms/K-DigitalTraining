package p383;

public interface ChildInterface2 extends ParentInterface {

	@Override
	default void method2() { //재정의
		
	}
	void method3();
}
