package com.zjm.schoolmarket.dao;

import com.zjm.schoolmarket.BaseTest;
import com.zjm.schoolmarket.entity.Area;
import com.zjm.schoolmarket.entity.PersonInfo;
import com.zjm.schoolmarket.entity.Shop;
import com.zjm.schoolmarket.entity.ShopCategory;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShopDaoTest extends BaseTest{
	@Autowired
	private ShopDao shopDao;

	@Test
	public void testQueryShopListAndCount(){
		Shop shopCondition = new Shop();
		ShopCategory childCategory = new ShopCategory();
		ShopCategory parentCategory = new ShopCategory();
		parentCategory.setShopCategoryId(12L);
		childCategory.setParent(parentCategory);
		shopCondition.setShopCategory(childCategory);
		List<Shop> shopList = shopDao.queryShopList(shopCondition,0,1);
		int count = shopDao.queryShopCount(shopCondition);
		System.out.println("店铺列表大小："+shopList.size());
		System.out.println("店铺总数："+count);
	}

	@Test
	@Ignore
	public void testQueryByShopId(){
		long shopId = 1;
		Shop shop = shopDao.queryByShopId(shopId);
		System.out.println("areaId:"+shop.getArea().getAreaId());
		System.out.println("areaName:"+shop.getArea().getAreaName());
	}
	
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
		shop.setShopName("奈雪的茶");
		shop.setShopDesc("一家很好喝的奶茶店");
		shop.setShopAddr("北门小吃街");
		shop.setPhone("15592948773");
		shop.setShopImg("test");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("审核中");
		int effectedNum = shopDao.insertShop(shop);
		assertEquals(1, effectedNum);	
	}
	
	@Test
	@Ignore
	public void testUpdateShop() {
		Shop shop = new Shop();		
		shop.setShopId(1L);
		shop.setShopDesc("test");
		shop.setShopAddr("北门小吃街");
		shop.setShopImg("美图");
		shop.setLastEditTime(new Date());
		int effectedNum = shopDao.updateShop(shop);
		assertEquals(1, effectedNum);		
	}

}
