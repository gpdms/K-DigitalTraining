package javaExam;

import java.util.Scanner;

public class Ex04 {

	public static void main (String[] args) {
		
		try (
		//사용자입력 받아서 구구단
		Scanner scanner = new Scanner(System.in)) {
			System.out.println("숫자 입력>>");
			int i = scanner.nextInt();
			
			for(int j=2; j<=9; j++) {
				System.out.printf("%d X %d = %d \n", i, j, i*j);
			}
		}
	}
}
