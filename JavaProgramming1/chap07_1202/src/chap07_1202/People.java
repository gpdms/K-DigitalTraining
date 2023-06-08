package chap07_1202;

public class People {
	public String name;
	public String ssn;
	
	People(){} //기본생성자가 있으면 super생략해도 됨. 기본생성자 없으면 super꼭.
	public People(String name) {
		this.name = name;
	}
	
	public People(String name, String ssn) {
		this.name = name;
		this.ssn = ssn;
	}
}
