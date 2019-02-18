package com.bishe.beautyProServer.Pojo;

import java.io.Serializable;

public class AreaPojo extends BasePojo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;//地区名称
	private Integer pid;//地区父级id
	private Integer areaKind;//地区级别 省1 市2 下级市或市区或县3 街道4
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getAreaKind() {
		return areaKind;
	}
	public void setAreaKind(Integer areaKind) {
		this.areaKind = areaKind;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
