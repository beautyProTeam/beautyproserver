package com.bishe.beautyProServer.Controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bishe.beautyProServer.Pojo.UserPojo;

@Controller
@RequestMapping("/api/v1")
public class RedisController {
	@Resource
	protected RedisTemplate<String, Object> redisTemplate;
	
	@RequestMapping(value="/redis",method= {RequestMethod.GET})
	@ResponseBody
	public Object getRedis(String key,String cookieName,HttpServletRequest request) {
		Object obj = new Object();
		Cookie[] cookies = request.getCookies();
		if(cookies.length>0) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("userid")&&cookie.getName().equals(cookieName)) {
					if(cookie.getMaxAge()>0) {
						obj=(UserPojo)redisTemplate.opsForHash().get(key, cookie.getValue());
					}else {
						cookie.setMaxAge(0);
						long clean=redisTemplate.opsForHash().delete(key, cookie.getValue());
						obj=null;
					}
					break;
				}
			}
		}
		
		return obj;
	}
}
