package com.bishe.beautyProServer.Pojo;

import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.servlet.http.HttpSession;

@MappedSuperclass
public class BasePojo {
	/*主键*/
	private Integer id;
	
	/*创建时间*/
	private Date createDate;
	
	/*添加商品的用户*/
	private Integer createUser;
	
	/*更新时间*/
	private Date updateDate;
	
	/*更新商品的用户*/
	private Integer updateUser=0;
	
	/*删除时间*/
	private Date deleteDate;
	
	/*删除商品的用户*/
	private Integer deleteUser=0;
	
	/*是否删除*/
	private boolean deleteFlag;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	public boolean isDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	public Integer getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
	}

	public Integer getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(Integer updateUser) {
		this.updateUser = updateUser;
	}

	public Integer getDeleteUser() {
		return deleteUser;
	}

	public void setDeleteUser(Integer deleteUser) {
		this.deleteUser = deleteUser;
	}

	public void setCreator(HttpSession session) {
		Integer uid=(Integer) session.getAttribute("userid");
		this.setCreateUser(uid);
		this.setCreateDate(new Date());
	}
	
	public void setUpdater(HttpSession session) {
		Integer uid=(Integer) session.getAttribute("userid");
		this.setUpdateUser(uid);
		this.setUpdateDate(new Date());
	}
	
	public void setDeleter(HttpSession session) {
		Integer uid=(Integer) session.getAttribute("userid");
		this.setDeleteUser(uid);
		this.setDeleteDate(new Date());
	}
}
