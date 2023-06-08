package swing03_1208;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WinEx extends JFrame {

	JButton jb1 = new JButton("1");
	JButton jb2 = new JButton("2");
	JButton jb3 = new JButton("3");
	JButton jb4 = new JButton("4");
	JButton jb5 = new JButton("5");
	JButton jb6 = new JButton("6");
	JButton jb7 = new JButton("7");
	JButton jb8 = new JButton("8");
	
	JButton jb11 = new JButton("1");
	JButton jb12 = new JButton("2");
	JButton jb13 = new JButton("3");
	JButton jb14 = new JButton("4");
	JButton jb15 = new JButton("5");
	JButton jb16 = new JButton("6");
	JButton jb17 = new JButton("7");
	JButton jb18 = new JButton("8");
	
	WinEx() {
		Container c = this.getContentPane(); //컨테이너는 전체에서 하나임.
		this.setLocation(500, 300);
		this.setSize(400, 300);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //종료.
		
		
		//레이아웃
		JPanel jp1 = new JPanel(); //컨테이너 위에 붙는 패널. 여러개 가능.
		jp1.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15)); //FlowLayout:왼쪽에서 오른쪽으로 배치 
		c.add(jp1, BorderLayout.NORTH); // BorderLayout:North, South, East, West, Center가 있음.
		
		//패널에 버튼 붙이기
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		jp1.add(jb4);
		jp1.add(jb5);
		jp1.add(jb6);
		jp1.add(jb7);
		jp1.add(jb8);
		
		JPanel jp2 = new JPanel();
		jp2.setLayout(new GridLayout(4, 2, 10, 10)); //4행, 2열 , 좌우간격, 상하간격
		c.add(jp2, BorderLayout.CENTER);
		jp2.add(jb11);
		jp2.add(jb12);
		jp2.add(jb13);
		jp2.add(jb14);
		jp2.add(jb15);
		jp2.add(jb16);
		jp2.add(jb17);
		jp2.add(jb18);
	}
	
	public static void main(String[] args) {
		new WinEx();

	}

}
