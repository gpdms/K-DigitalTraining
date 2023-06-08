package chap15_1216;

import java.util.HashMap;
import java.util.Map;

public class HashMapEx {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
				//<key, value> :String과 Integer자리 바꾸면 Integer가 키가 됨. 키는 중복X, 값은 중복O.
		
		map.put("신용권", 85);
		map.put("홍길동", 90);
		map.put("동장군", 95);
		map.put("홍길동", 95);
		System.out.println(map.get("홍길동")); //중복시 뒤에것만 나옴.
		
		
		
	}
}
