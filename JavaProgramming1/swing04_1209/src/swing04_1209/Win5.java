package swing04_1209;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

//익명객체로 만드는 방법
public class Win5 extends JFrame {

	int num;
	
	JButton jb = new JButton("클릭");
	Win5() {
		Container c = this.getContentPane();
		c.setLayout(null);
		jb.setBounds(100, 30, 80, 40);
		c.add(jb);
		//추가
		num= 10;
		
		jb.addActionListener(new ActionListener() {//익명객체 생성
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("클릭이벤트"+num);
			} 
		});
		
		
		this.setLocation(500, 400);
		this.setSize(400, 300);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Win5();

	}

}
