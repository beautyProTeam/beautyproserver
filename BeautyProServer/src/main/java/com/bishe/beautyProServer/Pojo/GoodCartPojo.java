package com.bishe.beautyProServer.Pojo;

import java.io.Serializable;

public class GoodCartPojo implements Serializable{
	private Integer cartCount;
	private GoodPojo good;

	public Integer getCartCount() {
		return cartCount;
	}

	public void setCartCount(Integer cartCount) {
		this.cartCount = cartCount;
	}

	public GoodPojo getGood() {
		return good;
	}

	public void setGood(GoodPojo good) {
		this.good = good;
	}
	
	
}
