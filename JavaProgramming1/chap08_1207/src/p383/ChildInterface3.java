package p383;

public interface ChildInterface3 extends ParentInterface {

	@Override
	void method2(); //부모에 default메소드추가해놓고 상속 받아서 {}없앰. 그러면 얘를 상속받는애는 구현해야만함. 
	void method3();
}
