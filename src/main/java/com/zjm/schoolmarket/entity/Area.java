package com.zjm.schoolmarket.entity;

import java.util.Date;

public class Area {
	
	/*
	 * Ϊʲô���������Ͷ����û����������ͣ�
	 * ��ʹ�û����������ͣ���Ϊ��ֵ��0�������ﲻ��Ҫ��0��������������
	 */
		
	// ����ID
	private Integer areaId;
	// ��������
	private String areaName;
	// ����Ȩ�أ�Ȩ��Խ������Խ��ǰ��
	private Integer priority;
	// ����ʱ��
	private Date createTime;
	// ����ʱ��
	private Date lastEditTime;

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
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

	public Date getLastEditTime() {
		return lastEditTime;
	}

	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}
}
