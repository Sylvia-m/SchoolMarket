package com.zjm.schoolmarket.entity;

import java.util.Date;

public class WechatAuth {
	private Long wechatAuthId;
	private String openId;
	private Date createTime;
	//用户实体类
	private PersonInfo PersonInfo;

	public Long getWechatAuthId() {
		return wechatAuthId;
	}
	public void setWechatAuthId(Long wechatAuthId) {
		this.wechatAuthId = wechatAuthId;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public PersonInfo getPersonInfo() {
		return PersonInfo;
	}
	public void setPersonInfo(PersonInfo personInfo) {
		PersonInfo = personInfo;
	}
}
