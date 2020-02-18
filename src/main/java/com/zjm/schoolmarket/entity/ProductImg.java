package com.zjm.schoolmarket.entity;

import java.util.Date;

public class ProductImg {
	private Long ProductImgId;
	//图片地址
	private String imgAddr;
	//图片说明
	private String imgDesc;
	private Integer priority;
	private Date createTime;
	private Long productId;

	public Long getProductImgId() {
		return ProductImgId;
	}
	public void setProductImgId(Long productImgId) {
		ProductImgId = productImgId;
	}
	public String getImgAddr() {
		return imgAddr;
	}
	public void setImgAddr(String imgAddr) {
		this.imgAddr = imgAddr;
	}
	public String getImgDesc() {
		return imgDesc;
	}
	public void setImgDesc(String imgDesc) {
		this.imgDesc = imgDesc;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}


}
