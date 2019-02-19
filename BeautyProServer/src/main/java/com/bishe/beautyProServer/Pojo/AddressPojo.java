package com.bishe.beautyProServer.Pojo;

import java.io.Serializable;

public class AddressPojo extends BasePojo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String realname;
	private String telphone;
	private String address;
	private Integer uid;
	private Integer defaultAddress;//是否是默认地址 1:默认
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getDefaultAddress() {
		return defaultAddress;
	}
	public void setDefaultAddress(Integer defaultAddress) {
		this.defaultAddress = defaultAddress;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
