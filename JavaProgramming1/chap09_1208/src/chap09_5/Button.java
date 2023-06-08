package chap09_5;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Button extends JButton {
	OnClickListener listener; //인터페이스명 변수;
	JLabel lb = new JLabel("여기에"); //버튼을 만들때 레이블도 같이 딸려가게
	
	Button(String str, Container c){
		super(str); //부모의 생성자에다가 문자열 넣기
		this.setBounds(100, 30, 80, 50); // bt.setBounds 복사해옴.
		lb.setBounds(100, 200, 80, 90); //버튼만들어질때 레이블도 같이
		c.add(lb);	
	}
	
	void setOnClickListener(OnClickListener listener) { //인터페이스타입이지만 실제론 구현이된애가 들어가야
		this.listener = listener;
	}
	
	void touch() {
		lb.setText(listener.onClick());//listener가 가지고 있는 onClick()이 실행됨. 레이블에 텍스트 붙임.
	}
	
	interface OnClickListener{
		String onClick();
	}
	
}
