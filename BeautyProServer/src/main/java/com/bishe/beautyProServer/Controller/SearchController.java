package com.bishe.beautyProServer.Controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bishe.beautyProServer.Service.GoodService;

@Controller
@RequestMapping("/api/v1")
public class SearchController {
	@Autowired
	private GoodService goodService;
	/*@GetMapping("/search/{key}")
	public List search(@PathVariable String key) {
		if(!StringUtils.isNotBlank(key)) {
		}
		goodService.goodList(map);
	}*/
}
