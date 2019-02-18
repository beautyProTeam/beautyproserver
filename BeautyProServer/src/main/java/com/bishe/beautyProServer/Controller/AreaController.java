package com.bishe.beautyProServer.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bishe.beautyProServer.Pojo.AreaPojo;
import com.bishe.beautyProServer.Service.AreaService;

@Controller
@RequestMapping("/api/v1")
public class AreaController {
	
	@Autowired
	private AreaService areaService;
	
	@GetMapping("/area")
	@ResponseBody
	public List<AreaPojo> selectAreaList(Map map) {
		List<AreaPojo> areas = areaService.selectAreaList(map);
		return areas;
	}
}
