package com.zjm.schoolmarket.entity;

import java.util.Date;

public class ProductImg {
	private Long ProductImgId;
	//Í¼Æ¬µØÖ·
	private String imgAddr;
	//Í¼Æ¬ËµÃ÷
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
