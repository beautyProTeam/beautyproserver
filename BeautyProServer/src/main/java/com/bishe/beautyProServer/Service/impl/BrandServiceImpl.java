package com.bishe.beautyProServer.Service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bishe.beautyProServer.Dao.BrandDao;
import com.bishe.beautyProServer.Pojo.BrandPojo;
import com.bishe.beautyProServer.Service.BrandService;
@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandDao brandDao;
	
	@Override
	public List<BrandPojo> brandList(Map map) {
		return brandDao.brandList(map);
	}

	@Override
	public List<BrandPojo> brands(Integer[] brandIds) {
		return brandDao.brands(brandIds);
	}

}
