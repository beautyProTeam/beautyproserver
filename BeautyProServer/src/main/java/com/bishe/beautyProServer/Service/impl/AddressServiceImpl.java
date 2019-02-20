package com.bishe.beautyProServer.Service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bishe.beautyProServer.Dao.AddressDao;
import com.bishe.beautyProServer.Pojo.AddressPojo;
import com.bishe.beautyProServer.Service.AddressService;
@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressDao addressDao;

	@Override
	public int createAddress(AddressPojo address) {
		return addressDao.createAddress(address);
	}

	@Override
	public List<AddressPojo> selectAddressList(Map map) {
		return addressDao.selectAddressList(map);
	}

	@Override
	public AddressPojo selectAddress(Map map) {
		return addressDao.selectAddress(map);
	}
	

}
