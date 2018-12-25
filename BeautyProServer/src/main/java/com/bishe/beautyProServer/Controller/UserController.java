package com.bishe.beautyProServer.Controller;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
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
	
	public static final String Object_key="USER";
	
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
		UserPojo user = userService.selectUser(map);
		if(user!=null) {
			redisTemplate.opsForHash().put(Object_key, user.getId().toString(), user);
		}
		return user;
	}
	public UserPojo login(UserPojo user) {
		int updateUser = userService.updateUser(user);
		return user;
	}
}
