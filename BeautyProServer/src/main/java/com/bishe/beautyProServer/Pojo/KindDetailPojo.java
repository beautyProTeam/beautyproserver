package com.bishe.beautyProServer.Pojo;

import java.util.List;

public class KindDetailPojo extends BasePojo{
	private String detailName;
	private KindPojo kind;
	private SmallKindPojo smallKind;
	/*private String pic_url;*/

	public String getDetailName() {
		return detailName;
	}

	public void setDetailName(String detailName) {
		this.detailName = detailName;
	}

/*
	public String getPic_url() {
		return pic_url;
	}

	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}
*/
	public KindPojo getKind() {
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
	
	
}
