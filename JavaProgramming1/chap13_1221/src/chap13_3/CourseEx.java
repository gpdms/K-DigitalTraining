package chap13_3;

public class CourseEx {

	public static void main(String[] args) {
		Course<Person> pc = new Course<Person>("일반인과정");
	
		pc.getStudents().add(new Person("일반인"));
		pc.getStudents().add(new Worker("직장인"));
		pc.getStudents().add(new Student("학생"));
		pc.getStudents().add(new HighStudent("고등학생"));
		//필드를 private로 해놔서 메소드를 통해 호출할 수 있음.
		//private없으면 pc.students.add() 가능.
		register(pc);
	}
	
	public static void register(Course<?> cs) {
		cs.print();
	}

}
