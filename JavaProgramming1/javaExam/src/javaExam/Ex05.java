package javaExam;

public class Ex05 {

	public static void main(String[] args) {
		//1부터 6까지의 정수 중 랜덤
		double num = Math.random();
		System.out.println(num);
		
		int c = (int) (num*6+1);
		System.out.println(c);
		
		int c2 = (int) (num*6)+1;
		System.out.println(c2);
	}
          
          
}
