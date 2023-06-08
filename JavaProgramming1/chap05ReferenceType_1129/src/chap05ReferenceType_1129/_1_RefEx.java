package chap05ReferenceType_1129;

public class _1_RefEx {
	public static void main (String[] arg) {
		//참조타입
		
		int x = 10, y = 20;
		String str = "연습";
		String str1 = "연습";
		System.out.println(x != y);
		System.out.println(str == str1);
		//컴파일러 입장에서는 똑같은 "연습"이면 같은 메모리주소값에 저장함. 그래서 true로 나옴.
		//메모리주소값만 비교. 스택영역에서만 비교. 힙영역에서 비교안함. .equals는 힙영역에서 비교.
		
		
		//NullPointerException
		String strg = null;
		System.out.println(strg);
		System.out.println(strg.length());
		
	}
}
