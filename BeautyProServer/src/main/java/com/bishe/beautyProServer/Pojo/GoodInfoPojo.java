package com.bishe.beautyProServer.Pojo;

import java.io.Serializable;
//商品详情
public class GoodInfoPojo extends BasePojo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String enName;
	private String subName;
	private String imgUrl;//商品图片地址
	private String guige;
	private String huohao;
	private String productAddress;//商品生产地
	private String mainContain;//商品主要成分
	private String effect;//商品功效
	private double price;//商品价格
	private String desktopHtml;//商品详情大图片
	private Integer goodId;//商品id
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
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getGuige() {
		return guige;
	}
	public void setGuige(String guige) {
		this.guige = guige;
	}
	public String getHuohao() {
		return huohao;
	}
	public void setHuohao(String huohao) {
		this.huohao = huohao;
	}
	public String getProductAddress() {
		return productAddress;
	}
	public void setProductAddress(String productAddress) {
		this.productAddress = productAddress;
	}
	public String getMainContain() {
		return mainContain;
	}
	public void setMainContain(String mainContain) {
		this.mainContain = mainContain;
	}
	public String getEffect() {
		return effect;
	}
	public void setEffect(String effect) {
		this.effect = effect;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDesktopHtml() {
		return desktopHtml;
	}
	public void setDesktopHtml(String desktopHtml) {
		this.desktopHtml = desktopHtml;
	}
	public Integer getGoodId() {
		return goodId;
	}
	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}
	
	
}
