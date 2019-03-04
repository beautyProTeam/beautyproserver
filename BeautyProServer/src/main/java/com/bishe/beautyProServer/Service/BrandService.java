package com.bishe.beautyProServer.Service;

import java.util.List;
import java.util.Map;

import com.bishe.beautyProServer.Pojo.BrandPojo;

public interface BrandService {
	public List<BrandPojo> brandList(Map map);
	
	public List<BrandPojo> brands( Integer[] brandIds);
}
