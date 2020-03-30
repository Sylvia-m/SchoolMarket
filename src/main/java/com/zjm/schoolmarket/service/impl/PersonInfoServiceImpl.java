package com.zjm.schoolmarket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjm.schoolmarket.dao.PersonInfoDao;
import com.zjm.schoolmarket.entity.PersonInfo;
import com.zjm.schoolmarket.service.PersonInfoService;

@Service
public class PersonInfoServiceImpl implements PersonInfoService {
	@Autowired
	private PersonInfoDao personInfoDao;

	@Override
	public PersonInfo getPersonInfoById(Long userId) {
		return personInfoDao.queryPersonInfoById(userId);
	}
}
