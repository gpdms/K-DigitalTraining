package chap05_1128;

public class StudentEx {

	public static void main(String[] args) {

		//객체생성. 클래스가 일종의 데이터타입인 셈. 메소드를 가지고 있는.
		Student stu;
		stu = new Student(); //이렇게 써도됨. 
		//오류뜨는이유:생성자를 하나라도 만들면 컴파일러는 기본생성자를 지원해주지 않는다. 만들어써야.
		
		stu.name = "홍";
		stu.hakbun = "202201";
		stu.address = "서울 마포구"; 
		//이렇게쓰면 private붙이는 순간 이 클래스 내부에만 쓸수있기 때문에 여기서 쓸수없음.
		
		Student stu2 = new Student("홍", "202201", "서울 마포구"); //이렇게 써야!
		//Student stu3 = new Student("202201", "홍", "서울 마포구"); //문법오류는 아니지만 의미상 치명적인오류.
		stu2.kor = 90;
		stu2.math=89;
		stu2.eng=97;
		
		stu2.avg(); //실행해도 결과볼수없음.
		double dd = stu2.avg(); //객체.점.메소드: 객체가 주소값을 가지고 있음. 주소를따라가서 데이터를 가져옴.
		System.out.println(dd); 
	}

}
