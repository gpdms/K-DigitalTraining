package chap02;

public class BreakEx {

	public static void main(String[] args) {
		// break로 while문 종료
		while(true) {
			int num = (int)(Math.random()*6 + 1);
			System.out.print(num);
			if(num == 6) {
				break;
			}
		}

	}

}
