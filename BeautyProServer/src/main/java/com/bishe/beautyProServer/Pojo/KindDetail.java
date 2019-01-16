package com.bishe.beautyProServer.Pojo;

public class KindDetail extends BasePojo{
	private String detailName;
	private Kind kind;
	private SmallKind smallKind;

	public String getDetailName() {
		return detailName;
	}

	public void setDetailName(String detailName) {
		this.detailName = detailName;
	}

	public Kind getKind() {
		return kind;
	}

	public void setKind(Kind kind) {
		this.kind = kind;
	}

	public SmallKind getSmallKind() {
		return smallKind;
	}

	public void setSmallKind(SmallKind smallKind) {
		this.smallKind = smallKind;
	}
	
	
}
