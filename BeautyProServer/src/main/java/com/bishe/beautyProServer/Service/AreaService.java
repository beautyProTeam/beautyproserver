package com.bishe.beautyProServer.Service;

import java.util.List;
import java.util.Map;

import com.bishe.beautyProServer.Pojo.AreaPojo;

public interface AreaService {
	
	public AreaPojo selectArea(Map map);
	
	public List<AreaPojo> selectAreaList(Map map);
}
