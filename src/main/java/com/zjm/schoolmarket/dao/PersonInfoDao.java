package com.zjm.schoolmarket.dao;

import com.zjm.schoolmarket.entity.PersonInfo;

public interface PersonInfoDao {

	/**
	 * 通过用户Id查询用户
	 * 
	 * @param userId
	 * @return
	 */
	PersonInfo queryPersonInfoById(long userId);

	/**
	 * 添加用户信息
	 * 
	 * @param personInfo
	 * @return
	 */
	int insertPersonInfo(PersonInfo personInfo);

}
