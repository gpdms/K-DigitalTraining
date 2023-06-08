package conceptEvent;
//1. implements 이벤트리스너 방법
public class Window2 implements MyListener{
	MyButton myButton;
	
	Window2() { //사용자 윈도우 만들기
		System.out.println("윈도우 만들다");
		MyButton mb = new MyButton();
		this.add(mb);
		//추가
		mb.addListener(this);
	}
	void add(MyButton myButton) {
		this.myButton = myButton;
		System.out.println("버튼 붙였다");
	}
	
	public static void main(String[] args) {
		new Window2();
	}
	//추가
	@Override
	public void action() {
		
	}

}
