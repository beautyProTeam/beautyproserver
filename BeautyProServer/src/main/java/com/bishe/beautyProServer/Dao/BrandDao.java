package com.bishe.beautyProServer.Dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bishe.beautyProServer.Pojo.BrandPojo;

@Repository
public interface BrandDao {
	public List<BrandPojo> brandList(Map map);
	public List<BrandPojo> brands(@Param(value = "brandIds") Integer[] brandIds);
}
