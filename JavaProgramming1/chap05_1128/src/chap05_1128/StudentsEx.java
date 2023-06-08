package chap05_1128;

public class StudentsEx {

	public static void main(String[] args) {
		Students st = new Students();
		st.stuArr = new Student[10];
		st.init();
		System.out.println(st.searchStudent("03"));
		st.updateScore("03", 100, 100, 100);
		System.out.println(st.searchStudent("03"));

	}

}
