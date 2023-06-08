package chap06_1130;

import java.util.Calendar;

public class _1_EnumWeekEx {

	public static void main(String[] args) {
		Week today = null;
		
		Calendar cal = Calendar.getInstance(); //Calendar 제공해주는것 불러다씀. 싱글톤 getInstance()
		int week = cal.get(Calendar.DAY_OF_WEEK);
		
		switch(week) {
		case 1:
			today = Week.SUNDAY; break;
			
		case 2:
			today = Week.MONDAY; break;
		case 3:
			today = Week.TUESDAY; break;
			
		case 4:
			today = Week.WEDNESDAY; break;
			
		case 5:
			today = Week.THRUSDAY; break;
			
		case 6:
			today = Week.FRIDAY; break;
		case 7:
			today = Week.SATURDAY; break;
		}
		
		System.out.println("오늘 요일:" + today);
		 System.out.println(Week.FRIDAY);
		
		if(today == Week.SUNDAY) {
			System.out.println("일요일에는 축구를 합니다");
		} else {
			System.out.println("열심히 자바 공부합니다");
		}

	}

}
