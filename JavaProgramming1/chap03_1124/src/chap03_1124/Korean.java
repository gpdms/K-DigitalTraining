package chap03_1124;

public class Korean {
	String nation = "대한민국";
	String name;
	String ssn;
	
	public Korean (String name, String ssn) {
		this.name = name;
		this.ssn = ssn;
		//필드명이 같으니까 무슨name을 가리키는건지 컴파일러가 알 수 없음. 그래서 this를 붙임.
	}
	
	public Korean (String name, String ssn, String nation) {
		this.name = name;
		this.ssn = ssn;
		this.nation = nation;
	}
}
