package bankingApp;

import java.text.DecimalFormat;
import java.util.Scanner;
 
public class BankingApp {
	static Scanner scan = new Scanner(System.in);
	static int i = 0;
	static int[] accountNum = new int[100];//계좌번호
	static String[] accountPw = new String[100];//비밀번호
	static int[] accountMon = new int[100];//계좌잔액
	static String[] names = new String[100];//고객이름
	static DecimalFormat decFormat = new DecimalFormat("###,###");


	public static void main(String[] args) {
		
		boolean run = true;
		while (run) {
			System.out.println("--------------중앙은행-----------------");
			System.out.println("1.계좌생성/삭제|2.입금|3.출금|4.잔액확인|5.종료");
			System.out.println("------------------------------------");
			System.out.print("원하는 번호를 눌러주세요>>");

			int selectNum = scan.nextInt();

			if (selectNum == 1) {
				Account();
			} else if (selectNum == 2) {
				Save();
			} else if (selectNum == 3) {
				Withdraw();
			} else if (selectNum == 4) {
				AccountList();
			} else if (selectNum == 5) {
				run = false;
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}

		}
	}

	private static void Account() {//계좌생성, 삭제
		

		int selectNum;
		// 계좌를 생성 또는 삭제 하려면 눌러야 하는 번호입력
		// 계좌삭제를 위한 계좌번호의 번호 || 정수개의 account num의 방개수느 100개
		int account = 0;
		
		String password = null;
		String doubleCheck = null;
		int check = 0;
		String name = null;
		boolean run = true;

//			변수 라인 끝

		while (run) {
			System.out.println("계좌생성 :: 1번. || 계좌 삭제 :: 0번.");
			selectNum = scan.nextInt();
			if (selectNum == 1) {
				System.out.println("고객님의 성함을 적어 주세요");
				name = scan.next();
				System.out.println("성함이 " + name + " 맞습니까?\n 맞으시면 1번, 다시 작성하시려면 2번을 눌러주세요");
				check = scan.nextInt();
				while (check == 2) {
					System.out.println("고객님의 성함을 적어 주세요");
					name = scan.next();
					System.out.println("맞으시면 1번, 다시 작성은 2번을 눌러주세요");
					check = scan.nextInt();
				}
				names[i] = name;
				check = 0;

				account = (int) ((Math.random() + 1) * 10000);
				accountNum[i] = account;
				accountMon[i] = 0;
//				i = i + 1;

				// 계좌번호 중복을 걸러내는 과정
				while (accountNum[i] != account) {
					account = (int) ((Math.random() + 1) * 10000);
					// 자기자신을 불러오는 함수 만들기, 또다시 중복이면 작동안함.
				}
//				i = i - 1;

				System.out.println("고객님의 계좌번호는" + accountNum[i] + "입니다.");
				System.out.println("고객님의 계좌번호에 사용할 비밀번호를 입력해주세요.");
				password = scan.next();
				System.out.println("비밀번호를 한번 더 입력해주세요");
				doubleCheck = scan.next();
				
//				i = i + 1;
				
				// 비밀번호가 일치 하지 않는 경우
				while (!password.equals(doubleCheck)) {

					// return으로 함수 자기 자신호출 해주는거 만들기!!

					System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요");
					password = scan.next();
					System.out.println("비밀번호를 한번 더 입력해주세요");
					doubleCheck = scan.next();
				}
				accountPw[i] = doubleCheck;  
				i = i + 1;
				run = false;

			} else if (selectNum == 0) {
				while (check != 2) {
					System.out.println("!!계좌번호를 정확히 입력해주세요!!\n계속 진행은 1번, 돌아가시려면 2번을 눌러주세요");
					check = scan.nextInt();
					if (check == 2)
						break;
					System.out.println("**주의 : 삭제된 계좌는 복구할 수 없습니다**");
					System.out.println("삭제할 계좌번호를 입력해 주세요");
					account = scan.nextInt();
					System.out.println("비밀번호를 입력해주세요");
					doubleCheck = scan.next();

					if (account != accountNum[i]) {
						for (int i = 0; i < 100; i++) {
							if (accountNum[i] != 0 && account == accountNum[i] && doubleCheck.equals(accountPw[i])) {
								accountNum[i] = 0;
								accountPw[i] = "";
								System.out.println(accountNum[i]);
								System.out.println(accountPw[i]);
								System.out.println("계좌번호가 삭제 되었습니다\n다른 계좌를 삭제하시려면 1번, 종료는 2번을 눌러주세요.");
								check = scan.nextInt();
							
							}
						}
					} else if (account == accountNum[i]) {
						accountNum[i] = 0;
						accountPw[i] = null;
						System.out.println("계좌번호가 삭제 되었습니다\n다른 계좌를 삭제하시려면 1번, 종료는 2번을 눌러주세요.");
						check = scan.nextInt();
					}

				}

			}
			if (check == 2)
				break;
		}
	}

	private static void Save() {// 예금
		boolean saverun = true;
		int run = 1;
		int input_account = 0;
		int input_save = 0;
		int index = 0;
		
		while (saverun) {
			switch (run) {
			case 1:
				System.out.print("계좌번호를 입력해주세요.");
				input_account = scan.nextInt();
			case 2:
				i = 0;
				while (i < 100) {   //계좌번호 배열에서 인덱스 찾기 
					if (input_account == accountNum[i]) {
						index = i;
						break;
					} else {
						i++;
					}
				}
				
				if (input_account == accountNum[index]) {
					run = 3;
					break;
				} else {
					System.out.println("존재하지 않는 계좌번호입니다. 다시 입력하시겠습니까?");
					System.out.println("1.다시입력 | 2.종료");
						int select = scan.nextInt();
						if (select == 1) {
						run = 1;
						break;
						} else {
							saverun = false;
							break;
						}
				}

			case 3:
				System.out.print("예금액:");
				input_save = scan.nextInt();

			case 4:
				accountMon[index] += input_save;
				System.out.println("잔액 : " + decFormat.format(accountMon[index]) + "원");

			case 5:
				System.out.println("종료합니다.");
				saverun = false;

			}// switch(run).닫기
//			scan.close();
		} // while(saverun).닫기
	}

	private static void Withdraw() { // 출금
		boolean withrun = true;
		int run = 1;
		int input_account = 0;
		int index = 0;

		while (withrun) {
			switch (run) {
			case 1:
				System.out.print("계좌번호를 입력해주세요.");
				input_account = scan.nextInt();
			case 2:
				i = 0;
				while (i < 100) {   //계좌번호 배열에서 인덱스 찾기 
					if (input_account == accountNum[i]) {
						index = i;
						break;
					} else {
						i++;
					}
				}
				
				if (input_account == accountNum[index]) {
					run = 3;
					break;
				} else {
					System.out.println("존재하지 않는 계좌번호입니다. 다시 입력하시겠습니까?");
					System.out.println("1.다시입력 | 2.종료");
						int select = scan.nextInt();
						if (select == 1) {
						run = 1;
						break;
						} else {
							withrun = false;
							break;
						}
				}
			case 3:
				System.out.print("비밀번호를 입력해주세요.");
				String input_pwd = scan.next();

				if (!input_pwd.equals(accountPw[index])) {
					System.out.println("비밀번호가 일치하지 않습니다. 다시 입력하시겠습니까?");
					System.out.println("1.다시입력 | 2.종료");
					int select = scan.nextInt();
					if (select == 1) {
					run = 3;
					break;
					} else {
						withrun = false;
						break;
					}

				} else if (input_pwd.equals(accountPw[index])) {
					run = 4;
					break;
				}

			case 4:
				int code = (int) ((Math.random() + 1) * 10); //인증코드 랜덤생성
				Emoji(); //두둠칫 이모티콘 
				System.out.println("당신은 로봇이 아닙니까?");
				System.out.println("인증코드:" + code);
				System.out.println("인증코드를 입력해주세요>>");
				int input_code = scan.nextInt();

				if (input_code == code) {
					System.out.print("출금액:");
					int input_withdraw = scan.nextInt();

					// 잔액부족
					while (input_withdraw > accountMon[index]) {
						System.out.println("잔액이 부족합니다. 다시 입력하시겠습니까?");
						System.out.println("1.다시입력 | 2.종료");
							int select = scan.nextInt();
							if (select == 1) {
								System.out.print("출금액:");
								input_withdraw = scan.nextInt();
						} else {
							withrun = false;
							break;
						}
					}

					// 잔액확인
					accountMon[index] -= input_withdraw;
					System.out.println("잔액:" + decFormat.format(accountMon[index]) + "원");
				} else {
					System.out.println("인증코드가 일치하지 않습니다.");
					run = 4;
					break;
				}

			case 5:
				System.out.println("종료합니다.");
				withrun = false;

			}// switch(run).닫기
		} // while(withrun).닫기
	}

	private static void AccountList() { // 계좌잔액확인
		i = 0;
		System.out.println("계좌를 입력해주세요.");
		int input_account = scan.nextInt();
		while (i < 100) {
			if (input_account != accountNum[i]) {
				i++;

			} else if (input_account == accountNum[i]) {
				System.out.println(names[i] + " 님의 잔액은 " + decFormat.format(accountMon[i]) + "원 입니다.");
				break;
			}
		}

	}
	private static void Emoji() {
		System.out.println("⊂_ヽ ");
		System.out.println("　  ＼＼ Λ＿Λ ");
		System.out.println("　　  ＼( 'ㅅ' ) ");
		System.out.println("　　 　 >　⌒ヽ ");
		System.out.println("　 　　/ 　 へ＼ ");
		System.out.println("　 　 /　　/　＼＼ ");
		System.out.println("　 　 ﾚ　ノ　　 ヽ_つ ");
		System.out.println("　 　/　/ ");
		System.out.println(" 　 /　/| ");
		System.out.println(" 　(　(ヽ ");
		System.out.println("　 |　|、＼ ");
		System.out.println(" 　| 丿 ＼ ⌒) ");
		System.out.println("　 | |　　) / ");
		System.out.println("(`ノ )　　Lﾉ");
	}
	
	}


