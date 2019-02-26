package com.bishe.beautyProServer.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bishe.beautyProServer.Pojo.KindPojo;
import com.bishe.beautyProServer.Pojo.SmallKindPojo;
import com.bishe.beautyProServer.Service.KindService;
import com.bishe.beautyProServer.Service.SmallKindService;

@Controller
@RequestMapping("/api/v1")
public class KindController {

	@Autowired
	private KindService kindService;
	@Autowired
	private SmallKindService smallKindService;
	
	@ResponseBody
	@GetMapping("/kind")
	public List<KindPojo> kindList(@RequestParam Map map){
		List<KindPojo> kindList = kindService.getKindList(map);
		return kindList;
	}
	
	@ResponseBody
	@GetMapping("/kindToSmall")
	public List<KindPojo> kindToSmall(@RequestParam Map map){
		List<KindPojo> kindList = kindService.getKindList(map);
		List resultList = new ArrayList();
		for (KindPojo kindPojo : kindList) {
			Map valuemap=new HashMap();
			Map resultmap=new HashMap();
			valuemap.put("kindId",kindPojo.getId());
			List<SmallKindPojo> smallKindList = smallKindService.smallKindList(valuemap);
			resultmap.put(kindPojo.getId(), smallKindList);
			resultList.add(resultmap);
		}
		
		return resultList;
	}
}
