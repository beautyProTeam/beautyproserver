package com.bishe.beautyProServer.Dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bishe.beautyProServer.Pojo.GoodPojo;

@Repository
public interface GoodDao {
	public List<GoodPojo> goodList(Map map); 
	
	public List<GoodPojo> searchByKey(String key);//根据关键字查询
}
