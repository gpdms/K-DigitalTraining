package chap03_1124;

public class ForEx {

	public static void main(String[] args) {
		for (int j=10; j>0; j--) {
			System.out.println(j);
		}
		int sum = 0;
		int i=1;
		for (; i <10;) {
			
			System.out.println(i);
			sum = sum + i;
			i++;
		}
		System.out.println(sum);
	}

}
