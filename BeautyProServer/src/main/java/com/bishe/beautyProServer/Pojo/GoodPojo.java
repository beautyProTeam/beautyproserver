package com.bishe.beautyProServer.Pojo;

import java.io.Serializable;

public class GoodPojo extends BasePojo implements Serializable{
	private String name;//商品名称
	private String enName;//英文名
	private String imgUrl;//图片地址
	private double price;//价格
	/*private KindPojo kind;//大类
	private SmallKindPojo smallKind;//小类
	private KindDetailPojo kindDetail;//类别详情
	private BrandPojo brand;*/
	private Integer kind_id;
	private Integer small_kind_id;
	private Integer kind_detail_id;
	private Integer brand_id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEnName() {
		return enName;
	}
	public void setEnName(String enName) {
		this.enName = enName;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	/*public KindPojo getKind() {
		return kind;
	}
	public void setKind(KindPojo kind) {
		this.kind = kind;
	}
	public SmallKindPojo getSmallKind() {
		return smallKind;
	}
	public void setSmallKind(SmallKindPojo smallKind) {
		this.smallKind = smallKind;
	}
	public KindDetailPojo getKindDetail() {
		return kindDetail;
	}
	public void setKindDetail(KindDetailPojo kindDetail) {
		this.kindDetail = kindDetail;
	}
	public BrandPojo getBrand() {
		return brand;
	}
	public void setBrand(BrandPojo brand) {
		this.brand = brand;
	}*/
	public Integer getKind_id() {
		return kind_id;
	}
	public void setKind_id(Integer kind_id) {
		this.kind_id = kind_id;
	}
	public Integer getSmall_kind_id() {
		return small_kind_id;
	}
	public void setSmall_kind_id(Integer small_kind_id) {
		this.small_kind_id = small_kind_id;
	}
	public Integer getKind_detail_id() {
		return kind_detail_id;
	}
	public void setKind_detail_id(Integer kind_detail_id) {
		this.kind_detail_id = kind_detail_id;
	}
	public Integer getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(Integer brand_id) {
		this.brand_id = brand_id;
	}
	
	
	

}
