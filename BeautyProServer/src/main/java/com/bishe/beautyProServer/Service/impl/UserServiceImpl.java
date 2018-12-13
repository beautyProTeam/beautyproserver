package com.bishe.beautyProServer.Service.impl;

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

}
