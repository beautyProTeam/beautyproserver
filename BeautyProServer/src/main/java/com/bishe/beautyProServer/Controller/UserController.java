package com.bishe.beautyProServer.Controller;

import java.util.Date;
import java.util.HashMap;
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
	public String regist(UserPojo user,HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		Integer validateCode = (Integer) session.getAttribute("emailValidateCode");
		if(!user.getValidateCode().equals(validateCode.toString())) {
			return "验证码填写错误";
		}
		user.setNickname("测试注册用户");
		user.setPhonenum("123456789");
		user.setCreateUser(0);
		user.setUpdateDate(new Date());
		user.setCreateDate(new Date());
		UserPojo u = userService.selectUserByEmail(user.getEmail(), user.getPassword());
		if(u!=null) {
			return "改邮箱已被注册";
		}
		userService.addUser(user);
		return "注册成功";
	}
	
	@ResponseBody
	@RequestMapping(value="/login",method= {RequestMethod.POST})
	public UserPojo login(@RequestParam Map<String,Object> map,HttpSession session,HttpServletResponse response) {
			UserPojo user = userService.selectUser(map);
			if(user!=null) {
				Cookie cookie=new Cookie("userid", user.getId().toString());
				/*cookie.setDomain("http://127.0.0.1:8081");*/
				cookie.setPath("/");
				cookie.setMaxAge(60*60);
			    response.addCookie(cookie);
				redisTemplate.opsForHash().put(OBJECT_KEY, user.getId().toString(), user);
			}
			return user;
	}
	
	@ResponseBody
	@RequestMapping(value="/logout",method= {RequestMethod.GET})
	public int logout(HttpServletRequest request,HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if(cookies.length>0) {
			int count=0;
			for(int i=0;i<cookies.length;i++) {
				if(cookies[i]!=null&&cookies[i].getName().equals("userid")) {
					count++;
					redisTemplate.opsForHash().delete(OBJECT_KEY, cookies[i].getValue());
					cookies[i].setMaxAge(0);
					cookies[i].setPath("/");
					cookies[i].setValue("");
		            response.addCookie(cookies[i]); 
					break;
				}
			}
			if(count>0) {
				return 1;//注销成功
			}
			return 0;//存在其他网站的cookie,您还没有登录当前网站
		}else {
			return 0;//您还没有登录
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/user/select",method= {RequestMethod.POST})
	public UserPojo selectUser(@RequestParam Map<String,Object> map,HttpSession session,HttpServletResponse response) {
			UserPojo user = userService.selectUser(map);
			/*if(user!=null) {
				return "redirect:update";
			}
			return "redirect:regist";*/
			if(user!=null) {
				return user;
			}
			return new UserPojo();
	}
	@ResponseBody
	@RequestMapping(value="/user/update",method= {RequestMethod.POST})
	public int updateUser(@RequestParam Map<String,Object> map) {
		int updateUser = userService.updateUser(map);
		return updateUser;
	}
}
