package chap02;

import java.util.Scanner;
class Bank { //클래스 만들어서 balance를 여기에 넣음.
	int balance = 0; //여기에 설계를 다르게 할 수 있음.
}
//클래스 여러개 만들 수 있지만 public은 하나에만 붙음.
public class Exercise07 {

	public static void main(String[] args) {

//		int balance = 0; //지역변수라 main()메소드 안에서만 작동. 나중에 클래스합칠때 메인메소드 일일이 선언해야하는 번거로움.
		Bank bank = new Bank();
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
					bank.balance = bank.balance + save;
					break;
				case 2:
					System.out.println("출금액:");
					int widthraw = scan.nextInt();
					bank.balance = bank.balance - widthraw;
					break;
				case 3:
					System.out.println("잔고:" + bank.balance);
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
