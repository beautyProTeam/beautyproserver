package com.bishe.beautyProServer.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("api/v1/session")
public class SessionController {
	/*@RequestMapping(value="/emailCode",method= {RequestMethod.POST})
	public String getEmailValidateCode(@RequestParam("validateCode") String code,HttpSession session) {
		String validate = (String) session.getAttribute("emailValidateCode");
		return validate;
	}*/
}
