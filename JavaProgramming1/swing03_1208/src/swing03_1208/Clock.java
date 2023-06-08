package swing03_1208;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Clock extends JFrame implements Runnable {
	private JLabel clabel = new JLabel();
	private SimpleDateFormat sf;
	private Thread thread;
	
	Clock() {
		Container c = this.getContentPane(); 
		this.setLocation(500, 300);
		this.setSize(400, 300);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //종료.
		
		
		//
		c.add(clabel);
		clabel.setBounds(100,100,400,100);
        clabel.setVisible(true);
        sf = new SimpleDateFormat("yyyy년MM월dd일 a hh:mm:ss");
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
        
	
	}
	
	public static void main(String[] args) {
		new Clock();

	}
	
	public void run() {
        while (true) {
           clabel.setText(sf.format(new Date()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){}
        }
    }

}
