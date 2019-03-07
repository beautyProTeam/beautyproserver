package com.bishe.beautyProServer.Controller;

import java.util.HashMap;
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
		public Map<String,Object> goods(@RequestParam(required=false) Map map,@RequestParam(value="id",required=false,defaultValue="0") Integer id ,
				@RequestParam(value="name",required=false) String name,@RequestParam(value="enName",required=false) String enName,
				@RequestParam(value="offset",required=false,defaultValue="0") int offset,
				@RequestParam(value="kind_id",required=false,defaultValue="0") Integer kind_id,
				@RequestParam(value="small_kind_id",required=false,defaultValue="0") Integer small_kind_id,
				@RequestParam(value="kind_detail_id",required=false,defaultValue="0") Integer kind_detail_id,
				@RequestParam(value="brand_id",required=false,defaultValue="0") Integer brand_id,
				@RequestParam(value="price",required=false,defaultValue="0") double price,
				@RequestParam(value="imgUrl",required=false) String imgUrl,
				@RequestParam(value="limit",required=false,defaultValue="10") int limit){
			long countGoods = goodService.countGoods(map);
			long page = (countGoods % 10 == 0)? countGoods/10 : countGoods/10+1; 
			List<GoodPojo> goodList = goodService.goodList(id,name,enName,kind_id,small_kind_id,kind_detail_id,brand_id,price,imgUrl,offset,limit);
			int currentPage = offset / limit +1;
			Map map1=new HashMap();
			map1.put("totalPage", page);
			map1.put("rows", goodList);
			map1.put("currentPage", currentPage);
			return map1;
		}
		
		@GetMapping("/good/condition")
		@ResponseBody
		public List<GoodPojo> goods(@RequestParam Map map){
			return goodService.goods(map);
		}
		
}
