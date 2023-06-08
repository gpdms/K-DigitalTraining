
public class MyClassEx {

	public static void main(String[] args) {
//		RemoteControl rc= null; nullPointer오류 발생시킴.
		RemoteControl rc = new Television(); //구현객체
//		RemoteControl rc = new RemoteControl() {} 여기에 오버라이드. 익명의객체
		
		MyClass mc = new MyClass(rc); //기본생성자 없음. 기본생성자만들필요없음.
//		MyClass mc = new MyClass(new Television()); //이렇게해도됨.매개변수의 다형성
		mc.methodA();
		mc.methodB(rc); //nullPointer오류.

	}

}
