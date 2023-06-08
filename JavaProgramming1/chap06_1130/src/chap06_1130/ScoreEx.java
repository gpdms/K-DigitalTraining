package chap06_1130;

public class ScoreEx {

	public static void main(String[] args) {
		Student stu = new Student("홍", "01"); //생성자를 하나도 안만들었기 때문에 기본생성자. 생성자를 하나라도 만들면 컴파일러는 기본 생성자를 추가하지 않음.
		
		
//		stu.name = "홍";
//		stu.hakbun = "01";
//		Scores sco = new Scores (89, 91, 88);
//		sco.kor = 89;
//		sco.math = 91;
//		sco.eng = 88;
		
//		stu.scores = sco; //주입
//		stu.setScores(sco);
		
//		Scores sco = new Scores (89, 91, 88);
//		stu.setScores(sco); 둘 합친게
		stu.setScores(new Scores(89,91, 88));
//		System.out.println(stu);
		stu.scores.printSum();
		stu.printAll();
		
		System.out.println("업데이트");
		stu.updateScore(90, -1, 90);
		stu.printAll();
	}

}
