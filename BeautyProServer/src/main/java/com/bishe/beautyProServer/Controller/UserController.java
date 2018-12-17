package com.bishe.beautyProServer.Controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
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
	public UserPojo login(@RequestParam Map<String,Object> map) {
		UserPojo user = userService.selectUser(map);
		return user;
	}
	/*public UserPojo login(String email,String password) {
		UserPojo user = userService.selectUserByEmail(email, password);
		return user;
	}*/
}
