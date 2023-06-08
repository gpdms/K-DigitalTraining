package conceptEvent;
//2.독립적인 클래스로 만드는 방법
class MyActionListener implements MyListener {

	@Override
	public void action() {
		
	}
	
}
public class Window3 {
	MyButton myButton;
	
	Window3() { //사용자 윈도우 만들기
		System.out.println("윈도우 만들다");
		MyButton mb = new MyButton();
		this.add(mb);
		//추가
		mb.addListener(new MyActionListener()); //객체생성
	}
	void add(MyButton myButton) {
		this.myButton = myButton;
		System.out.println("버튼 붙였다");
	}
	
	public static void main(String[] args) {
		new Window3();
	}

}
