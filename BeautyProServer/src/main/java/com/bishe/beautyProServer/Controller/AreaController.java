package com.bishe.beautyProServer.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bishe.beautyProServer.Pojo.AreaPojo;
import com.bishe.beautyProServer.Service.AreaService;

@Controller
@RequestMapping("/api/v1")
public class AreaController {
	
	@Autowired
	private AreaService areaService;
	
	@PostMapping("/area")
	@ResponseBody
	public List<AreaPojo> selectAreaList(@RequestParam Map<String,Object> map) {
		List<AreaPojo> areas = areaService.selectAreaList(map);
		return areas;
	}
}
