package com.bishe.beautyProServer.Dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bishe.beautyProServer.Pojo.AddressPojo;

@Repository
public interface AddressDao {
	public int createAddress(AddressPojo address);
	public List<AddressPojo> selectAddressList(Map map);
	public AddressPojo selectAddress(Map map);
}
