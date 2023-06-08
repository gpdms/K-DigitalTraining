package chap02;

public class ForEx {

	public static void main(String[] args) {
		int sum = 0;
		int i = 1;
		
		for (; i<=10;) {
			sum = sum + i;
			i++;
		}
		//위for문과 아래 while문 같음.
		while(i<=100) {
			sum = sum + i;
			i++;
		}
		System.out.println(sum);
	}

}
