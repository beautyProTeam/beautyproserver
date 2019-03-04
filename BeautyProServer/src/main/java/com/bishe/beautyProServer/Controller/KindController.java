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

import com.bishe.beautyProServer.Pojo.KindDetailPojo;
import com.bishe.beautyProServer.Pojo.KindPojo;
import com.bishe.beautyProServer.Pojo.SmallKindPojo;
import com.bishe.beautyProServer.Service.KindDetailService;
import com.bishe.beautyProServer.Service.KindService;
import com.bishe.beautyProServer.Service.SmallKindService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/api/v1")
public class KindController {

	@Autowired
	private KindService kindService;
	@Autowired
	private SmallKindService smallKindService;
	@Autowired
	private KindDetailService kindDetailService;
	
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
			/*resultmap.put(kindPojo.getId(), smallKindList);*/
			resultmap.put(JSONObject.fromObject(kindPojo), smallKindList);
			resultList.add(resultmap);
		}
		
		return resultList;
	}
	
	@ResponseBody
	@GetMapping("/kindToSmallToDetail")
	public List<KindPojo> kindToSmallToDetail(@RequestParam Map map){
		List<KindPojo> kindList = kindService.getKindList(map);
		List resultList = new ArrayList();
		for (KindPojo kindPojo : kindList) {
			Map valuemap=new HashMap();
			Map resultmap=new HashMap();
			valuemap.put("kindId",kindPojo.getId());
			List<SmallKindPojo> smallKindList = smallKindService.smallKindList(valuemap);
			List ksResultList = new ArrayList();
			for (SmallKindPojo smallKindPojo : smallKindList) {
				Map ksmap=new HashMap();
				ksmap.put("kindId", kindPojo.getId());
				Map ksResultmap=new HashMap();
				ksmap.put("smallKindId", smallKindPojo.getId());
				List<KindDetailPojo> kindDetailList = kindDetailService.kindDetailList(ksmap);
				ksResultmap.put(JSONObject.fromObject(smallKindPojo), kindDetailList);
				ksResultList.add(ksResultmap);
			}
			/*resultmap.put(JSONObject.fromObject(kindPojo), smallKindList);
			resultList.add(resultmap);*/
			resultmap.put(JSONObject.fromObject(kindPojo), ksResultList);
			resultList.add(resultmap);
		}
		
		return resultList;
	}
	@ResponseBody
	@GetMapping("/kinds/ids")
	public List<KindPojo> kinds(@RequestParam Integer[] kindIds) {
		return kindService.kinds(kindIds);
	}
}
