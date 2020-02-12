package com.zjm.schoolmarket.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zjm.schoolmarket.BaseTest;
import com.zjm.schoolmarket.entity.Area;
import com.zjm.schoolmarket.entity.PersonInfo;
import com.zjm.schoolmarket.entity.Shop;
import com.zjm.schoolmarket.entity.ShopCategory;

public class ShopDaoTest extends BaseTest{
	@Autowired
	private ShopDao shopDao;
	
	@Test
	@Ignore
	public void testInsertShop() {
		Shop shop = new Shop();
		PersonInfo owner = new PersonInfo();
		Area area = new Area();
		ShopCategory shopCategory = new ShopCategory();
		owner.setUserId(1L);
		area.setAreaId(2);
		shopCategory.setShopCategoryId(1L);
		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("喜茶");
		shop.setShopDesc("一家很好喝的奶茶店");
		shop.setShopAddr("北门小吃街");
		shop.setPhone("13279536765");
		shop.setShopImg("test");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("审核中");
		int effectedNum = shopDao.insertShop(shop);
		assertEquals(1, effectedNum);	
	}
	
	@Test
	public void testUpdateShop() {
		Shop shop = new Shop();		
		shop.setShopId(2L);
		shop.setShopDesc("一家非常好喝的奶茶店");
		shop.setShopAddr("北门美食城");
		shop.setShopImg("美图");
		shop.setLastEditTime(new Date());
		int effectedNum = shopDao.updateShop(shop);
		assertEquals(1, effectedNum);		
	}

}
