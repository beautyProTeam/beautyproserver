package com.bishe.beautyProServer.Controller;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bishe.beautyProServer.Pojo.UserPojo;
import com.bishe.beautyProServer.Service.UserService;

@Controller
@RequestMapping("/api/v1")
public class UserController {
	@Autowired
	private UserService userService;
	@Resource
	protected RedisTemplate<String, Object> redisTemplate;
	
	public static final String OBJECT_KEY="USER";
	
	@ResponseBody
	@RequestMapping(value="/regist",method= {RequestMethod.POST})
	public int regist(UserPojo user,HttpServletResponse response) {
		
		user.setNickname("测试注册用户");
		user.setPhonenum("123456789");
		user.setCreateUser(0);
		user.setUpdateDate(new Date());
		user.setCreateDate(new Date());
		return userService.addUser(user);
	}
	
	@ResponseBody
	@RequestMapping(value="/login",method= {RequestMethod.POST})
	public UserPojo login(@RequestParam Map<String,Object> map,HttpSession session,HttpServletResponse response) {
		/*UserPojo u=(UserPojo) redisTemplate.opsForHash().get(Object_key, uid.toString());
		if(u==null) {*/
			UserPojo user = userService.selectUser(map);
			if(user!=null) {
				Cookie cookie=new Cookie("userid", user.getId().toString());
				cookie.setMaxAge(1000*60*60);
			    response.addCookie(cookie);
				redisTemplate.opsForHash().put(OBJECT_KEY, user.getId().toString(), user);
			}
			return user;
		/*}
		return u;*/
	}
	public int login(UserPojo user) {
		int updateUser = userService.updateUser(user);
		return updateUser;
	}
}
