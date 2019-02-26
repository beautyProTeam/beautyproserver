package com.bishe.beautyProServer.Service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bishe.beautyProServer.Dao.KindDetailDao;
import com.bishe.beautyProServer.Pojo.KindDetailPojo;
import com.bishe.beautyProServer.Service.KindDetailService;
@Service
public class KindDetailServiceImpl implements KindDetailService {
	@Autowired
	private KindDetailDao kindDetailDao;
	
	@Override
	public List<KindDetailPojo> kindDetailList(Map map) {
		return kindDetailDao.kindDetailList(map);
	}

}
