package com.bishe.beautyProServer.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bishe.beautyProServer.Pojo.KindDetailPojo;
import com.bishe.beautyProServer.Service.KindDetailService;

@Controller
@RequestMapping("/api/v1")
public class KindDetailController {
	@Autowired
	private KindDetailService kindDetailService;
	
	@RequestMapping(value="/kindDetail",method= {RequestMethod.GET})
	@ResponseBody
	public List<KindDetailPojo> kindDetailList(@RequestParam Map<String,Object> map){
		List<KindDetailPojo> kindDetailList = kindDetailService.kindDetailList(map);
		return kindDetailList;
	}
	
	@RequestMapping(value="/kindDetails/ids",method= {RequestMethod.GET})
	@ResponseBody
	public List<KindDetailPojo> kindDetails(Integer[] kindDetailIds) {
		return kindDetailService.kindDetails(kindDetailIds);
	}
}
