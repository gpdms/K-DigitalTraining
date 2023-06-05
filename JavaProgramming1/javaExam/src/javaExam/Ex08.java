package javaExam;

public class Ex08 {

	public static void main(String[] args) {
		// 반복문 탈출
		
		for(char alp = 'A'; alp <= 'Z'; alp++) {
			if(alp=='K') {
				break;
			}
			System.out.println(alp);
		}
		

	}

}
