package com.bishe.beautyProServer.Dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bishe.beautyProServer.Pojo.KindPojo;

@Repository
public interface KindDao {
	public List<KindPojo> getKindList(Map map);
	public KindPojo getKind(Map map);
	public List<KindPojo> kinds(@Param("kindIds") Integer[] kindIds);
}
