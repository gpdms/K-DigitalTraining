package chap01;

import java.util.Scanner;

public class Exercise07 {

	public static void main(String[] args) {

		int balance = 0;

		Scanner scan = new Scanner(System.in);

		boolean run = true;

		for (;;) {
			if (run == true) {
				System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
				System.out.print("선택>>");
				int input = scan.nextInt();

				switch (input) {
				case 1:
					System.out.print("예금액:");
					int save = scan.nextInt();
					balance = balance + save;
					break;
				case 2:
					System.out.println("출금액:");
					int widthraw = scan.nextInt();
					balance = balance - widthraw;
					break;
				case 3:
					System.out.println("잔고:" + balance);
					break;
				case 4:
					System.out.println("종료합니다.");
					scan.close();
					run = false;
					break;
				}
			}

		}

	}

}
