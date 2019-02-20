package com.bishe.beautyProServer.Service;

import java.util.List;
import java.util.Map;
import com.bishe.beautyProServer.Pojo.AddressPojo;

public interface AddressService {
	
	public int createAddress(AddressPojo address);
	
	public List<AddressPojo> selectAddressList(Map map);
	
	public AddressPojo selectAddress(Map map);
}
