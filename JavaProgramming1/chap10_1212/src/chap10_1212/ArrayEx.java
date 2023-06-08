package chap10_1212;

public class ArrayEx {

	public static void main(String[] args) {

		String arr[] = {"가","나","다"};
		System.out.println(arr[5]); //오류
		for (int i=0; i <arr.length ; i++) {
			System.out.println(arr[i]);
		}
	}

}
