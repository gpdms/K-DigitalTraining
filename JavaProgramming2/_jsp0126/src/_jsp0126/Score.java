package _jsp0126;

public class Score {
	//필드
	private String name;
	private int kor;
	
	//생성자
	public Score(String name, int kor) {
		super();
		this.name = name;
		this.kor = kor;
	}

	//getter setter
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getKor() {
		return kor;
	}


	public void setKor(int kor) {
		this.kor = kor;
	}
	
	
	
	
}
