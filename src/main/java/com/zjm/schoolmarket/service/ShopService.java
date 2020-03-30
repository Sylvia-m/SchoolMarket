package com.zjm.schoolmarket.service;

import com.zjm.schoolmarket.dto.ImageHolder;
import com.zjm.schoolmarket.dto.ShopExecution;
import com.zjm.schoolmarket.entity.Shop;
import com.zjm.schoolmarket.exceptions.ShopOperationException;

public interface ShopService {
    /**
     * 根据shopCondition分页返回相应店铺列表
     * @param shopCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public ShopExecution getShopList(Shop shopCondition,int pageIndex,int pageSize);

    /***
     * 通过Id获取店铺信息
     * @param shopId
     * @return
     */
    Shop getByShopId(Long shopId);
    /***
     * 更新店铺信息，包括对图片的处理
     * @param shop
     * @param thumbnail
     * @return
     * @throws ShopOperationException
     */
    ShopExecution modifyShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;
    /***
     * 注册店铺
     * @param shop
     * @param thumbnail
     * @return
     * @throws ShopOperationException
     */
    ShopExecution addShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;
}
