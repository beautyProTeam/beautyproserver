package com.bishe.beautyProServer.Dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bishe.beautyProServer.Pojo.GoodInfoPojo;

@Repository
public interface GoodInfoDao {
	public List<GoodInfoPojo> getGoodInfo(Map map);
}
