package chap03_1124;

public class ArrayEx {

	public static void main(String[] args) {
		// 배열
		
		String[] aa;
		aa = new String [3];
		aa[0] = "0";
		aa[1] = "1";
		aa[2] = "2";
		System.out.println(aa.length);
		for (int i=0; i<aa.length; i++) {
			System.out.println(aa[i]);
		}
	}

}
