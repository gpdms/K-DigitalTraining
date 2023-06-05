package test;

import java.util.HashMap;
import java.util.Map;

public class MyHash {
	private static Map<String, String> mh = new HashMap<>();
	
	public static String getMh(String key) {
		return mh.get(key);
	}
	
	public static void setMh(String key, String value) {
		mh.put(key, value);
	}
}
