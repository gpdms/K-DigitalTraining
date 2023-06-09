package javaExam;

public class Ex07 {

	public static void main(String[] args) {
		//삼항연산자 (조건: nn이 60보다 작으면 "과락" 크면 "합격")
		int nn = 85;
		String ss = (nn < 60 ? "과락" : "합격");
		System.out.println(ss);
		
		
		//조건문
		int mm = 90;
		boolean tt = false;
		
		if ( mm >= 90 && tt==true) {
			System.out.println("mm이 90보다 크거나 같고 tt가 true");
		} else if (mm >80 || tt==false) {
			System.out.println("mm이 80보다 크거나 tt가 false");
		}
		
		
		
		
	}

}
