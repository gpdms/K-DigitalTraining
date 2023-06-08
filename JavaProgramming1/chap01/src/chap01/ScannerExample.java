package chap01;

import java.util.Scanner;

public class ScannerExample {
	public static void main(String[] args)	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("문자열 입력>> ");
		String inputString = scanner.nextLine();
		System.out.println(inputString);
		System.out.println();
		
		System.out.print("정수 입력> ");
		int inputInt = scanner.nextInt();
		System.out.println(inputInt);
		System.out.println();
		
		System.out.print("실수 입력> ");
		double inputDouble = scanner.nextDouble();
		System.out.println(inputDouble);
		
		scanner.close();
		
		
		
//		int ss;
//		int val = 0;
//		Scanner scan = new Scanner(System.in);
//		for (;;) {
//			System.out.print(">>");
//			ss=scan.nextInt();
//			if (ss == 4) {
//				break;
//			}
//			}
		
	
		
		
		
		
		
		
		
	}
}
