package chap06_1130;

public class Student {
	String name;
	String hakbun;
	Scores scores;
	

	
//생성자
	//source - generate constructor
	public Student(String name, String hakbun) {
		super();
		this.name = name;
		this.hakbun = hakbun;
	}

	public Student(String name, String hakbun, Scores scores) {
		super();
		this.name = name;
		this.hakbun = hakbun;
		this.scores = scores;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", hakbun=" + hakbun + ", scores=" +  scores + "]";
	}
	
	
//메소드
	//source- generate gettersetter
	public Scores getScores() {
		return scores;
	}
	public void setScores(Scores scores) {
		this.scores = scores;
	}
	
	
	void printAll() {
		System.out.println("이름:"+name+" 학번:"+hakbun+" 총점:"+ scores.sum() );
	}
	
	void updateScore(int kor, int math, int eng) {
		scores.setKor(kor);
		scores.setMath(math);
		scores.setEng(eng);
//	scores멤버필드에 private 붙이는 순간 아래 오류	
//		scores.kor = kor;
//		scores.math = math;
//		scores.eng = eng;
	}
}
