package blog01;

import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Blog3 extends JFrame{
	private String one;
	private String two;
	private JLabel first = new JLabel();
	private JLabel second = new JLabel();

	public Blog3() {
		// TODO �ڵ� ������ ������ ����
		set();
		setlabel();
		timeget();
	}
	public void timeget() {//�ð�����
		String sday=null;//���������� ���� ������ ���ڷ� ����
		while(true) {//������ ����
			
			Calendar t=Calendar.getInstance();
			int year = t.get(Calendar.YEAR); //������ �޾ƿ´�
			int month = t.get(Calendar.MONTH);//���� �޾ƿ´�
			int date = t.get(Calendar.DATE);//���� �޾ƿ´�
			int amPm = t.get(Calendar.AM_PM);//����/���ĸ� �޾ƿ´�
			int hour = t.get(Calendar.HOUR);//�ø� �޾ƿ´�
			int min = t.get(Calendar.MINUTE);//���� �޾ƿ´�
			int sec = t.get(Calendar.SECOND);//�ʸ� �޾ƿ´�
			int msec = t.get(Calendar.MILLISECOND);//msec�� ���� but.�������� ����.
			String ampm=amPm==Calendar.AM? "PM":"AM";//���ؼ� pm�̳� am�� ampm�� ����
			int day= t.get(Calendar.DAY_OF_WEEK);//������ ���������� ����1=��~7����
	
			one= (year+"."+month+"."+date+"."+sday+" day");//one�̶�� ���ڿ��� ����
			two=(ampm+" "+hour+":"+min+":"+sec+" sec");//two��� ���ڿ��� ����
			//System.out.println(year+"�� "+month+"�� "+date+"�� "+ampm+hour+"�� "+min+"�� "+sec+"."+msec+"��");//�������� Ȯ���� ���
			first.setText(one);//first�� ������ one(string)���� �����Ѵ�
			second.setText(two);//second�� ������ two(string)���� �����Ѵ�.
			add(first);//first�� �����ӿ� �߰��Ѵ�.
			add(second);//second�� �����ӿ� �߰��Ѵ�.
			try { //Ʈ���� 
				Thread.sleep(100);//0.1��
			
		    } catch(Exception e) {} //����ó��
		}//while�� ��
	}//gettime()��
public void setlabel() {//�ð��� ����,�˶� ���� ��
	
		second.setOpaque(true);//���� �������ϰ� ����
		second.setBackground(new Color(0,0,0,0));//��׶��带 0,0,0,0���� �����Ѵ�.
		second.setBounds(85,170,300,50);//��ġ�� ũ�⸦ �����Ѵ�.
		second.setForeground(Color.black);//���ڻ��� �Ͼ������ �����Ѵ�.	
		first.setOpaque(true);//���� �������ϰ� ����
		first.setBackground(new Color(0,0,0,0));//��׶��带 0,0,0,0���� �����Ѵ�.
		first.setBounds(60,120,320,50);//��ġ�� ũ�⸦ �����Ѵ�.
		first.setForeground(Color.black);//���ڻ��� �Ͼ������ �����Ѵ�.
	}
	public void set() {
		setTitle("Y_Clock Test"); // Ÿ��Ʋ
		setSize(400, 300); // ���ο��� ���� ���� ũ�� ������
		setLocationRelativeTo(null);// ȭ�� ����� â�� ����
		setResizable(false);//������������� ����Ұ�
		setLayout(null);//���̾ƿ� ��������
		setVisible(true); // ���̰�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ���������� jframe�� ����ǰ� ����
		
	}
	public static void main(String[] args) { 
		new Blog3();
	}

	
}
