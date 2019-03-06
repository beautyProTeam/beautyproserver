package com.bishe.beautyProServer.Controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bishe.beautyProServer.Pojo.UserPojo;

@Controller
@RequestMapping("/api/v1")
public class RedisController {
	@Resource
	protected RedisTemplate<String, Object> redisTemplate;
	
	/**
	 * 获取redis中用户信息
	 * @param key
	 * @param cookieName
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/redis",method= {RequestMethod.GET})
	@ResponseBody
	public Object getRedis(String key,String cookieName,HttpServletRequest request) {
		UserPojo user=new UserPojo();
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
			for (Cookie cookie : cookies) {
				if(StringUtils.isNotBlank(cookie.getName())) {
					if(cookie.getName().equals("userid")&&cookie.getName().equals(cookieName)) {
						user=(UserPojo)redisTemplate.opsForHash().get(key, cookie.getValue());
						break;
					}else {
						long clean=redisTemplate.opsForHash().delete(key, cookie.getValue());
						/*obj=null;*/
					}
				}
			}
		}
		
		return user;
	}
	
	/**
	 * 存某用户购物车商品信息
	 * @param key
	 * @param cookieName
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/redis/goodsInCart",method= {RequestMethod.POST})
	@ResponseBody
	public void save(String key,List goodsinfosAfter) {
		Set<Object> hashkeys = redisTemplate.opsForHash().keys(key);
		Iterator<Object> iterator = hashkeys.iterator();
		while(iterator.hasNext()) {
			String hashkey=(String)iterator.next();
			redisTemplate.expire(hashkey, -1, TimeUnit.SECONDS);
			break;
		}
		redisTemplate.opsForHash().put(key, "goodsinfosAfter", goodsinfosAfter);

	}
	
}
