package p381;

//신규업무인셈. 기존 업무 잘돌아가던거 그대로 놔두고 신규업무추가.
public class MyClassB implements MyInterface{

	@Override
	public void method1() {
		System.out.println("MyClassB-method1() 실행");
		
	}

	@Override
	public void method2() { //재정의
		
		MyInterface.super.method2();
	}
	
}
