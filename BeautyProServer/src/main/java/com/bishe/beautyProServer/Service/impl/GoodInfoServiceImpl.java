package com.bishe.beautyProServer.Service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bishe.beautyProServer.Dao.GoodInfoDao;
import com.bishe.beautyProServer.Pojo.GoodInfoPojo;
import com.bishe.beautyProServer.Service.GoodInfoService;
@Service
public class GoodInfoServiceImpl implements GoodInfoService {
	@Autowired
	private GoodInfoDao goodInfoDao;
	
	@Override
	public List<GoodInfoPojo> getGoodInfo(Map map) {
		List<GoodInfoPojo> goodInfo = goodInfoDao.getGoodInfo(map);
		return goodInfo;
	}

}
