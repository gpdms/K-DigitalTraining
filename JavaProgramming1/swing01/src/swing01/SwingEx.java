package swing01;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingEx extends JFrame implements WindowListener, ActionListener {
//	JFrame jf = new JFrame("Swing 연습"); //윈도우창. JFrame상속받으면 필요없음.
	JButton jb = new JButton("클릭"); //버튼
	
	SwingEx() { //생성자를 만듦.
		Container cp = this.getContentPane(); //컨테이너 위에 붙여야하니까
		
		jb.setBounds(10, 10, 80, 50);//버튼 경계만드는것. (좌표X,좌표Y,너비,높이)
		cp.add(jb); //JFrame이 아니라 컨테이너 위에 붙여야함
		this.setLayout(null);
		this.setLocation(100, 100); //창 위치
		this.setSize(400, 300);//창 사이즈
//		jf.setTitle("Swing 연습"); //생성자 매개변수로줘도됨 
		this.setVisible(true); //보이게함.
		
		
		this.addWindowListener(this);
		jb.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new SwingEx();
		
		
	}

	//Window Listener
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("종료");
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("창 내리기");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("창 올리기");
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
//ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼 클릭");
	}

}
