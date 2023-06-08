package conceptEvent;
//3. 중첩클래스로 만드는 방법
public class Window4 {
	class MyActionListener implements MyListener {

		@Override
		public void action() {
			
		}
		
	}
	
	MyButton myButton;
	
	Window4() { //사용자 윈도우 만들기
		System.out.println("윈도우 만들다");
		MyButton mb = new MyButton();
		this.add(mb);
		//추가
		mb.addListener(new MyActionListener());
	}
	void add(MyButton myButton) {
		this.myButton = myButton;
		System.out.println("버튼 붙였다");
	}
	
	public static void main(String[] args) {
		new Window4();
	}

}
