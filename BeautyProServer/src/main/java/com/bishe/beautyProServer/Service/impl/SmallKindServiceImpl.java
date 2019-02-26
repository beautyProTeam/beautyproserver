package com.bishe.beautyProServer.Service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bishe.beautyProServer.Dao.SmallKindDao;
import com.bishe.beautyProServer.Pojo.SmallKindPojo;
import com.bishe.beautyProServer.Service.SmallKindService;

@Service
public class SmallKindServiceImpl implements SmallKindService{
	@Autowired
	private SmallKindDao smallKindDao;
	
	@Override
	public List<SmallKindPojo> smallKindList(Map map) {
		return smallKindDao.smallKindList(map);
	}

}
