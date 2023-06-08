package swing03_1208;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Practice extends JFrame {
		JLabel lb1 = new JLabel();
		JLabel lb2 = new JLabel();
		JLabel lb3 = new JLabel();
		JLabel lb4 = new JLabel();
		
		JTextField tf1 = new JTextField();
		JTextField tf2 = new JTextField();
		JTextField tf3 = new JTextField();
		JTextField tf4 = new JTextField();
	
	Practice() {
		Container c = this.getContentPane();
		this.setVisible(true);
		this.setLocation(500, 300);
		this.setSize(400, 300);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		c.setLayout(new GridLayout(4, 2, 20, 30));
		c.add(lb1);
	}
	
	
	public static void main(String[]args) {
		new Practice();
	}
}
