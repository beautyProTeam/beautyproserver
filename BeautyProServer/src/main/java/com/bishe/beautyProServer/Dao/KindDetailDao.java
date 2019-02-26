package com.bishe.beautyProServer.Dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bishe.beautyProServer.Pojo.KindDetailPojo;

@Repository
public interface KindDetailDao {
	public List<KindDetailPojo> kindDetailList(Map map);

}
