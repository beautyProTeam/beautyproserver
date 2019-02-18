package com.bishe.beautyProServer.Service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bishe.beautyProServer.Dao.AreaDao;
import com.bishe.beautyProServer.Pojo.AreaPojo;
import com.bishe.beautyProServer.Service.AreaService;
@Service
public class AreaServiceImpl implements AreaService {
	@Autowired
	private AreaDao areaDao;
	@Override
	public AreaPojo selectArea(Map map) {
		return areaDao.selectArea(map);
	}

	@Override
	public List<AreaPojo> selectAreaList(Map map) {
		return areaDao.selectAreaList(map);
	}

}
