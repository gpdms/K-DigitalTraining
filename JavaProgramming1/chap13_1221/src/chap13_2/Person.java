package chap13_2;

public class Person {
	private String str;

	public Person(String str) {
		super();
		this.str = str;
	}

	@Override
	public String toString() {
		return " " + str + " ";
	}
}


class Worker extends Person {

	public Worker(String str) {
		super(str);
	}
}


class Student extends Person {

	public Student(String str) {
		super(str);
	}}


class HighStudent extends Student {

	public HighStudent(String str) {
		super(str);
	}}