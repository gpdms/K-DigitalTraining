package conceptEvent;
//익명객체로 만드는 방법
public class Window5 {
	MyButton myButton;
	
	Window5() { //사용자 윈도우 만들기
		System.out.println("윈도우 만들다");
		MyButton mb = new MyButton();
		this.add(mb);
		//추가
		mb.addListener(new MyListener() {//인터페이스 바로 부르는것 안되지만. 익명의 객체생성. (자식처럼만든것)

			@Override
			public void action() {
				
			} 
			
		});
	}
	void add(MyButton myButton) {
		this.myButton = myButton;
		System.out.println("버튼 붙였다");
	}
	
	public static void main(String[] args) {
		new Window5();
	}

}
