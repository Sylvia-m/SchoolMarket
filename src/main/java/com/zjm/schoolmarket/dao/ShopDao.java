package com.zjm.schoolmarket.dao;

import com.zjm.schoolmarket.entity.Shop;


public interface ShopDao {
	/**
	 * 新增店铺
	 * @param shop
	 * @return
	 */
	int insertShop(Shop shop);
	
	/**
	 * 更新店铺
	 * @param shop
	 * @return 
	 */
	int updateShop(Shop shop);
}

