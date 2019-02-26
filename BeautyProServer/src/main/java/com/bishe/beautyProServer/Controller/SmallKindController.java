package com.bishe.beautyProServer.Controller;

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
public class SmallKindController {
	@Autowired
	private SmallKindService smallKindService;
	@Autowired
	private KindService kindService;
	
	@GetMapping("/smallKind")
	@ResponseBody
	public List<SmallKindPojo> smallKindList(@RequestParam Map<String,Object> map){
		List<SmallKindPojo> smallKindList = smallKindService.smallKindList(map);
		return smallKindList;
	}
	
}
