package swing04_1209;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Win4 extends JFrame {
	//중첩클래스로 만드는 방법
	class Listener implements ActionListener{

		int num;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("클릭이벤트"+ num) ;
			//외부클래스로 만들때와 차이점
			//내부에 있으니까 그냥 불러올 수ㅇ.외부클래스에 있을때는 생성자 만들어서 불러옴.
			
		}
		
	}

	JButton jb = new JButton("클릭");
	Win4() {
		Container c = this.getContentPane();
		c.setLayout(null);
		jb.setBounds(100, 30, 80, 40);
		c.add(jb);
		//추가
		jb.addActionListener(new Listener());
		this.setLocation(500, 400);
		this.setSize(400, 300);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	public static void main(String[] args) {
		new Win4();

	}

}
