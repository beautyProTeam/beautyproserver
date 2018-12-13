package com.bishe.beautyProServer.Dao;

import org.springframework.stereotype.Repository;

import com.bishe.beautyProServer.Pojo.UserPojo;

@Repository
public interface UserDao {
	public int createUser(UserPojo user);
}
