package com.bishe.beautyProServer.Dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bishe.beautyProServer.Pojo.GoodPojo;

@Repository
public interface GoodDao {
	public List<GoodPojo> goodList(@Param("id") Integer id,@Param("name") String name,@Param("enName") String enName,
			@Param("kind_id") Integer kind_id,@Param("small_kind_id") Integer small_kind_id,
			@Param("kind_detail_id") Integer kind_detail_id,@Param("brand_id") Integer brand_id,
			@Param("price") double price,@Param("imgUrl") String imgUrl,@Param("offset") int offset,
			@Param("limit") int limit); 
	
	public long countGoods(Map map); 
	
	public List<GoodPojo> searchByKey(String key);//根据关键字查询
	
	public List<GoodPojo> goods(Map map); 
}
