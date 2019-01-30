package com.bishe.beautyProServer.Pojo;

import java.io.Serializable;

public class UserPojo extends BasePojo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nickname;
	private String password;
	private String email;
	private String phonenum;
	private Integer sex=1;
	private String validateCode;//验证码 临时变量
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public int getSex() {
		return sex;
	}
	
	public String getValidateCode() {
		return validateCode;
	}
	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
}
