package com.bishe.beautyProServer.Controller;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		user.setCreateDate(new Date());
		//user.setUpdateDate(null);
		response.setHeader( "Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");
		response.addHeader( "Access-Control-Allow-Origin", "*" ); //���Է��ʴ�����Դ����*Ϊ����
		//response.setHeader("Access-Control-Allow-Origin","http://localhost:8080");
		response.addHeader( "Access-Control-Allow-Methods", "POST,OPTIONS,GET" ); //���Է��ʴ���Ľű���������
		response.addHeader( "Access-Control-Max-Age", "1000" );
		return userService.addUser(user);
	}
}