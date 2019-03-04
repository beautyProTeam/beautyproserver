package com.bishe.beautyProServer.Dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bishe.beautyProServer.Pojo.SmallKindPojo;

@Repository
public interface SmallKindDao {
	public List<SmallKindPojo> smallKindList(Map map);
	
	public List<SmallKindPojo> smallKinds(@Param("smallKindIds") Integer[] smallKindIds);
}
