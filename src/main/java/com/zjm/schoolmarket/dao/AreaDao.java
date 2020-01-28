package com.zjm.schoolmarket.dao;

import java.util.List;

import com.zjm.schoolmarket.entity.Area;

public interface AreaDao {
	/*
	 * 列出区域列表
	 * @return areaList
	 */
	List<Area> queryArea();
}
