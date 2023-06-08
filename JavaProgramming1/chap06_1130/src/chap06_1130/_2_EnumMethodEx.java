package chap06_1130;

public class _2_EnumMethodEx {

	public static void main(String[] args) {
		//name() 메소드
		Week today = Week.SUNDAY;
		String name = today.name();
		System.out.println(name);
		System.out.println();
		
		//ordinal() 메소드
		int ordinal = today.ordinal();
		System.out.println(ordinal);
		System.out.println();
		
		//compareTo() 메소드
		Week day1 = Week.MONDAY;
		Week day2 = Week.WEDNESDAY;
		int result1 = day1.compareTo(day2);
		int result2 = day2.compareTo(day1);
		System.out.println(result1);
		System.out.println(result2);
		System.out.println();
		
		//valueOf() 메소드
		Week strDay = Week.valueOf("FRIDAY");
		System.out.println(strDay==Week.FRIDAY);
		System.out.println();
		
//		if(args.length == 1) {
//			String strDay = args[0];
//			Week weekDay = Week.valueOf(strDay);
//			if(weekDay == Week.SATURDAY	|| weekDay == Week.SUNDAY) {
//				System.out.println("주말이군요");
//			} else {
//				System.out.println("평일이군요");
//			}
//		}

		//values() 메소드
		Week[] days = Week.values();
		for(Week day: days)	{
			System.out.println(day);
		}
	}

}
