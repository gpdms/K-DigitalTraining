package chap16;

import java.util.stream.IntStream;

public class IntStreamEx {
	public static int sum;

	public static void main(String[] args) {
//		IntStream st = IntStream.rangeClosed(1,  10);
//		st.forEach(a-> sum += a);
		IntStream.rangeClosed(1,  10).forEach(a->sum +=a); //위 두줄 합친 것.
		System.out.println("총합: " + sum);
	}

}
