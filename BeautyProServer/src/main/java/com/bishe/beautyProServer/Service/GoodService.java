package com.bishe.beautyProServer.Service;

import java.util.List;
import java.util.Map;

import com.bishe.beautyProServer.Pojo.GoodPojo;

public interface GoodService {
	public List<GoodPojo> goodList(Integer id,String name,String enName,Integer kind_id,Integer small_kind_id,Integer kind_detail_id,Integer brand_id,double price,String imgUrl,int offset,int limit); 
	
	public long countGoods(Map map); 
}
