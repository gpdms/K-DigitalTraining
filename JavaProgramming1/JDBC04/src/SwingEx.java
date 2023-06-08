import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;

//상속
public class SwingEx extends JFrame implements ActionListener {
	JButton sel = new JButton("검색");
	JButton del = new JButton("삭제");
	
	StudentDB stu; //DB랑 연결
	
	//생성자
	SwingEx() throws ClassNotFoundException, SQLException {
		stu = new StudentDB(); //위에써도되고 여기에써도되고
		
		this.setVisible(true);
		this.setLocation(600, 300);
		this.setSize(400, 300);
		
		Container con = this.getContentPane();
		con.setLayout(null);
		con.add(sel);
		con.add(del);
		sel.setBounds(50, 50, 80, 50);
		del.setBounds(140, 50, 80, 50);
		
		sel.addActionListener(this); //버튼을 누르면 아래 override메소드를 실행시킨다.
		del.addActionListener(this);
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new SwingEx();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sel) {
//		System.out.println("검색 버튼 클릭");
			try {
				stu.selectAll();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == del) {
//			System.out.println("삭제 버튼 클릭");
			try {
				stu.delete(9);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}

}
