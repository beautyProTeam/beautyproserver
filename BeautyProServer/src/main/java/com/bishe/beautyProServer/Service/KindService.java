package com.bishe.beautyProServer.Service;

import java.util.List;
import java.util.Map;

import com.bishe.beautyProServer.Pojo.KindPojo;

public interface KindService {
	public List<KindPojo> getKindList(Map map);
}
