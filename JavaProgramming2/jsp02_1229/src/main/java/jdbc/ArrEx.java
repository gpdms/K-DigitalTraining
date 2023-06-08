package jdbc;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArrEx {

	public static void main(String[] args) {
		String[] strArr = {"홍", "신", "감"};
		Stream<String> strStr = Arrays.stream(strArr);
		strStr.forEach(n->System.out.println(n));
	}

}
