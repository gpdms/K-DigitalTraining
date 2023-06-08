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
		// TODO 자동 생성된 생성자 스텁
		set();
		setlabel();
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
	
			one= (year+"."+month+"."+date+"."+sday+" day");//one이라는 문자열에 저장
			two=(ampm+" "+hour+":"+min+":"+sec+" sec");//two라는 문자열에 저장
			//System.out.println(year+"년 "+month+"월 "+date+"일 "+ampm+hour+"시 "+min+"분 "+sec+"."+msec+"초");//나오는지 확인차 사용
			first.setText(one);//first의 내용을 one(string)으로 설정한다
			second.setText(two);//second의 내용을 two(string)으로 설정한다.
			add(first);//first를 프레임에 추가한다.
			add(second);//second를 프레임에 추가한다.
			try { //트라이 
				Thread.sleep(100);//0.1초
			
		    } catch(Exception e) {} //예외처리
		}//while문 끝
	}//gettime()끝
public void setlabel() {//시간라벨 설정,알람 설명 라벨
	
		second.setOpaque(true);//라벨을 불투명하게 설정
		second.setBackground(new Color(0,0,0,0));//백그라운드를 0,0,0,0으로 설정한다.
		second.setBounds(85,170,300,50);//위치와 크기를 설정한다.
		second.setForeground(Color.black);//글자색을 하얀색으로 설정한다.	
		first.setOpaque(true);//라벨을 불투명하게 설정
		first.setBackground(new Color(0,0,0,0));//백그라운드를 0,0,0,0으로 설정한다.
		first.setBounds(60,120,320,50);//위치와 크기를 설정한다.
		first.setForeground(Color.black);//글자색을 하얀색으로 설정한다.
	}
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
		new Blog3();
	}

	
}
