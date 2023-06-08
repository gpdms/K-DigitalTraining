package project1;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Seat extends JFrame {
	JFrame frame = new JFrame();
	JButton[] button = new JButton[34];
	
	
	Seat() {
	frame.setVisible(true);
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
	}
	
	
	
	
	public static void main(String[] args) {
		new Seat();
		
	}
	
	
	
	

}
