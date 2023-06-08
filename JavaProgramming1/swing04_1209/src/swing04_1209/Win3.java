package swing04_1209;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

//외부클래스로 만드는 방법
class Listener implements ActionListener {
	
	int num;
	//생성자
	Listener(int num) {
		this.num = num;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("클릭이벤트"+num);	
	}
	
}
public class Win3 extends JFrame {

	JButton jb = new JButton("클릭");
	Win3() {
		Container c = this.getContentPane();
		c.setLayout(null);
		jb.setBounds(100, 30, 80, 40);
		c.add(jb);
		//추가
		jb.addActionListener(new Listener(10)); //생성자에 전달.
		
		this.setLocation(500, 400);
		this.setSize(400, 300);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Win3();

	}

}
