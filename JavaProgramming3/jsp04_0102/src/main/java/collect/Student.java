package collect;

public class Student {
	public enum Sex {MALE, FEMALE}
	public enum City {Seoul, Pusan}
	//enum 내부적으로 int임. 이름붙인것. 
	//클래스처럼 사용. 대문자로 이름 시작. 데이터타입으로 쓸 수 있음. 
	//static final 값 수정 못함
	
	//내부에만 쓰이게 private
	private String name;
	private int score;
	private Sex sex; //enum타입
	private City city;
	
	//다른 패키지나 클래스에서 쓸 수 있도록 public
	public Student(String name, int score, Sex sex) {
		super();
		this.name = name;
		this.score = score;
		this.sex = sex;
	}

	public Student(String name, int score, Sex sex, City city) {
		super();
		this.name = name;
		this.score = score;
		this.sex = sex;
		this.city = city;
	}

	
	//getters
	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public Sex getSex() {
		return sex;
	}

	public City getCity() {
		return city;
	}

	
	
	
	
	
}
