package com.bishe.beautyProServer.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bishe.beautyProServer.Pojo.GoodInfoPojo;
import com.bishe.beautyProServer.Service.GoodInfoService;

@Controller
@RequestMapping("/api/v1")
public class GoodInfoController {
	@Autowired
	private GoodInfoService goodInfoService;

	@ResponseBody
	@RequestMapping(value="/goodinfo",method= {RequestMethod.GET})
	public List<GoodInfoPojo> goodInfoList(@RequestParam Map map){
		List<GoodInfoPojo> goodInfo = goodInfoService.getGoodInfo(map);
		return goodInfo;
	}
}
