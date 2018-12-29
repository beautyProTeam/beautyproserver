package com.bishe.beautyProServer.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("api/v1")
public class RedisController {
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@RequestMapping(value="/redis",method= {RequestMethod.GET})
	public Object getRedis(String key,String cookieName,HttpServletRequest request) {
		Object obj = null;
		Cookie[] cookies = request.getCookies();
		if(cookies.length>0) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals(cookieName)) {
					redisTemplate.opsForHash().get(key, cookieName);
					break;
				}
			}
		}
		
		return obj;
	}
}
