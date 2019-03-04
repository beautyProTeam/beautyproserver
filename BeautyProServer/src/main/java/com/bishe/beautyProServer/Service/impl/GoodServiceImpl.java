package com.bishe.beautyProServer.Service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bishe.beautyProServer.Dao.GoodDao;
import com.bishe.beautyProServer.Pojo.GoodPojo;
import com.bishe.beautyProServer.Service.GoodService;
@Service
public class GoodServiceImpl implements GoodService {
	
	@Autowired
	private GoodDao goodDao;
	@Override
	public List<GoodPojo> goodList(Map map) {
		List<GoodPojo> goodList = goodDao.goodList(map);
		return goodList;
	}

}
