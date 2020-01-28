package com.zjm.schoolmarket.entity;

import java.util.Date;

public class HeadLine {
	private Long lineId;
	private String lineLink;
	private String lineImg;
	private Integer priority;
	//0.不可用 1.可用
	private Integer enableStatue;
	private Date createTime;
	private Date lastEditTime;
	
	public Long getLineId() {
		return lineId;
	}
	public void setLineId(Long lineId) {
		this.lineId = lineId;
	}
	public String getLineLink() {
		return lineLink;
	}
	public void setLineLink(String lineLink) {
		this.lineLink = lineLink;
	}
	public String getLineImg() {
		return lineImg;
	}
	public void setLineImg(String lineImg) {
		this.lineImg = lineImg;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Integer getEnableStatue() {
		return enableStatue;
	}
	public void setEnableStatue(Integer enableStatue) {
		this.enableStatue = enableStatue;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastEditTime() {
		return lastEditTime;
	}
	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}
	
	
}
