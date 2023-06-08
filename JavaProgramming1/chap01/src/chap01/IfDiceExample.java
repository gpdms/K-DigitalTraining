package chap01;

public class IfDiceExample {

	public static void main(String[] args) {
		int num = (int)(Math.random()*6) + 1;
				
//		if(num==1) {
//			System.out.println("1번이 나왔습니다.");
//		} else if (num == 2) {
//			System.out.println("2번이 나왔습니다.");
//		}	else if (num == 3) {
//			System.out.println("3번이 나왔습니다.");
//		}	else if (num == 4) {
//			System.out.println("4번이 나왔습니다.");
//		}	else if (num == 5) {
//			System.out.println("5번이 나왔습니다.");
//		} else {
//			System.out.println("6번이 나왔습니다.");
//		}
		
		// num의 타입과 switch옆 타입이 같아야함.
		//num이 int니까 switch옆 int들.
		switch(num) {
		case 1:
			System.out.println("1번이 나왔습니다.");
			break;
		case 2:
			System.out.println("2번이 나왔습니다.");
			break;
		case 3:
			System.out.println("3번이 나왔습니다.");
			break;
		case 4:
			System.out.println("4번이 나왔습니다.");
			break;
		case 5:
			System.out.println("5번이 나왔습니다.");
			break;
		default:
			System.out.println("6번이 나왔습니다.");
			break;
		}
		//break윗문장만 실행하고 빠져나간다.

	}

}
