package com.bishe.beautyProServer.Service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bishe.beautyProServer.Dao.UserDao;
import com.bishe.beautyProServer.Pojo.UserPojo;
import com.bishe.beautyProServer.Service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public int addUser(UserPojo user) {
		return userDao.createUser(user);
	}

	@Override
	public UserPojo selectUser(Map map) {
		return userDao.selectUser(map);
	}

	@Override
	public UserPojo selectUserByPhonenum(String phonenum, String password) {
		return userDao.selectUserByPhonenum(phonenum, password);
	}

	@Override
	public UserPojo selectUserByEmail(String email, String password) {
		return userDao.selectUserByEmail(email, password);
	}

	@Override
	public int updateUser(UserPojo user) {
		return userDao.updateUser(user);
	}

}
