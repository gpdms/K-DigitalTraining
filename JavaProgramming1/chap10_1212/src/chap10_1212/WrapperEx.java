package chap10_1212;

public class WrapperEx {

	public static void main(String[] args) {
		//Wrapper(포장) 클래스
		int x = 10;
		Integer y = new Integer(x); 
		Integer y1 = x; //new안해도 자동 박싱. 
		System.out.println(x == y1); //비교
		//int z = y1. //포장 클래스 쓰는 이유: 메소드가 있음.
		int z = Integer.parseInt("123");
		System.out.println(z);
		int z1 = Integer.valueOf("123");
		System.out.println(z1);
	}

}
