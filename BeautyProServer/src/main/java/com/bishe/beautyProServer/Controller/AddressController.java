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

import com.bishe.beautyProServer.Pojo.AddressPojo;
import com.bishe.beautyProServer.Service.AddressService;

@Controller
@RequestMapping("/api/v1")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/address")
	@ResponseBody
	public int createAddress(AddressPojo address) {
		int flag = addressService.createAddress(address);
		return flag;
	}
	
	@GetMapping("/address/list")
	@ResponseBody
	public List<AddressPojo> selectAddressList(@RequestParam Map map) {
		List<AddressPojo> addressList = addressService.selectAddressList(map);
		return addressList;
	}
	
	@GetMapping("/address")
	@ResponseBody
	public AddressPojo selectAddress(@RequestParam Map map) {
		AddressPojo address = addressService.selectAddress(map);
		return address;
	}
}
