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
	public List<GoodPojo> goodList(Integer id,String name,String enName,Integer kind_id,Integer small_kind_id,Integer kind_detail_id,Integer brand_id,double price,String imgUrl,int offset,int limit) {
		List<GoodPojo> goodList = goodDao.goodList(id,name,enName,kind_id,small_kind_id,kind_detail_id,brand_id,price,imgUrl,offset,limit);
		return goodList;
	}
	@Override
	public long countGoods(Map map) {
		return goodDao.countGoods(map);
	}
	@Override
	public List<GoodPojo> goods(Map map) {
		return goodDao.goods(map);
	}

}
