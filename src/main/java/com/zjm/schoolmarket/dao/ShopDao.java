package com.zjm.schoolmarket.dao;

import com.zjm.schoolmarket.entity.Shop;

/**
 * 新增店铺
 * @param shop
 * @return
 */
public interface ShopDao {
	int insertShop(Shop shop);
	
	/**
	 * 更新店铺
	 * @param shop
	 * @return 
	 */
	int updateShop(Shop shop);
}

