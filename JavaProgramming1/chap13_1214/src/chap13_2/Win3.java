package chap13_2;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Win3 extends JFrame {
	JButton jb1 = new JButton("닫기");
	JFrame fr1;

	Win3() {
		
		this.setTitle("새 창");
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());
		c.add(jb1);
		this.setSize(400, 300);
		this.setLocation(500, 500);
		this.setVisible(false);
		jb1.addActionListener(new ActionListener( ) {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});

		
	}

	public static void main(String[] args) {
		new Win3();
	}

}
