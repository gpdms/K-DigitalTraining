package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Cookie;
import java.util.Map;
import java.net.URLEncoder; 
import java.net.URLDecoder; 
import java.io.IOException; 

public class Cookies {
	//필드
	private Map<String, Cookie> cookieMap = 
			new java.util.HashMap<String, Cookie>(); //쿠키값을 키로 찾으려고 Map을씀.
					//request기본객체쓰려고. 기본객체는 쿠키쓰려고 씀.
	
	//생성자
	public Cookies(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies(); //쿠키 여러개 저장
		if (cookies != null) {
			for (int i = 0 ; i < cookies.length ; i++) {
				cookieMap.put(cookies[i].getName(), cookies[i]); //put 넣어줌 (키, 값)
			}
		}
	}
	
	//메소드
	public Cookie getCookie(String name) {
		return cookieMap.get(name);
	}
	//쿠키값 가져오기
	public String getValue(String name) throws IOException {
		Cookie cookie = cookieMap.get(name); //이름 주면 값을 가져옴
		if (cookie == null) {
			return null;
		}
		return URLDecoder.decode(cookie.getValue(), "utf-8");
	}

	public boolean exists(String name) {
		return cookieMap.get(name) != null;
	}

	//3개 메소드 메소드 오버로딩 
	public static Cookie createCookie(String name, String value)
	throws IOException {
		return new Cookie(name, URLEncoder.encode(value, "utf-8"));
	}

	public static Cookie createCookie(String name, String value, String path, 
		int maxAge) throws IOException {
		Cookie cookie = new Cookie(name, URLEncoder.encode(value, "utf-8"));
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		return cookie;
	}
	
	public static Cookie createCookie(String name, String value, String domain,
			String path, int maxAge) throws IOException {
		Cookie cookie = new Cookie(name, URLEncoder.encode(value, "utf-8"));
		cookie.setDomain(domain);
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		return cookie;
	}

}
