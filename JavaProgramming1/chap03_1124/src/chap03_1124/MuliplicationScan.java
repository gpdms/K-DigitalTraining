package chap03_1124;

import java.util.Scanner;

public class MuliplicationScan {

	public static void main(String[] args) {
		//중첩 for문
		Scanner scanner = new Scanner(System.in);

		System.out.println("몇단부터 몇단까지 출력할까요?");
		System.out.print("ㅁ단 부터>>");
		int first = scanner.nextInt();
		System.out.print("ㅁ단 까지>>");
		int last = scanner.nextInt();
		int i;
		for (i = first; i <= last; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.print(i + "X" + j + "=" + i * j + '\t');
			}
			System.out.println();
		}

	}

}
