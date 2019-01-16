package com.bishe.beautyProServer.Service;
import java.util.Map;

import com.bishe.beautyProServer.Pojo.UserPojo;

public interface UserService {
	public int addUser(UserPojo user);
	
	public UserPojo selectUser(Map map);
	
	public UserPojo selectUserByPhonenum(String phonenum,String password);
	
	public UserPojo selectUserByEmail(String email,String password);
	
	public int updateUser(Map map);
}
