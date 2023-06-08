package chap02;

public class ContinueEx {

	public static void main(String[] args) {
		// continue문을 사용한  for문
		for(int i=1; i<=10; i++) {
			if (i%2 !=0) {
				continue;
			}
			System.out.print(i);
		}

	}

}
