package com.bishe.beautyProServer.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bishe.beautyProServer.Pojo.GoodPojo;
import com.bishe.beautyProServer.Service.GoodService;

@Controller
@RequestMapping("/api/v1")
public class GoodController {

		@Autowired
		private GoodService goodService;
		@GetMapping("/good")
		@ResponseBody
		public List<GoodPojo> goods(@RequestParam Map map){
			List<GoodPojo> goodList = goodService.goodList(map);
			return goodList;
		}
}
