package chap09_5;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonEx extends JFrame implements ActionListener{
	Button bt; //= new Button("연습");아래생성자에 복붙하고 변수선언만하기. //오류뜨니까 Button클래스 가서 생성자 만들기. 글자안뜸:생성자에super넣어주기.
	JButton bt1 = new JButton("클릭");
//	JLabel lb = new JLabel("여기에");
	
	ButtonEx() {
		Container c = this.getContentPane();
		bt = new Button("연습", c);
		c.setLayout(null);
		bt.setBounds(100, 30, 80, 50);
		c.add(bt);
		
//		lb.setBounds(100, 200, 80, 90);
//		c.add(lb);		
		
		bt1.setBounds(200, 30, 80, 50);
		c.add(bt1);
		
		bt.addActionListener(this);
		
		this.setLocation(600, 500);
		this.setSize(400, 300);
		this.setVisible(true);
	}

	public static void main(String[] args) {
//		Button btn = new Button();
//		
//		btn.setOnClickListener(new CallListener());
//		btn.touch();
//		
//		btn.setOnClickListener(new MessageListener());
//		btn.touch();

		new ButtonEx();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		bt.setOnClickListener(new CallListener()); //Button클래스의 메소드
		bt.touch();
		
	}

}
