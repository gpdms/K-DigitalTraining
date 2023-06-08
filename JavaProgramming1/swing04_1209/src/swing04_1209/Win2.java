package swing04_1209;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

//이벤트리스너를 함께사용하는 방법
public class Win2 extends JFrame implements ActionListener{

	JButton jb = new JButton("클릭");
	Win2() {
		Container c = this.getContentPane();
		c.setLayout(null);
		jb.setBounds(100, 30, 80, 40);
		c.add(jb);
		this.setLocation(500, 400);
		this.setSize(400, 300);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jb.addActionListener(this);
	}
	public static void main(String[] args) {
		new Win2();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("클릭이벤트");
		
	}

}
