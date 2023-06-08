package chap07_1201;

public class BbbEx {
	public static void main(String[] args) {
		Bbb dd = new Bbb();
		dd.bbb();
//		dd.b = "연습"; 오류. final은 한번 지정하면 못고친다.
		
		System.out.println(Bbb.PI); //static이니까 클래스명. 으로 호출
		
//		Bbb.PI = 3.14; 오류. final 변경불가
	}

}

