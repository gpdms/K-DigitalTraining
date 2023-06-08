package chap13_2;

public class BoxingEx {

	public static void main(String[] args) {
		Box<Integer> box1 = Util.<Integer>boxing(100);
		System.out.println(box1.getT());
	}

}
