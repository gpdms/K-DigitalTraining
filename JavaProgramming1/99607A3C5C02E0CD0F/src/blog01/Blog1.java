package blog01;

import java.util.Calendar;
import javax.swing.JFrame;

public class Blog1 extends JFrame{
	public Blog1() {
		// TODO �ڵ� ������ ������ ����
		set();

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
	
			System.out.println(year+"�� "+month+"�� "+date+"�� "+ampm+hour+"�� "+min+"�� "+sec+"."+msec+"��");//�������� Ȯ���� ���
			try { //Ʈ���� 
				Thread.sleep(100);//0.1��
		    } catch(Exception e) {} //����ó��
		}//while�� ��
	}//gettime()��

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
		new Blog1();
	}

	
}
