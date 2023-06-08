package chap03_1124;

public class AdvancedForEx {

	public static void main(String[] args) {
		// 향상된 for문
		String[] strArray
				= {"김밥", "라면","짜장면","볶음밥","잔치국수"};
		
		//하나씩 가져옴
		for (String str : strArray) {
			System.out.println(str);
		}
	}

}
