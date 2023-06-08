package conceptEvent;

public class Window {
	MyButton myButton;
	
	Window() { //사용자 윈도우 만들기
		System.out.println("윈도우 만들다");
		MyButton mb = new MyButton();
		this.add(mb);
	}
	void add(MyButton myButton) {
		this.myButton = myButton;
		System.out.println("버튼 붙였다");
	}
	
	public static void main(String[] args) {
		new Window();
	}

}
