package chap12_1213;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Win extends JFrame {
	JLabel lb = new JLabel("여기");
	JTextField tf = new JTextField("검색", 10);
	JButton bt = new JButton("클릭");

	Win() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());
		c.add(lb);
		c.add(bt);
		c.add(tf);
		//시계
		Thread th = new Thread() {
			public void run() {
				for (;;) {
			LocalDateTime now = LocalDateTime.now();
		lb.setText(now.getSecond()+"초");
		}
			}
		};
		th.start();
		
		bt.addActionListener((e123) -> {
			// 람다식. 메소드가 하나여야 가능. 메소드 2개이면 불가능.
				try {
					int num = Integer.parseInt(tf.getText());
				
					if(num >= 100) {
						throw new MyNumException("100 이상");
					} else {
						JOptionPane.showMessageDialog(null, num);
					}
					
				} catch(NumberFormatException e1){
					//모달
					JOptionPane.showMessageDialog(null, "숫자만 입력!");
//					System.out.println("숫자만 입력!");
				} catch(MyNumException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage()); //100이상 이라는 메시지 가져오기
				} finally {
					JOptionPane.showMessageDialog(null, "완료!");
				}
			}
			
		);
		
		//텍스트필드 텍스트 지우기
		tf.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				tf.setText(""); //공백으로 세팅해서 지운것처럼.
				
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		this.setLocation(500, 400);
		this.setSize(400, 300);
		this.setVisible(true);
		
	
		
	}
	public static void main(String[] args) {
		new Win();
	}

}
