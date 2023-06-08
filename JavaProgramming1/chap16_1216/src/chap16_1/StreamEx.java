package chap16_1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class StreamEx {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("홍길동", "신용권", "김자바");
		
		//Iterator 이용
//		Iterator<String> iterator = list.iterator();
//		while(iterator.hasNext()) {
//			String name = iterator.next();
//			System.out.println(name);
//		}
//		
//		System.out.println();
		
		//Stream 이용
		Stream<String> st = list.stream();
		st.forEach(n -> System.out.println(n)); //람다식. 추상메소드 하나밖에 없으니까 그 메소드 쓴것. n은 매개변수.
		
		list.stream().forEach(n -> System.out.println(n));
		
	}

}
