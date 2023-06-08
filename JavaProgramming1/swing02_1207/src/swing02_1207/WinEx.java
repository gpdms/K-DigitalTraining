package swing02_1207;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WinEx extends JFrame implements ActionListener {
//		JFrame jf = new JFrame(); //필드로 만들면 좋을것. extends JFrame넣으면 없애도됨.
		
		//컴포넌트:이미 만들어져있어 제공해주는것.
		JTextField tf = new JTextField(); 
		JButton jb = new JButton("삭제");
		JTextArea ta = new JTextArea();
//DB연동
//		StudentDB stu = new StudentDB(); 이렇게 못함. 필드선언만하고 생성자에서 해줘야
		StudentDB stu;
		
	
		WinEx() throws ClassNotFoundException, SQLException {
			stu = new StudentDB();
			
			this.setVisible(true);
			this.setSize(600, 400);
			this.setLocation(500,300);
			
			//컨테이너 만들어서 텍스트필드 붙여줌.
			Container c = this.getContentPane();
			c.add(tf);
			c.setLayout(null);
			tf.setBounds(100, 0, 80, 30);
			
			//버튼
			jb.setBounds(200, 0, 80, 30);
			c.add(jb);
			
			//text area
			c.add(ta);
			ta.setBounds(100, 100, 300, 200);
			
			//버튼에 액션
			jb.addActionListener(this); //this는 JFrame을 의미.
		}
		
		
		
		
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		생성자 만들어서 옮김
//		JFrame jf = new JFrame();
//		jf.setVisible(true);
//		jf.setSize(600, 400);
		new WinEx();
		
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			stu.delete(tf.getText()); //버튼 누르면 삭제
			String str = stu.selectAll(); //문자열로
			ta.setText(str);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}
