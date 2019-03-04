package com.bishe.beautyProServer.Service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bishe.beautyProServer.Dao.KindDao;
import com.bishe.beautyProServer.Pojo.KindPojo;
import com.bishe.beautyProServer.Service.KindService;

@Service
public class KindServiceImpl implements KindService{

	@Autowired
	private KindDao kindDao;
	@Override
	public List<KindPojo> getKindList(Map map) {
		return kindDao.getKindList(map);
	}
	@Override
	public List<KindPojo> kinds(Integer[] kindIds) {
		return kindDao.kinds(kindIds);
	}

}
