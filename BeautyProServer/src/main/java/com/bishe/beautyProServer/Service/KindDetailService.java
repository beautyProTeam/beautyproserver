package com.bishe.beautyProServer.Service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bishe.beautyProServer.Pojo.KindDetailPojo;

public interface KindDetailService {
	public List<KindDetailPojo> kindDetailList(Map map);
	
	public List<KindDetailPojo> kindDetails(Integer[] kindDetailIds);
}
