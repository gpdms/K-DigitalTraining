package chap13_2;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Win2 extends JFrame {
	JButton jb1 = new JButton("새 창");
	JFrame fr1;

	Win2() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());
		c.add(jb1);
		this.setSize(400, 300);
		this.setLocation(500, 500);
		this.setVisible(true);
		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fr1 = new Win3();
				fr1.setVisible(true);
			}
			
		});
		
	}

	public static void main(String[] args) {
		new Win2();
	}

}
