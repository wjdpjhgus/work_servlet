package util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/*
 * p.222
 */
public class CookieHelper {
	
	// 쿠키를 저장하는 Map
	private Map<String, Cookie> cookieMap = new HashMap<>();
	
	// 클라이언트에 있는 쿠키목록을 받아와서 cookieMap에 저장하는 생성자
	public CookieHelper(HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();
		
		// 쿠키가 존재하면
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				// cookies 배열에 있는 key와 값들을 cookieMap에 put 메소드를 이용하여 저장
				cookieMap.put(cookies[i].getName(), cookies[i]);
			}
		}
	}
	
	// cookieMap에 있는 쿠키 객체 하나를 key를 이용하여 가져온다.
	public Cookie getCookie(String name) {
		return cookieMap.get(name);
	}
	
	// key에 해당하는 값을 바로 가져온다.
	public String getValue(String name) throws UnsupportedEncodingException {
		Cookie cookie = cookieMap.get(name);
		if (cookie == null) {
			return null;
		}
		return URLDecoder.decode(cookie.getValue(), "utf-8");
	}
	
	// key를 입력하여 해당 cookie 객체가 존재하는지 확인하는 메소드
	public boolean exists(String name) {
		return cookieMap.get(name) != null;
	}
	
	/*
	 * static methods
	 */
	
	// key와 값을 전달받아 Cookie 객체를 생성하는 메소드
	public static Cookie createCookie(String name, String value)
			throws UnsupportedEncodingException {
		return new Cookie(name, URLEncoder.encode(value, "utf-8"));
	}
	
	/*
	 *  key, 값, path, maxAge를 전달받아 Cookie 객체를 생성하는 메소드
	 *  path: 해당 하위 경로까지 쿠키를 사용할 수 있다.
	 *  	예) cookie.setPath("/ch09"); -> /ch09 포함해서 이하경로까지 해당 쿠키를 사용할 수 있다.
	 *  maxAge: 해당 시간동안 cookie가 살아있게 설정하는 것 (초 단위 - 1시간 설정하려면 60 * 60)
	 *  	-1: 무제한, 0: 삭제
	 */
	public static Cookie createCookie(String name, String value, String path, int maxAge)
			throws UnsupportedEncodingException {
		Cookie cookie = new Cookie(name, URLEncoder.encode(value, "utf-8"));
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		return cookie;
	}
	
	/*
	 * domain
	 * 예) cookie.setDomain(".koitt.com"); www.koitt.com, mail.koitt.com 등등의 도메인에서만
	 * 		해당 쿠키를 사용할 수 있게 설정
	 *	   cookie.setDomain("www.koitt.com"); www.koitt.com 에서만 해당 쿠키를 사용할 수 있다.
	 */
	public static Cookie createCookie(String name, String value, String domain, String path,
			int maxAge) throws UnsupportedEncodingException {
		Cookie cookie = new Cookie(name, URLEncoder.encode(value, "utf-8"));
		cookie.setDomain(domain);
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		return cookie;
	}
}







