package chap02;

public class StudentEx {

	public static void main(String[] args) {
		String name = "홍길동"; //지역변수. main메소드 내에서만 사용가능 cf)멤버필드
		System.out.println(name); 
		
		Student s1 = new Student (); //main()메소드에서 Student 객체 생성. s1은 멤버필드.
		System.out.println(s1.name); //지역변수name이 아니라 객체가 생성돼야 사용할 수 있는.
		s1.name = "김사랑";
		System.out.println(s1.name);
		s1.print(); 
		Student s2 =  new Student(); // Student 클래스는 하나지만 new 연산자를 사용한 만큼 객체가 메모리에 생성.
		System.out.println(s2.name); //s1과 s2는 다름. 디자인설계가 같을뿐. 완전히 독립된 서로 다른 객체임.
	}

}
