package chap05_1128;

public class StudentArray {
	static Student[] stuArr;
	public static void main(String[] args) {
		//1차원 배열 선언. 안에 들어있는 값은 Student 객체가 들어감.
		stuArr = new Student[10];
		//Student[] stuArr = new Student[3];
									//객체생성. 방만 만든상태. stack영역에 변수만 생김. 힙영역에 없어.
		//System.out.println(stuArr[0].name); //오류
		//stuArr[0].name = "홍"; //문법오류는 아니지만, 방이없기때문에
		
		//이렇게 3개를 만들어야.
		//stuArr[0] = new Student();
		
		//insertStudent("홍", "01","서울",89,97,67); //오류뜨는이유: 클래스 내에 객체 생성된적이 없음. 아래메소드에 static붙여줘야.
		//System.out.println(stuArr[0]);
		for (int i=0; i<stuArr.length; i++) {
			insertStudent(i, "홍"+i, "0"+(i+1),"서울",89+i,97+i,67+i);
		}
		for (Student stu: stuArr) {
			System.out.println(stu);
		}
		
		//검색하기
		for (int i=0; i<stuArr.length; i++) {
			if(stuArr[i].hakbun.equals("03")) {
				 System.out.println();
				 System.out.println(stuArr[i]);
			}
		}
		//메소드 만들고 호출
		searchStudent("03");
		//업데이트국어 메소드 만들고 호출
		updateKor("03", 100);
		searchStudent("03");
		//업데이트모든점수 메소드 만들고 호출
		updateScore("03", -1, 100, -1);
	}
	
	//업데이트 국어점수
	static void updateKor(String hakbun, int kor) {
		for (int i=0; i<stuArr.length; i++) {
			if(stuArr[i].hakbun.equals(hakbun)) {
				stuArr[i].kor = kor;
				 System.out.println();
				 System.out.println(stuArr[i]);
			}
		}
	}
	//업데이트 모든점수
	static void updateScore(String hakbun, int kor, int math, int eng) {
		Student student = searchStudent(hakbun); //코드 중복을 줄일수 있음.
		if (kor >= 0) {
			student.kor = kor;
		}
		if (math >= 0) {
			student.math = math;
		}
		if (eng >= 0) {
			student.eng = eng;
		}

//		for (int i=0; i<stuArr.length; i++) {
//			if(stuArr[i].hakbun.equals(hakbun)) {
//				//stuArr[i].kor = kor;
//				stuArr[i].kor = (kor>=0) ? kor:stuArr[i].kor ; //삼항연산자쓰면 간결
//				//stuArr[i].math = math;
//				if (math >=0) {
//					stuArr[i].math = math;
//				}
//				//stuArr[i].eng = eng;
//				if (eng >=0) {
//					stuArr[i].eng = eng;
//				}
//				 System.out.println();
//				 System.out.println(stuArr[i]);
//			}
//		}
	}
	
	
	
	
	//검색하기를 메소드로 만들기
	//키워드를 매개변수로 받기.
//		static void searchStudent (String hakbun) {
//			for (int i=0; i<stuArr.length; i++) {
//				if(stuArr[i].hakbun.equals(hakbun)) {
//					 System.out.println();
//					 System.out.println(stuArr[i]);
//				}
//			}
//		}
		
	//void없애고 Student에 return값 넣어도.
		static Student searchStudent(String hakbun) {
			for (int i=0; i<stuArr.length; i++) {
				if (stuArr[i].hakbun.equals(hakbun)) {
					return stuArr[i];
				}
			}
			return null;
		}
		
		
		
		
	
	//메소드를 만들어서 객체생성. 객체를 생성하면서 객체에 넣는것.
		static void insertStudent(int i, String name, String hakbun, String address,
											int kor, int math, int eng) {
			stuArr[i] = new Student(name, hakbun, address, kor, math, eng);
			//지역변수여서 원래 이 내에서밖에 못쓰고 위 메소드랑 연동 불가하지만, 
			//static붙이면 가능. 단 전체에 하나여야. 되도록쓰지않기.
		}
		
		
		
		
}
