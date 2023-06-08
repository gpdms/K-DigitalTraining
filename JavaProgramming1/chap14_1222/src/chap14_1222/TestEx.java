package chap14_1222;

public class TestEx {

	public static void main(String[] args) {
		Test t = (x) -> {
//			System.out.println(x);
			return Integer.parseInt(x);
		};
		int num = t.m("10");
		System.out.println(num);
	}

}
