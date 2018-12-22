package com.bishe.beautyProServer.Dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bishe.beautyProServer.Pojo.UserPojo;

@Repository
public interface UserDao {
	public int createUser(UserPojo user);
	
	public UserPojo selectUserByPhonenum(@Param("phonenum") String phonenum,@Param("password") String password);
	
	public UserPojo selectUserByEmail(@Param("email") String email,@Param("password") String password);
	
	/*根据条件动态查询用户*/
	public UserPojo selectUser(Map map);
	
	/*根据条件修改用户信息*/
	public int updateUser(UserPojo user);
	
	
}
