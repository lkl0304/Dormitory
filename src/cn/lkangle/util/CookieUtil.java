 package cn.lkangle.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	
	public String getCookie(HttpServletRequest request , String key) {
		Cookie[] cookies = request.getCookies();
		String value = null;
		if(cookies != null)
		{
			for(Cookie cookie : cookies)
			{
				if(key.equals(cookie.getName())){
					value = cookie.getValue();
				}
			}
		}
		return value;
	}
	public void setCookie(HttpServletResponse response, String key, String value) {
		Cookie cookie = new Cookie(key, value);
		cookie.setMaxAge(3600*24*15); // 保存十五天
		response.addCookie(cookie);
	}
	public void delcookie(HttpServletRequest request, HttpServletResponse response, String key)
	{
		Cookie[] cookies = request.getCookies();
		if(cookies != null)
		{
			for(Cookie cookie : cookies)
			{
				if(key.equals(cookie.getName())){
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}
	}
}
