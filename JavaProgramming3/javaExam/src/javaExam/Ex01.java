package javaExam;

public class Ex01 {
	
	public static void main(String[] args) {
		//두 매개변수의 값 서로 바꾸기
		int a = 10;
		int b = 20;
		int c;
		System.out.printf("x = %d, y = %d \n", a, b);
		
		c = a;
		a = b;
		b = c;
		
		System.out.printf("x = %d, y = %d", a, b);
		
		
		
		

	}

}
