package chap04_1125;

public class ForEx {

	public static void main(String[] args) {
		int[] values = {3, 5, 6, 7, 8};
		
		
		for (int i=0; i < values.length; i++) {
			System.out.println(values[i]);
		}
		

		//향상된 for문
		for (int val : values) {
			System.out.println(val);
		}
	}

}
