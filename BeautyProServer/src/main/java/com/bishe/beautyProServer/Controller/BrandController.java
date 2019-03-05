package com.bishe.beautyProServer.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bishe.beautyProServer.Pojo.BrandPojo;
import com.bishe.beautyProServer.Service.BrandService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/api/v1")
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	@ResponseBody
	@GetMapping("/brand")
	public List<BrandPojo> brandList(@RequestParam Map map){
		List<BrandPojo> brandList = brandService.brandList(map);
		return brandList;
	}
	@GetMapping("/brands/ids")
	@ResponseBody
	public List<BrandPojo> brands(Integer[] brandIds) {
		List<BrandPojo> brands = brandService.brands(brandIds);
		return brands;
	}
}
