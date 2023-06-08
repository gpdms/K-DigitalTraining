package blog01;

import java.util.Calendar;
import javax.swing.JFrame;

public class Blog1 extends JFrame{
	public Blog1() {
		// TODO 자동 생성된 생성자 스텁
		set();

		timeget();
	}
	public void timeget() {//시간관련
		String sday=null;//정수형으로 받은 요일을 문자로 변경
		while(true) {//무조건 실행
			
			Calendar t=Calendar.getInstance();
			int year = t.get(Calendar.YEAR); //연도를 받아온다
			int month = t.get(Calendar.MONTH);//월을 받아온다
			int date = t.get(Calendar.DATE);//일을 받아온다
			int amPm = t.get(Calendar.AM_PM);//오전/오후를 받아온다
			int hour = t.get(Calendar.HOUR);//시를 받아온다
			int min = t.get(Calendar.MINUTE);//분을 받아온다
			int sec = t.get(Calendar.SECOND);//초를 받아온다
			int msec = t.get(Calendar.MILLISECOND);//msec를 리턴 but.적용하지 않음.
			String ampm=amPm==Calendar.AM? "PM":"AM";//비교해서 pm이나 am을 ampm에 저장
			int day= t.get(Calendar.DAY_OF_WEEK);//요일을 정수형으로 리턴1=일~7은토
	
			System.out.println(year+"년 "+month+"월 "+date+"일 "+ampm+hour+"시 "+min+"분 "+sec+"."+msec+"초");//나오는지 확인차 사용
			try { //트라이 
				Thread.sleep(100);//0.1초
		    } catch(Exception e) {} //예외처리
		}//while문 끝
	}//gettime()끝

	public void set() {
		setTitle("Y_Clock Test"); // 타이틀
		setSize(400, 300); // 메인에서 가로 세로 크기 가져옴
		setLocationRelativeTo(null);// 화면 가운데서 창이 나옴
		setResizable(false);//정해진사이즈에서 변경불가
		setLayout(null);//레이아웃 설정가능
		setVisible(true); // 보이게
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 안정적으로 jframe이 종료되게 해줌
		
	}
	public static void main(String[] args) { 
		new Blog1();
	}

	
}
