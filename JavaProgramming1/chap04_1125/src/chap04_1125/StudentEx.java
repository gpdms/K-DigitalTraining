package chap04_1125;

import java.util.Scanner;

public class StudentEx {

	public static void main(String[] args) {
		// Student st = new Student(); 값을줘야함. 기본생성자를 현재 지원하지 않음. 만들지 않았기 때문에.
//		Student st = new Student("홍길동", "2020", "서울", 89, 90, 60);
//		System.out.println(st.sum());
//		st.printSum(); //프린트를 메소드로 만들어서 쓸수도.
//		System.out.println(st.avg());
//		st.printAvg();

		Student[] stu = new Student[3];

		stu[0] = new Student("홍길동", "202201", "서울");
		stu[1] = new Student("김길동", "202202", "경기");
		stu[2] = new Student("이길동", "202203", "인천");

		Scanner scan = new Scanner(System.in);
		
		for (int i = 0; i < stu.length; i++) {
			System.out.print(stu[i].name + "의 국어 점수 입력>");
			stu[i].kor = scan.nextInt();
			System.out.print(stu[i].name + "의 수학 점수 입력>");
			stu[i].math = scan.nextInt();
			System.out.print(stu[i].name + "의 영어 점수 입력>");
			stu[i].eng = scan.nextInt();
		} 

		System.out.println("국어" + "\t" + "수학" + "\t" + "영어");
		for (int j = 0; j < stu.length; j++) {

			System.out.println(stu[j].kor + "\t" + stu[j].math + "\t" + stu[j].eng);
		}
		
		
		System.out.println("수정할 사람이름>");
		String stname = scan.next();
		
	
		for(int i=0; i<stu.length; i++ ) {
		if (stname.equals(stu[i].name)) {
			System.out.println("수정할 과목명>");
			String crsname = scan.next();
			if (crsname.equals("국어")) {
				System.out.println("점수입력>");
				stu[i].kor= scan.nextInt();
				
				System.out.println("국어" + "\t" + "수학" + "\t" + "영어");
				for (int j = 0; j < stu.length; j++) {
					System.out.println(stu[j].kor + "\t" + stu[j].math + "\t" + stu[j].eng);
				}
			} else if (crsname.equals("수학")) {
				System.out.println("점수입력>");
				stu[i].math= scan.nextInt();
				System.out.println("국어" + "\t" + "수학" + "\t" + "영어");
				for (int j = 0; j < stu.length; j++) {
					System.out.println(stu[j].kor + "\t" + stu[j].math + "\t" + stu[j].eng);
				}
			} else if (crsname.equals("영어")) {
				System.out.println("점수입력>");
				stu[i].eng= scan.nextInt();
				System.out.println("국어" + "\t" + "수학" + "\t" + "영어");
				for (int j = 0; j < stu.length; j++) {
					System.out.println(stu[j].kor + "\t" + stu[j].math + "\t" + stu[j].eng);
				}
			}	
		
		}
		}
		scan.close();
	}

}
