package com.zjm.schoolmarket.dao;

import com.zjm.schoolmarket.BaseTest;
import com.zjm.schoolmarket.entity.HeadLine;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class HeadLineDaoTest extends BaseTest {
	@Autowired
	private HeadLineDao headLineDao;

	@Test
	public void testQueryArea() {
		List<HeadLine> headLineList = headLineDao.queryHeadLine(new HeadLine());
		assertEquals(4, headLineList.size());
	}
}
